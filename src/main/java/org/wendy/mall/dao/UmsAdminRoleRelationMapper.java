package org.wendy.mall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wendy.mall.dao.entity.UmsPermission;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/6/11 14:59
 * @Version 1.0
 */
@Mapper
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsPermission> {
    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}