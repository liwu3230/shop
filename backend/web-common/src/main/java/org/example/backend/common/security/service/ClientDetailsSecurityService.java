package org.example.backend.common.security.service;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.security.entity.SecurityClientDetails;
import org.example.backend.common.service.ClientDetailsService;
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
public class ClientDetailsSecurityService implements UserDetailsService {

    @Resource
    private ClientDetailsService clientDetailsService;

    @Override
    public SecurityClientDetails loadUserByUsername(String clientId) throws UsernameNotFoundException {
        ClientDetails clientDetails = clientDetailsService.getById(clientId);
        return new SecurityClientDetails(clientDetails);
    }

}
