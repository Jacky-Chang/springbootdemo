package com.example.demo.controller;

import com.example.demo.dao.IAccountDao;
import com.example.demo.domain.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by JackyChang on 2018/4/19.
 *
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private IAccountDao accountDao;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Account get(Long id) {
        return accountDao.selectById(id);
    }

}
