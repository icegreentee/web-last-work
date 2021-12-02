package com.louis.spring.oauth.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.louis.spring.oauth.server.model.Users;

import java.util.List;

public interface IUsersService extends IService<Users> {
    List<String> getalluser();
}
