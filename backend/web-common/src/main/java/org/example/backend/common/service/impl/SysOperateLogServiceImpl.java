package org.example.backend.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysOperateLogDto;
import org.example.backend.common.model.param.SysOperateLogParam;
import org.example.backend.common.primary.base.dao.SysOperateLogDao;
import org.example.backend.common.primary.entity.SysOperateLog;
import org.example.backend.common.primary.entity.SysOperateLogExample;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysOperateLogService;
import org.example.backend.common.util.DateUtil;
import org.example.backend.common.util.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/3 19:20
 */
@Slf4j
@Service
public class SysOperateLogServiceImpl implements SysOperateLogService {

    @Resource
    private SysOperateLogDao sysOperateLogDao;

    @Override
    public Page<SysOperateLogDto> pageList(SysOperateLogParam param) {
        SysOperateLogExample example = new SysOperateLogExample();
        SysOperateLogExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getUserName())) {
            criteria.andUserNameEqualTo(param.getUserName());
        }
        if (T.isNotBlank(param.getOpType())) {
            criteria.andOpTypeEqualTo("%" + param.getOpType() + "%");
        }
        if (T.isNotBlank(param.getSubject())) {
            criteria.andSubjectLike("%" + param.getSubject() + "%");
        }
        if (T.isNotBlank(param.getSubjectExt())) {
            criteria.andSubjectExtLike("%" + param.getSubjectExt() + "%");
        }
        if (T.isNotBlank(param.getContent())) {
            criteria.andContentLike("%" + param.getContent() + "%");
        }
        if (T.isNotBlank(param.getUserId())) {
            criteria.andUserIdEqualTo(param.getUserId());
        }
        if (T.isNotBlank(param.getUserName())) {
            criteria.andUserNameEqualTo(param.getUserName());
        }
        if (T.isNotBlank(param.getStartTime())) {
            criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.parse(param.getStartTime()));
        }
        if (T.isNotBlank(param.getEndTime())) {
            criteria.andCreateTimeLessThanOrEqualTo(DateUtil.parse(param.getEndTime()));
        }

        long count = sysOperateLogDao.countByExample(example);
        example.setLimit(param.getLimit());
        example.setOffset(param.getOffset());
        example.setOrderByClause(" create_time desc");
        List<SysOperateLogDto> list = sysOperateLogDao.selectByExample(example).stream().map(e -> {
            SysOperateLogDto dto = new SysOperateLogDto();
            BeanUtils.copyProperties(e, dto);
            return dto;
        }).collect(Collectors.toList());
        return new Page<>(list, param.getPage(), param.getLimit(), count);
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addLog(String opType, String subject, String subjectExt, String content) {
        Integer userId = AuthenticationUtil.getUserId();
        String userName = AuthenticationUtil.getUserName();

        SysOperateLog log = new SysOperateLog();
        log.setOpType(opType);
        log.setSubject(subject);
        log.setSubjectExt(subjectExt);
        log.setContent(content);
        log.setUserIp("");
        log.setUserId(String.valueOf(userId));
        log.setUserName(userName);
        log.setCreateTime(new Date());
        sysOperateLogDao.insert(log);
    }


}
