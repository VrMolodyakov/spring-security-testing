package com.example.securityWithHibernate.Paging;

import java.util.List;

public class Page<T> {

    private List<T> data;
    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;

    public Page(List<T> data) {
        this.data = data;
    }

    public Page(){

    }

    public List<T> getData() {
        return data;
    }

    public Integer getDraw() {
        return draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
