package com.EBAC.Belmiro.fist_spring_api.controller;

import com.EBAC.Belmiro.fist_spring_api.domain.User;
import com.EBAC.Belmiro.fist_spring_api.service.HelloWolrdSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.namespace.QName;

@RestController
@RequestMapping("/hello-world")
// combinação a baixo resultado acima

// @Controller
// @ResponseBody
public class HelloWorldController {

    @Autowired
    private HelloWolrdSevice helloWolrdSevice;

    // esse metoto pode responder do post,get,delete, put ,pat, options,head
 // porisso especifico ele logo abaixo
    @GetMapping
    public String helloworld() {
        String name = "Nicolas ";
        return helloWolrdSevice.hellowolrd( name);
    }

    @PostMapping("/{id}")
    public String hellowolrdPost(@PathVariable("o id da para mapar por esse parametro ") String id,
                                 @RequestParam (value = "filter", defaultValue = "devedor ou ativo") String filter ,
                                 @RequestBody User body) {
        return "hello wolrd post"+ body.getName()+ id +filter;
    }
}
