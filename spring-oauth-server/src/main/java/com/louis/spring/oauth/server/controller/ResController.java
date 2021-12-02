package com.louis.spring.oauth.server.controller;

import com.louis.spring.oauth.server.model.Userinfos;
import com.louis.spring.oauth.server.service.IUserinfosService;
import com.louis.spring.oauth.server.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin()
public class ResController {
    @Autowired
    private IUsersService iUsersService;
    @Autowired
    private IUserinfosService iUserinfosService;

    @RequestMapping("/res/getMsg")
    public String getMsg() {
        return "success";
    }

    // 获得所有user权限的用户名
    @GetMapping("/res/getalluser")
    public List<String> getAllUser() {
        return iUsersService.getalluser();
    }

    // 获得所有userinfos信息
    @GetMapping("/res/getalluserinfo")
    public List<Userinfos> getalluserinfo() {
        return iUserinfosService.getalluserinfo();
    }

    // 增加一条userinfos信息
    @PostMapping("/res/addoneuserinfo")
    public String addoneuserinfo(@RequestBody Userinfos userinfos) {
        return iUserinfosService.addoneuserinfo(userinfos);
    }

    // 修改一条userinfos信息
    @PostMapping("/res/updateoneuserinfo")
    public String updateoneuserinfo() {
        return "success";
    }

    // 删除一条userinfos信息
    @PostMapping("/res/deleteoneuserinfo")
    public String deleteoneuserinfo() {
        return "success";
    }
}
