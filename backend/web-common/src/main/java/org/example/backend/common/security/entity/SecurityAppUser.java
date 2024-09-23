package org.example.backend.common.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 11:01
 */
@Data
public class SecurityAppUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    public SecurityAppUser() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String[] premUrls = {"/app/**", "/file/**"};
        for (String premUrl : premUrls) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(premUrl);
            authorities.add(authority);
        }
        return authorities;
    }

    public Integer getUserId() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
