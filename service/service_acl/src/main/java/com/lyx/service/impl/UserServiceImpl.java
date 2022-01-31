package com.lyx.service.impl;

import com.lyx.dao.UserDao;
import com.lyx.entity.User;
import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liao 2021/10/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
