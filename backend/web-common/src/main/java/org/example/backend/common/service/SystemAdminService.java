package org.example.backend.common.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.example.backend.common.model.req.SystemAdminAddRequest;
import org.example.backend.common.model.req.SystemAdminRequest;
import org.example.backend.common.model.req.SystemAdminUpdateRequest;
import org.example.backend.common.model.resp.SystemAdminResponse;
import org.example.backend.common.primary.base.dao.SystemAdminDao;
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemAdminExample;
import org.example.backend.common.utils.AESUtil;
import org.example.backend.common.utils.T;
import org.example.backend.common.utils.ValidateFormUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class SystemAdminService {

    @Resource
    SystemAdminDao systemAdminDao;
    @Resource
    SystemRoleService systemRoleService;

    /**
     * 后台管理员列表
     */
    public List<SystemAdminResponse> getList(SystemAdminRequest request) {
//        PageHelper.startPage(pageParamRequest.getPage(), pageParamRequest.getLimit());
//
//        //带SystemAdminRequest类的多条件查询
//        LambdaQueryWrapper<SystemAdmin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        if (StrUtil.isNotBlank(request.getRoles())) {
//            lambdaQueryWrapper.eq(SystemAdmin::getRoles, request.getRoles());
//        }
//        if (ObjectUtil.isNotNull(request.getStatus())) {
//            lambdaQueryWrapper.eq(SystemAdmin::getStatus, request.getStatus());
//        }
//        if (StrUtil.isNotBlank(request.getRealName())) {
//            lambdaQueryWrapper.and(i -> i.like(SystemAdmin::getRealName, request.getRealName())
//                    .or().like(SystemAdmin::getAccount, request.getRealName()));
//        }
//        List<SystemAdmin> systemAdmins = dao.selectList(lambdaQueryWrapper);
//        if (CollUtil.isEmpty(systemAdmins)) {
//            return CollUtil.newArrayList();
//        }
//        List<SystemAdminResponse> systemAdminResponses = new ArrayList<>();
//        List<SystemRole> roleList = systemRoleService.getAllList();
//        for (SystemAdmin admin : systemAdmins) {
//            SystemAdminResponse sar = new SystemAdminResponse();
//            BeanUtils.copyProperties(admin, sar);
//            sar.setLastTime(admin.getUpdateTime());
//            if (StrUtil.isBlank(admin.getRoles())) continue;
//            List<Integer> roleIds = CrmebUtil.stringToArrayInt(admin.getRoles());
//            List<String> roleNames = new ArrayList<>();
//            for (Integer roleId : roleIds) {
//                List<SystemRole> hasRoles = roleList.stream().filter(e -> e.getId().equals(roleId)).collect(Collectors.toList());
//                if (hasRoles.size() > 0) {
//                    roleNames.add(hasRoles.stream().map(SystemRole::getRoleName).collect(Collectors.joining(",")));
//                }
//            }
//            sar.setRoleNames(StringUtils.join(roleNames, ","));
//            systemAdminResponses.add(sar);
//        }
        return null;
    }

    /**
     * 新增管理员
     */
    public void saveAdmin(SystemAdminAddRequest systemAdminAddRequest) {
        // 管理员名称唯一校验
        long result = checkAccount(systemAdminAddRequest.getAccount());
        if (result > 0) {
            throw new RuntimeException("管理员已存在");
        }
        // 如果有手机号，校验手机号
        if (StrUtil.isNotBlank(systemAdminAddRequest.getPhone())) {
            ValidateFormUtil.isPhoneException(systemAdminAddRequest.getPhone());
        }

        SystemAdmin systemAdmin = new SystemAdmin();
        BeanUtils.copyProperties(systemAdminAddRequest, systemAdmin);

        String pwd = AESUtil.encrypt(systemAdmin.getPwd());
        systemAdmin.setPwd(pwd);
        systemAdminDao.insert(systemAdmin);
    }

    /**
     * 管理员名称唯一校验
     */
    private long checkAccount(String account) {
        SystemAdminExample example = new SystemAdminExample();
        example.createCriteria().andAccountEqualTo(account);
        return systemAdminDao.countByExample(example);

    }

    /**
     * 更新管理员
     */
    public void updateAdmin(SystemAdminUpdateRequest systemAdminRequest) {
        getDetail(systemAdminRequest.getId());
        verifyAccount(systemAdminRequest.getId(), systemAdminRequest.getAccount());
        // 如果有手机号，校验手机号
        if (StrUtil.isNotBlank(systemAdminRequest.getPhone())) {
            ValidateFormUtil.isPhoneException(systemAdminRequest.getPhone());
        }
        SystemAdmin systemAdmin = new SystemAdmin();
        BeanUtils.copyProperties(systemAdminRequest, systemAdmin);
        systemAdmin.setPwd(null);
        if (StrUtil.isNotBlank(systemAdminRequest.getPwd())) {
            String pwd = AESUtil.encrypt(systemAdminRequest.getPwd());
            systemAdmin.setPwd(pwd);
        }
        systemAdminDao.updateByPrimaryKey(systemAdmin);
    }

    /**
     * 校验账号唯一性（管理员更新时）
     */
    private void verifyAccount(Integer id, String account) {
        SystemAdminExample example = new SystemAdminExample();
        example.createCriteria().andIdNotEqualTo(id).andAccountEqualTo(account);
        long count = systemAdminDao.countByExample(example);
        if (count > 0) {
            throw new RuntimeException("账号已存在");
        }
    }

    /**
     * 修改后台管理员状态
     */
    public Boolean updateStatus(Integer id, Integer status) {
        SystemAdmin systemAdmin = getDetail(id);
        if (Objects.equals(systemAdmin.getStatus(), status)) {
            return true;
        }
        systemAdmin.setStatus(status);
        systemAdminDao.updateByPrimaryKey(systemAdmin);
        return true;
    }

    /**
     * 根据idList获取Map
     */
    public HashMap<Integer, SystemAdmin> getMapInId(List<Integer> adminIdList) {
        HashMap<Integer, SystemAdmin> map = new HashMap<>();
        if (T.isEmpty(adminIdList)) {
            return map;
        }
        SystemAdminExample example = new SystemAdminExample();
        example.createCriteria().andIdIn(adminIdList);
        List<SystemAdmin> systemAdminList = systemAdminDao.selectByExample(example);
        for (SystemAdmin systemAdmin : systemAdminList) {
            map.put(systemAdmin.getId(), systemAdmin);
        }
        return map;
    }

    /**
     * 管理员详情
     */
    public SystemAdmin getDetail(Integer id) {
        SystemAdmin systemAdmin = systemAdminDao.selectByPrimaryKey(id);
        if (ObjectUtil.isNull(systemAdmin) || Objects.equals(systemAdmin.getIsDel(), 1)) {
            throw new RuntimeException("管理员不存在");
        }
        return systemAdmin;
    }

    /**
     * 通过用户名获取用户
     */
    public SystemAdmin selectUserByUserName(String username) {
        SystemAdminExample example = new SystemAdminExample();
        example.createCriteria().andAccountEqualTo(username).andIsDelNotEqualTo(1);
        return T.findFirst(systemAdminDao.selectByExample(example));
    }

}

