package com.security.dto;

import java.util.Set;

import org.apache.tomcat.util.buf.UEncoder.SafeCharsSet;

import groovy.transform.builder.InitializerStrategy.SET;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
	
	private Long id;
	
    private String userid;

    private String password;

    private String name;
   
    private String role;
    
    @Builder.Default
    private Set<String> roles=new HashSet();

}