package com.smartlook.userservice.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.smartlook.userservice.dto.UserDto;
import com.smartlook.userservice.model.User;

@Service
public class UserMapper {
    public UserDto mapUserToUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
