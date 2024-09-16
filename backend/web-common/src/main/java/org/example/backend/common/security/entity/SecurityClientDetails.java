package org.example.backend.common.security.entity;

import lombok.Data;
import org.example.backend.common.utils.CommaSplitUtils;
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
public class SecurityClientDetails implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private ClientDetails clientDetails;

    public SecurityClientDetails(ClientDetails clientDetails) {
        this.clientDetails = clientDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String url : CommaSplitUtils.toList(this.clientDetails.getResourceIds())) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(url);
            authorities.add(authority);
        }
        return authorities;
    }

    public String getClientId() {
        return this.clientDetails.getClientId();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.clientDetails.getClientId();
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
