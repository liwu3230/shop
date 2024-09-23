package org.example.backend.common.service;

import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysUserDto;
import org.example.backend.common.model.param.SysUserParam;
import org.example.backend.common.primary.entity.SysUser;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/26 18:25
 */
public interface SysUserService {

    Page<SysUserDto> pageList(SysUserParam param);

    SysUser findByUserName(String userName);

    List<String> queryPermsByUserName(String userName);

    Map<String, Set<Integer>> loadUrlPermissions();

    SysUser findById(Integer userId);

    List<SysUser> findAllList();

    List<SysUser> findByIds(List<Integer> userIds);

    void addOrEdit(SysUserParam param);

    void deleteById(Integer id);

    String resetPassword(Integer id);

    void updatePassword(Integer id, String password);

    List<Integer> findNormalRoleIdsByUserId(Integer userId);

}
