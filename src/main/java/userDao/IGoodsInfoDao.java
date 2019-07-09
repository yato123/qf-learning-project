package userDao;

import entity.GoodsInfo;

import java.util.List;

public interface IGoodsInfoDao {
    int insertGoodsInfo(GoodsInfo goodsInfo);
    int deleteGoodsInfo(Integer id);
    int updateGoodsInfo(GoodsInfo goodsInfo);
//    List<GoodsInfo> QueryAll();
    GoodsInfo Query(Integer id);
    Integer getTotalCount();
    List<GoodsInfo> getList(int index, int pageSize);
}
