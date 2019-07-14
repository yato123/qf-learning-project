package service.Impl;

import org.springframework.stereotype.Service;
import userDao.IUserDao;
import userDao.userDaoImpl.UserDaoImpl;
import entity.Page;
import service.IPage;

@Service
public class UserPageImpl implements IPage {
    private IUserDao userDao =  new UserDaoImpl();
    @Override
    public Page getPage(String currentPage) {

        Page page = new Page();
        //设置每页展示的数据
        page.setPageSize(5);
        //设置当前页
        page.setCurrentPage(Integer.parseInt(currentPage));
        //设置总条数
        page.setTotalCount(userDao.getTotalCount());
        //设置url
//        page.setUrl("UserServlet");
        //设置每页展示的数据
        page.setList(userDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));
        System.out.printf(page.toString());
        return page;
    }

}
