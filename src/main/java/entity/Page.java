package entity;

import java.util.List;

public class Page {
    //当前页数
    private int currentPage;
    //总条数
    private int totalCount;
    //总页数
    private int pageCount;
    //每页展示的数据
    private int pageSize;
    //请求地址
    private String url;
    //每页展示数据的集合
    private List<?> list;

    public Page() {
    }

    public Page(int currentPage, int pageCount, int pageSize, String url, List<?> list) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        this.pageSize = pageSize;
        this.url = url;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.pageCount = totalCount%pageSize == 0?totalCount/pageSize:totalCount/pageSize+1;
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public int getPageCount() {
        return pageCount;
    }
}
