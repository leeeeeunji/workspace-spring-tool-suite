package com.itwill.user.controller;

import lombok.Data;

@Data
public class Response {

    private int status;
    private String message;
    private Object data;

    public Response() {
        this.status = 0;
        this.data =new Object();
        this.message = "";
    }
    
}