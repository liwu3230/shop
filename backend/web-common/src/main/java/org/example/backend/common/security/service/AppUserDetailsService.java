
package org.example.backend.common.security.service;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.security.entity.SecurityAppUser;
import org.example.backend.common.service.business.AppUserService;
import org.example.backend.common.utils.T;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 10:45
 */
@Slf4j
@Service
public class AppUserDetailsService implements UserDetailsService {

    @Resource
    private AppUserService appUserService;

    @Override
    public SecurityAppUser loadUserByUsername(String userId) throws UsernameNotFoundException {
        AppUser appUser = appUserService.getById(T.parse(userId, 0));
        return new SecurityAppUser(appUser);
    }


}
