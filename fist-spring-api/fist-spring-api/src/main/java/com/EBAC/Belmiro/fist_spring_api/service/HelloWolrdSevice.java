package com.EBAC.Belmiro.fist_spring_api.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWolrdSevice {
    public String hellowolrd(String name){
        return "Hello Git"+ name;
    }
}
