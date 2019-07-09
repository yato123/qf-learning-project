package service;

import entity.GoodsInfo;

public interface IGoodsInfoService {
    boolean insert(GoodsInfo goodsInfo);
    boolean delete(Integer id);
    boolean update(GoodsInfo goodsInfo);
    GoodsInfo query(Integer id);
}
