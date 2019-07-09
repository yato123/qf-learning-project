package userDao.userDaoImpl;

import Utils.DBManager;
import Utils.DBUtils;
import entity.GoodsInfo;
import userDao.IGoodsInfoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GoodsInfoDaoImpl implements IGoodsInfoDao {
    @Override
    public int insertGoodsInfo(GoodsInfo goodsInfo) {
        String sql = "insert into goodsinfo(goodsInfo_name,goodsInfo_pic,goodsInfo_price,goodsInfo_description,goods_stock)values (?,?,?,?,?);";

        return DBManager.commonUpdate(sql,
                goodsInfo.getGoodsInfo_name(),
                goodsInfo.getGoodsInfo_pic(),
                goodsInfo.getGoodsInfo_price(),
                goodsInfo.getGoodsInfo_description(),
                goodsInfo.getGoods_stock());

    }

    @Override
    public int deleteGoodsInfo(Integer id) {
        String sql = "update goodsinfo set goods_flag=0 where id=?;";
        return DBManager.commonUpdate(sql,id);
    }


    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo) {
        int rSet =0;
            if (goodsInfo.getGoodsInfo_pic() == null) {
                String sql = "update goodsinfo set goodsInfo_name=?,goodsInfo_price=?,goodsInfo_description=?,goods_stock=? where id =?;";
                rSet = DBManager.commonUpdate(sql,
                        goodsInfo.getGoodsInfo_name(),
                        goodsInfo.getGoodsInfo_price(),
                        goodsInfo.getGoodsInfo_description(),
                        goodsInfo.getGoods_stock(),
                        goodsInfo.getId());
            }
            else
            {
                String sql = "update goodsinfo set goodsInfo_name=?,goodsInfo_price=?,goodsInfo_description=?,goods_stock=?,goodsInfo_pic=? where id =?;";
                rSet = DBManager.commonUpdate(sql,
                        goodsInfo.getGoodsInfo_name(),
                        goodsInfo.getGoodsInfo_pic(),
                        goodsInfo.getGoodsInfo_price(),
                        goodsInfo.getGoodsInfo_description(),
                        goodsInfo.getGoods_stock(),
                        goodsInfo.getId());

            }


        return rSet;
    }

//    @Override
//    public List<GoodsInfo> QueryAll() {
//        ArrayList<GoodsInfo> list = new ArrayList<>();
//        String sql = "select * FROM goodsinfo WHERE goods_flag=1;";
//        return DBManager.commonQuery(sql, GoodsInfo.class);
//
//    }


    @Override
    public GoodsInfo Query(Integer goodsInfo_id)
    {
        Connection connection = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        GoodsInfo goodsInfo = new GoodsInfo();
        try {
            ps = connection.prepareStatement("select * from goodsinfo where id =? and goods_flag=1;");
            ps.setInt(1,goodsInfo_id);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                goodsInfo.setGoodsInfo_name(resultSet.getString("goodsInfo_name"));
                goodsInfo.setGoodsInfo_pic(resultSet.getString("goodsInfo_pic"));
                goodsInfo.setGoodsInfo_price(resultSet.getFloat("goodsInfo_price"));
                goodsInfo.setGoodsInfo_description(resultSet.getString("goodsInfo_description"));
                goodsInfo.setGoods_stock(resultSet.getString("goods_stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return goodsInfo;
    }

    @Override
    public Integer getTotalCount() {
        String sql = "select count(*) from goodsinfo where goods_flag = 1;";
        return DBManager.countQuery(sql);
    }
    @Override
    public List<GoodsInfo> getList(int index, int pageSize) {
        String sql = "select * from goodsinfo  where goods_flag =1 ORDER By id DESC limit ?,?;";
        return DBManager.commonQuery(sql, GoodsInfo.class,index,pageSize);
    }
}
