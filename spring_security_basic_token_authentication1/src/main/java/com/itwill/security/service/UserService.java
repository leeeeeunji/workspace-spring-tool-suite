package com.itwill.security.service;


import com.security.dto.UserDto;


public interface UserService {
	
    UserDto create(UserDto userDto)throws RuntimeException;;
    void logout()throws RuntimeException;
    UserDto view(Long id) throws RuntimeException;
    UserDto update(UserDto userDto) throws RuntimeException;
    UserDto delete(Long id) throws RuntimeException;
}