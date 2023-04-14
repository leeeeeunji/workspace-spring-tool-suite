package com.springboot.security.config;




import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration

public class SwaggerConfiguration3 {
	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.OAS_30)
	    			.securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
	            .apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.springboot.security"))
	            .paths(PathSelectors.any())
	            .build();
	}
	/*  @Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .apiInfo(apiInfo())
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.itwill.security"))
	        .paths(PathSelectors.any())
	        .build();
	}*/

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Spring Boot Open API Test with Swagger")
            .description("설명 부분")
            .version("1.0.0")
            .build();
    }
    

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiKey apiKey() {
        //return new ApiKey("JWT", "Authorization", "header");
    		return new ApiKey("JWT", "Authorization", "header");
    }
     
}