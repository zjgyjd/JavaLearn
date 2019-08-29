package com.zjgyjd.controller;

import com.zjgyjd.Request;
import com.zjgyjd.Response;
import com.zjgyjd.Status;

public abstract class Controller {
    public void doGet(Request request , Response response) throws Exception {
        //如果没有实现就抛出405
        response.setStatus(Status.NOT_ALLOWED);
        response.println(Status.NOT_ALLOWED.getReason());
    }

    public void doPost(Request request , Response response) throws Exception {
        //如果没有实现就抛出405
        response.setStatus(Status.NOT_ALLOWED);
        response.println(Status.NOT_ALLOWED.getReason());
    }
}
