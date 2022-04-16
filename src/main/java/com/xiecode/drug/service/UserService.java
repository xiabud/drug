package com.xiecode.drug.service;

import com.xiecode.drug.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiewc
 * @since 2022-02-16
 */
public interface UserService extends IService<User> {

    User queryUserByUserName(User user);

}
