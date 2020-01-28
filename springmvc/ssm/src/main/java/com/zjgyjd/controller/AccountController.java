package com.zjgyjd.controller;

import com.zjgyjd.domain.Account;
import com.zjgyjd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有账户...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list" , list);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletResponse response , HttpServletRequest request) throws IOException {
        System.out.println("表现层查询所有账户..." + account.toString());
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
    }

}
