package dev.adrnmatos.backend.dto.mapper;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }
}
