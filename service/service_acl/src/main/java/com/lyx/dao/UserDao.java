package com.lyx.dao;

import com.lyx.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author liao 2021/10/27
 */
@Repository
public interface UserDao {

    /**
     * 用户登录接口
     * @param user
     * @return
     */
    public User login(User user);

}
