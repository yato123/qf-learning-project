package servlet;

import entity.Page;
import entity.User;
import service.IPage;
import service.IUserService;
import service.Impl.UserPageImpl;
import service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobbies");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");
        String action = req.getParameter("action");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSex(sex);
        user.setHobbies(Arrays.toString(hobbies));
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddrs(addrs);
        IUserService iUserService = new UserServiceImpl();
        IPage pageService = new UserPageImpl();
        switch (action) {
            case "userPage":
                String currentPage = req.getParameter("currentPage");
                currentPage = currentPage == null?"1":currentPage;
                //调用service层获取page对象
                Page page = pageService.getPage(currentPage);
                req.setAttribute("page",page);
                req.getRequestDispatcher("userall.jsp").forward(req,resp);
                break;
            case "checkUser":
                System.out.println("userServlet");
                if (iUserService.checkUser(username,password)){
                    resp.getWriter().write("1");
                }else {
                    resp.getWriter().write("0");
                }
                break;
            case "register":
                //                register(req, resp, user);


                if (iUserService.register(user)) {
                    try {
                        req.setAttribute("msg", "注册成功请登陆...");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        req.setAttribute("msg", "用户已存在注册失败");
                        req.getRequestDispatcher("register.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "login":
//                login(req, resp, user);
                //以下为修改代码
                if (iUserService.userLogin(user)) {
                    try {
                        req.setAttribute("msg", "欢迎登陆");

                        req.getRequestDispatcher("index2.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        req.setAttribute("msg", "用户名或密码错误,登陆失败...");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }

    }
}







        //以上为修改代码


//    private void login(HttpServletRequest req, HttpServletResponse resp, User user) {
//        UserDaoImpl userDao = new UserDaoImpl();
//        if (userDao.login(user.getUsername(), user.getPassword())) {
//
//            try {
//                req.setAttribute("msg", "欢迎登陆");
//                req.getRequestDispatcher("GoodsInfoServlet?action=query").forward(req, resp);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//
//            try {
//                req.setAttribute("msg", "用户名或密码错误,登陆失败...");
//                req.getRequestDispatcher("login.jsp").forward(req, resp);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }


//    private void register(HttpServletRequest req, HttpServletResponse resp, User user) throws ServletException, IOException {
//        UserDaoImpl userDao = new UserDaoImpl();
//        if (!userDao.CheckRegister(user.getUsername())) {
//            if (userDao.register(user) > 0) {
//                try {
//                    req.setAttribute("msg", "注册成功请登陆...");
//                    req.getRequestDispatcher("login.jsp").forward(req, resp);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }   else {
//            try {
//                req.setAttribute("msg", "用户已存在注册失败");
//                req.getRequestDispatcher("register.jsp").forward(req, resp);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            }
//
//    }
//
//
//}
