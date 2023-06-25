package org.wendy.mall.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.wendy.mall.dao.UmsAdminMapper;
import org.wendy.mall.dao.entity.UmsAdmin;
import org.wendy.mall.service.admin.UmsAdminService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * UmsAdminService实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Resource
    private UmsAdminMapper adminMapper;

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);

        //查询是否有相同用户名的用户
        LambdaQueryWrapper<UmsAdmin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdmin::getUsername, umsAdminParam.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectList(queryWrapper);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        // TODO
        umsAdmin.setPassword(umsAdmin.getPassword());
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(String username, String password) {
        return "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3ZW5keW1hIiwiY3JlYXRlZCI6MTY4NzUwMTQwMTczOCwiZXhwIjoxNjg3NTg3ODAxfQ.8dpK34Ofbr5Yv-0xP6A1j--UQlUcLN9rgCNCROICiFwZf1bg3K9BpgNtcvL1qh31rFUH4aXuj7aavYZPsbYJKw";
    }
}
