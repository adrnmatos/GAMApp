package dev.adrnmatos.backend.dto.mapper;

import dev.adrnmatos.backend.dto.UserDto;
import dev.adrnmatos.backend.model.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        
        dto.setName(user.getName());
        dto.setMatricula(user.getMatricula());
        dto.setDataAdmissao(user.getDataAdmissao());
        dto.setEmail(user.getEmail());
        dto.setTelefone(user.getTelefone());
        dto.setEhAtivo(user.getEhAtivo());
        dto.setCargo(user.getCargo());
        dto.setFuncao(user.getFuncao());
        dto.setFormacao(user.getFormacao());

        return dto;
    }

    public static User toUserModel(UserDto userDto) {
        User user = new User();
        
        user.setName(userDto.getName());
        user.setMatricula(userDto.getMatricula());
        user.setDataAdmissao(userDto.getDataAdmissao());
        user.setEmail(userDto.getEmail());
        user.setTelefone(userDto.getTelefone());
        user.setEhAtivo(userDto.isEhAtivo());
        user.setCargo(userDto.getCargo());
        user.setFuncao(userDto.getFuncao());
        user.setFormacao(userDto.getFormacao());
        
        return user;
    }
}
