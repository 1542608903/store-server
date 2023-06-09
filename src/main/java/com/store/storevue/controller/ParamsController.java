package com.store.storevue.controller;

import com.store.storevue.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsController {
    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "GET请求";
    }
    @RequestMapping(value = ("/getTest2"),method = RequestMethod.GET)
    public String getTest2(String username,String userpwd){
        System.out.println(username);
        System.out.println(userpwd);
        return "GET请求";
    }

    @RequestMapping(value = ("/getTest3"),method = RequestMethod.GET)
    public String getTest3(@RequestParam("nikname") String username, String userpwd){
        System.out.println(username);
        System.out.println(userpwd);
        return "GET请求";
    }
    //    POST请求
    @RequestMapping(value = ("/postTest1"),method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求";
    }
    @RequestMapping(value = ("/postTest2"),method = RequestMethod.POST)
    public String postTest2(String username,String userpwd){
        System.out.println(username);
        System.out.println(userpwd);
        return "POST请求";
    }
    @RequestMapping(value = ("/postTest3"),method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping(value = ("/postTest4"),method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println(user);
        return "POST请求";
    }
}



