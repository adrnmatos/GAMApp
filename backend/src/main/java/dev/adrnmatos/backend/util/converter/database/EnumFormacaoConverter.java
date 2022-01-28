package dev.adrnmatos.backend.util.converter.database;

import java.util.Optional;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.stereotype.Component;

import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.model.User.Formacao;

@Component
@Converter(autoApply = true)
public class EnumFormacaoConverter implements AttributeConverter<User.Formacao, String> {

    @Override
    public String convertToDatabaseColumn(Formacao attribute) {
        
        return Optional.ofNullable(attribute).map(User.Formacao::getCode).orElse(null);
    }

    @Override
    public Formacao convertToEntityAttribute(String dbData) {
        
        return User.Formacao.decode(dbData);
    }
    
}
