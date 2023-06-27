package com.example.LearnHub.config;

import com.example.LearnHub.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    private User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Возвращает роли или права пользователя
        // Здесь вы должны предоставить соответствующие роли или права пользователя
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // Возвращает пароль пользователя
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Возвращает имя пользователя
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // Другие методы интерфейса UserDetails

    public static UserPrincipal create(User user) {
        return new UserPrincipal(user);
    }
}
