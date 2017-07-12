package com.zqdt.weibo.repository;

import com.zqdt.weibo.repository.model.User;
import org.junit.Test;

/**
 * Created by zhangbo on 2017/6/28.
 */
public class UserRepoTest {

    @Test
    public void testGetById(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.getById(1762956661l);
        System.out.println(user.getScreen_name());
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setScreen_name("mybatis test");
        user.setName("mybatis");
        UserRepo userRepo = new UserRepo();
        userRepo.insert(user);
    }

    @Test
    public void testUpdate(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.getById(123456l);
        user.setName("update test");
        userRepo.update(user);
    }

    @Test
    public void testDelete(){
        UserRepo userRepo = new UserRepo();
        userRepo.delete(123456l);
    }
}
