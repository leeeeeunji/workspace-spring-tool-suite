package com.itwill.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.google.gson.Gson;
import com.itwill.security.service.UserDetailsServiceImpl;
import com.security.dto.ResponseDto;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*   auth.inMemoryAuthentication()
		        .withUser(
		                User.withDefaultPasswordEncoder()
		                .username("user1")
		                .password("1111")
		                .roles("USER")
		                .build()
		        );*/
		auth.userDetailsService(userDetailsServiceImpl);

	}

	 @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.formLogin().disable(); // REST API는 UI를 사용하지 않으므로 기본설정을 비활성화
	        
	        httpSecurity.csrf().disable(); // REST API는 csrf 보안이 필요 없으므로 비활성화
	        httpSecurity.authorizeRequests() // 리퀘스트에 대한 사용권한 체크
	            .antMatchers("/create","/exception","/auth","/","/logout_result").permitAll() // 가입 및 로그인 주소는 허용
	            .antMatchers(HttpMethod.GET, "/product/**").permitAll() // product로 시작하는 Get 요청은 허용
	            .antMatchers("**exception**").permitAll()
	            .anyRequest().hasRole("USER"); // 나머지 요청은 인증된 USER만 접근 가능
	        httpSecurity.httpBasic();
	        httpSecurity.logout().logoutUrl("/logout");
	        httpSecurity.logout().logoutSuccessHandler(new LogoutSuccessHandler() {
	        	
	        	
	        	
				@Override
				public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
						throws IOException, ServletException {
					System.out.println(">>>>> 2. CustomLogoutSuccessHandler.onLogoutSuccess");
					ResponseDto responseDto = new ResponseDto();
					responseDto.setCode(0);
					responseDto.setMsg("성공");
					responseDto.setData(authentication.getPrincipal());
					String jsonStr = new Gson().toJson(responseDto);
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(jsonStr);
				}
			});
	        
	        
	    }


	/**
	 * Swagger 페이지 접근에 대한 예외 처리
	 *
	 * @param webSecurity
	 */
	 @Override
	    public void configure(WebSecurity webSecurity) {
	        webSecurity.ignoring().antMatchers( "/v2/api-docs", "/swagger-resources/**",
	        										"/swagger-ui.html", "/webjars/**",
	        										"/swagger/**", "/sign-api/exception",
									            "/v3/api-docs/**",
									            "/swagger-ui/**");
	        
	        webSecurity.ignoring()
            .requestMatchers(
                    PathRequest.toStaticResources().atCommonLocations()
            )
    ;
	    }

	
}
