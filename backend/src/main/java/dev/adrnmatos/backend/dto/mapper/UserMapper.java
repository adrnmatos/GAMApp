package dev.adrnmatos.backend.dto.mapper;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getName());
        return dto;
    }

    public static User toUserModel(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        return user;
    }
}
