package com.advance.docker.service;

import com.advance.docker.dto.AccountDetails;
import com.advance.docker.entity.Accounts;
import com.advance.docker.controller.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * @param accountNo
     * @return
     */
    public AccountDetails fetchAccountDetails(String accountNo) {
        Accounts accounts = accountRepository.findByAccountNo(accountNo);
        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setAccountNumber(accountNo);
        accountDetails.setBalance(accounts.getBalance());
        accountDetails.setCustomerId(accounts.getCustomerId());
        return accountDetails;
    }
}
