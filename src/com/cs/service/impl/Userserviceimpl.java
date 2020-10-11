package com.cs.service.impl;

import com.cs.BaseDao.BaseDao;
import com.cs.Dao.impl.UserDaoimpl;
import com.cs.entity.User;
import com.cs.entity.Users;
import com.cs.service.Userservice;

import java.util.List;

public class Userserviceimpl extends BaseDao implements Userservice {

    UserDaoimpl udi=new UserDaoimpl();

    @Override
    public int userfindcount() throws Exception {
        return udi.userfindcount();
    }

    @Override
    public List<User> userbylimit(int page, int countpage) throws Exception {
        return udi.userbylimit(page,countpage);
    }

    @Override
    public Users login(String username, String password) throws Exception {
        return udi.login(username,password);
    }

    @Override
    public User finduser(int id) throws Exception {
        return udi.finduser(id);
    }

    @Override
    public int update(User u) throws Exception {
        return udi.update(u);
    }

    @Override
    public int del(int id) throws Exception {
        return udi.del(id);
    }

    @Override
    public int add(User u) throws Exception {
        return udi.add(u);
    }
}
