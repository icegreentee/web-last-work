package com.louis.spring.oauth.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.louis.spring.oauth.server.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
