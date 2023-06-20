package com.example.LearnHub.models;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SportLevelConverter implements Converter<String, User.SportLevel> {
// это пользовательский класс, который предназначен для преобразования
// значения SportLevel между строкой и объектом.
    @Override
    public User.SportLevel convert(String source) {
        return User.SportLevel.valueOf(source);
    }
}
