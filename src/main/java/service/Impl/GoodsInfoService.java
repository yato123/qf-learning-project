package service.Impl;

import entity.GoodsInfo;
import org.springframework.stereotype.Service;
import service.IGoodsInfoService;
import userDao.IGoodsInfoDao;
import userDao.userDaoImpl.GoodsInfoDaoImpl;

@Service
public class GoodsInfoService implements IGoodsInfoService{
    IGoodsInfoDao iGoodsInfoDao = new GoodsInfoDaoImpl();
    GoodsInfo goodsInfo = null;

    @Override
    public boolean insert(GoodsInfo goodsInfo) {
        if(iGoodsInfoDao.insertGoodsInfo(goodsInfo)>0){
            return true;
        }else {
        return false;}
    }

    @Override
    public boolean delete(Integer id) {
        if (iGoodsInfoDao.deleteGoodsInfo(id) >0){
            return true;
        }else {
        return false;}
    }

    @Override
    public boolean update(GoodsInfo goodsInfo) {
        if (iGoodsInfoDao.updateGoodsInfo(goodsInfo) >0){
            return true;
        }else {
        return false;}
    }

    @Override
    public GoodsInfo query(Integer id) {
        if (iGoodsInfoDao.Query(id) != null){
            GoodsInfo goodsInfo = iGoodsInfoDao.Query(id);
        }
        return null;
    }
}
