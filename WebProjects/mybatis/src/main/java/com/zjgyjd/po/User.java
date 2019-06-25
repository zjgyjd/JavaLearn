package com.zjgyjd.po;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
