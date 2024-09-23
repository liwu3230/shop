
package org.example.backend.common.security.service;

import lombok.extern.slf4j.Slf4j;

import org.example.backend.common.security.entity.SecurityAppUser;
import org.example.backend.common.util.T;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 10:45
 */
@Slf4j
@Service
public class AppUserDetailsService implements UserDetailsService {


    @Override
    public SecurityAppUser loadUserByUsername(String userId) throws UsernameNotFoundException {

        return null;
    }


}
