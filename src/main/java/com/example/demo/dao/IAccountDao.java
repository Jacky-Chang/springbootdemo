package com.example.demo.dao;

import com.example.demo.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by JackyChang on 2018/4/19.
 *
 */
@Repository
public interface IAccountDao {

    Long insert(Account orderCoupon);

    Long update(Account orderCoupon);

    Account selectById(Long id);

    List<Account> getPageListByParam(HashMap<String, Object> param);

    void deleteById(String id);
}
