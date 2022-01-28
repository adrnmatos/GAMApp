package dev.adrnmatos.backend.config;

import java.util.Map;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dev.adrnmatos.backend.util.converter.web.RequestParamConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ListableBeanFactory beanFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        Map<String, Object> components = beanFactory.getBeansWithAnnotation(RequestParamConverter.class);
        components.values().parallelStream().forEach(c -> {
            if(c instanceof Converter) {
                registry.addConverter((Converter)c);
            }
        });
    }
}
