package com.louis.spring.oauth.server.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louis.spring.oauth.server.mapper.UserinfosMapper;
import com.louis.spring.oauth.server.mapper.UsersMapper;
import com.louis.spring.oauth.server.model.Userinfos;
import com.louis.spring.oauth.server.model.Users;
import com.louis.spring.oauth.server.service.IUserinfosService;
import com.louis.spring.oauth.server.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private IUserinfosService iUserinfosService;

    @Override
    public List<String> getalluser() {
        // 得到所有用户名除了admin
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
        //得到所有已经有了信息的用户名
        List<Userinfos> userinfos = iUserinfosService.getalluserinfo();
        List<String> usernamehasinfo =  new ArrayList<>();
        for(int i=0;i<userinfos.size();i++){
            String username =  userinfos.get(i).getUsername();
            usernamehasinfo.add(username);
        }
        //得到所有没有信息的用户名
        List<String> usernamewithoutinfo =  new ArrayList<>();
        for(int i=0;i<userwihoutadmin.size();i++){
            String username =  userwihoutadmin.get(i);
            if(usernamehasinfo.contains(username)){
                continue;
            }
            usernamewithoutinfo.add(username);
        }
        return usernamewithoutinfo;
    }
}
