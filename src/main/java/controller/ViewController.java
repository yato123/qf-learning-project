package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class ViewController {
    @RequestMapping("/toregister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/toindex2")
    public String toIndex2(){
        return "index2";
    }
    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping(value = "/toupload")
    public String  toUpload(){
        return "upload";
    }
}
