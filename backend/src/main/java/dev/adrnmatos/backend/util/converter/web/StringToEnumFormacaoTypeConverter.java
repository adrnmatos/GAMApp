package dev.adrnmatos.backend.util.converter.web;

import org.springframework.core.convert.converter.Converter;

import dev.adrnmatos.backend.model.User;
import dev.adrnmatos.backend.model.User.Formacao;

@RequestParamConverter
public class StringToEnumFormacaoTypeConverter implements Converter<String, User.Formacao> {

    @Override
    public Formacao convert(String arg0) {
        return User.Formacao.decode(arg0);
    }
    
}
