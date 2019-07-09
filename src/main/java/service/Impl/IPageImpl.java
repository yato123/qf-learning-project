package service.Impl;



import entity.Page;
import service.IPage;
import userDao.IGoodsInfoDao;
import userDao.userDaoImpl.GoodsInfoDaoImpl;

public class IPageImpl implements IPage {
    private IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
    @Override
    public Page getPage(String currentPage) {
        Page page = new Page();
        //设置每页展示的数据
        page.setPageSize(5);
        //设置当前页
        page.setCurrentPage(Integer.parseInt(currentPage));
        //设置总条数
        page.setTotalCount(goodsInfoDao.getTotalCount());
        //设置url
        page.setUrl("GoodsInfoServlet");
        //设置每页展示的数据
        page.setList(goodsInfoDao.getList((page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize()));

        return page;
    }
}
