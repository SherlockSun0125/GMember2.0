package cn.edu.hitwh.gmember.tools;

import java.util.List;

public class PageBean<T> {
    private int currentPage;//page current,当前页码
    private int totalRecords;//total record,总记录数
    private int pageSize;//page size,每页记录数
    private String url;//请求的路径和参数,例如:/BookServlet?method=findXXX&cid=1&bname=2
    private List<T> beanList;
    private int totalPages;

    public int getTotalPages(){//获得总页数
        int tp=totalRecords/pageSize;
        return totalRecords%pageSize==0?tp:tp+1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalRecords() {
        return totalRecords;
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

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
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

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalRecords=" + totalRecords +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                ", beanList=" + beanList +
                ", totalPages=" + totalPages +
                '}';
    }
}
