package com.xiecode.drug.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiecode.drug.pojo.User;
import com.xiecode.drug.mapper.UserMapper;
import com.xiecode.drug.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xiewc
 * @since 2022-02-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
    * @Description: 根据用户名查询用户对象
    * @return: com.xiecode.drug.pojo.User
    * @Author: Xiewc
    * @Date: 2022/2/16
    */
    @Override
    public User queryUserByUserName(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", user.getUserName());
        return userMapper.selectOne(wrapper);
    }
}
