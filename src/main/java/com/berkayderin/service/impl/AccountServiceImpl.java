package com.berkayderin.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkayderin.dto.DtoAccount;
import com.berkayderin.dto.DtoAccountIU;
import com.berkayderin.model.Account;
import com.berkayderin.repository.AccountRepository;
import com.berkayderin.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU dtoAccountIU) {
        Account account = new Account();
        account.setCreateTime(new Date());

        BeanUtils.copyProperties(dtoAccountIU, account);

        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        DtoAccount dtoAccount = new DtoAccount();
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
        BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }

}
