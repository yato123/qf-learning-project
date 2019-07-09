package entity;

public class GoodsInfo {
    private Integer id;
    private String goodsInfo_name;
    private String goodsInfo_pic;
    private Float goodsInfo_price;
    private String goodsInfo_description;
    private String goods_stock;
    private String goods_flag;


    public GoodsInfo() {
    }

    public GoodsInfo(Integer id, String goodsInfo_name, String goodsInfo_pic, Float goodsInfo_price, String goodsInfo_description, String goods_stock, String goods_flag) {
        this.id = id;
        this.goodsInfo_name = goodsInfo_name;
        this.goodsInfo_pic = goodsInfo_pic;
        this.goodsInfo_price = goodsInfo_price;
        this.goodsInfo_description = goodsInfo_description;
        this.goods_stock = goods_stock;
        this.goods_flag = goods_flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsInfo_name() {
        return goodsInfo_name;
    }

    public void setGoodsInfo_name(String goodsInfo_name) {
        this.goodsInfo_name = goodsInfo_name;
    }

    public String getGoodsInfo_pic() {
        return goodsInfo_pic;
    }

    public void setGoodsInfo_pic(String goodsInfo_pic) {
        this.goodsInfo_pic = goodsInfo_pic;
    }

    public Float getGoodsInfo_price() {
        return goodsInfo_price;
    }

    public void setGoodsInfo_price(Float goodsInfo_price) {
        this.goodsInfo_price = goodsInfo_price;
    }

    public String getGoodsInfo_description() {
        return goodsInfo_description;
    }

    public void setGoodsInfo_description(String goodsInfo_description) {
        this.goodsInfo_description = goodsInfo_description;
    }

    public String getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(String goods_stock) {
        this.goods_stock = goods_stock;
    }

    public String getGoods_flag() {
        return goods_flag;
    }

    public void setGoods_flag(String goods_flag) {
        this.goods_flag = goods_flag;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", goodsInfo_name='" + goodsInfo_name + '\'' +
                ", goodsInfo_pic='" + goodsInfo_pic + '\'' +
                ", goodsInfo_price=" + goodsInfo_price +
                ", goodsInfo_description='" + goodsInfo_description + '\'' +
                ", goods_stock='" + goods_stock + '\'' +
                ", goods_flag='" + goods_flag + '\'' +
                '}';
    }
}
