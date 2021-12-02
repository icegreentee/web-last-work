package com.louis.spring.oauth.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louis.spring.oauth.server.mapper.UsersMapper;
import com.louis.spring.oauth.server.model.Users;
import com.louis.spring.oauth.server.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<String> getalluser() {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        List<Users> usersList =  usersMapper.selectList(queryWrapper);
        List<String> userwihoutadmin =  new ArrayList<>();
        for(int i=0;i<usersList.size();i++){
            String username =  usersList.get(i).getUsername();
            if(username.equals("admin")){
                continue;
            }
            userwihoutadmin.add(username);
        }

        return userwihoutadmin;
    }
}
