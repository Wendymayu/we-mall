package org.wendy.mall.service.admin;

import org.wendy.mall.dao.entity.UmsAdmin;

public interface UmsAdminService {
    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);
}
