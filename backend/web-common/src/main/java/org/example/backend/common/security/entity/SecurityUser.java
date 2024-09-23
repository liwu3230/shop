package org.example.backend.common.security.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.primary.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 11:01
 */
@Data
public class SecurityUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    private SysUser sysUser;

    /**
     * 权限信息
     */
    private List<String> permissionList;

    private Boolean superAdmin;

    public SecurityUser(SysUser sysUser, List<String> permissionList, Boolean superAdmin) {
        this.sysUser = sysUser;
        this.permissionList = permissionList;
        this.superAdmin = superAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissionList) {
            if (StringUtils.isBlank(permission)) {
                continue;
            }
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
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
