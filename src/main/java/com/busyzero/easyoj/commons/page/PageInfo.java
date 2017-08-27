package com.busyzero.easyoj.commons.page;

/**
 * 定义页的信息
 * @author katey2658
 */
public class PageInfo {

    /**偏移量*/
    private Long offset;

    /**每页大小*/
    private Integer limit;

    /**排序方式*/
    private String orderBy = "DESC";

    /**排序字段*/
    private String filedWithOrderBy;

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getFiledWithOrderBy() {
        return filedWithOrderBy;
    }

    public void setFiledWithOrderBy(String filedWithOrderBy) {
        this.filedWithOrderBy = filedWithOrderBy;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", orderBy='" + orderBy + '\'' +
                ", filedWithOrderBy='" + filedWithOrderBy + '\'' +
                '}';
    }
}
