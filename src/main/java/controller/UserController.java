package controller;

import entity.Page;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;
import service.Impl.UserPageImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private UserPageImpl userPage;
    @RequestMapping("/register")
    public ModelAndView toRegister(User user){
        ModelAndView modelAndView = new ModelAndView();
        if (iUserService.checkUser(user.getUsername(),user.getPassword())) {
                modelAndView.addObject("msg", "注册成功请登陆...");
                modelAndView.setViewName("login");
        }
        else {
                modelAndView.addObject("msg", "用户已存在注册失败");
                modelAndView.setViewName("register");
        }
        return  modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView toLogin(User user){
        ModelAndView modelAndView = new ModelAndView();
        if (iUserService.userLogin(user)) {
                modelAndView.addObject("msg", "欢迎登陆");
                modelAndView.setViewName("index2");
        }
        else {
            modelAndView.addObject("msg", "登陆失败");
            modelAndView.setViewName("login");
        }
        return modelAndView;

    }//currentPage1
    @RequestMapping("/userPage")
    public ModelAndView userPage(){
        ModelAndView modelAndView = new ModelAndView();
        String viewName = "userall";
        Page page = userPage.getPage("1");
        modelAndView.addObject("page",page);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public void checkUser(String username, HttpServletResponse response) {

        if (iUserService.checkUserName(username)){

            try {
                response.getWriter().write("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("1 false");
            try {
                response.getWriter().write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
