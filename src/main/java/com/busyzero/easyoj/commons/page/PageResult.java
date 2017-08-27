package com.busyzero.easyoj.commons.page;

import java.util.List;

/**
 * 页返回结果
 * @author katey2658
 * @param <T>
 */
public class PageResult<T> {

    /**总记录数*/
    private Long amount;

    /**总页数*/
    private Long pageTotal;

    /**结果*/
    private List<T> rows;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Long pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "amount=" + amount +
                ", pageTotal=" + pageTotal +
                ", rows=" + rows +
                '}';
    }
}
