package dev.adrnmatos.backend.dto.mapper;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto(user.getId(), user.getName());
        return dto;
    }
}
