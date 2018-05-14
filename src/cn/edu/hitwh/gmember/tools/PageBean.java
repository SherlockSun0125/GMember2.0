package cn.edu.hitwh.gmember.tools;

import java.util.List;

public class PageBean<T> {
    private int currentPage;//page current,当前页码
    private int totalRecods;//total record,总记录数
    private int pageSize;//page size,每页记录数
    private String url;//请求的路径和参数,例如:/BookServlet?method=findXXX&cid=1&bname=2
    private List<T> beanList;

    public int getTotalPages(){//获得总页数
        int tp=totalRecods/pageSize;
        return totalRecods%pageSize==0?tp:tp+1;
    }

    public void setPageCode(int pageCode) {
        this.currentPage = pageCode;
    }

    public void setTotalRecods(int totalRecods) {
        this.totalRecods = totalRecods;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public int getPageCode() {
        return currentPage;
    }

    public int getTotalRecods() {
        return totalRecods;
    }

    public int getPageSize() {
        return pageSize;
    }

    public String getUrl() {
        return url;
    }

    public List<T> getBeanList() {
        return beanList;
    }
}
