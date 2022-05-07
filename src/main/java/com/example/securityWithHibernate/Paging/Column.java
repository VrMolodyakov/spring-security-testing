package com.example.securityWithHibernate.Paging;

public class Column {

    private String data;
    private String name;
    private Boolean searchable;
    private Boolean orderable;

    public Column(String data) {
        this.data = data;
    }

    public Column(){

    }

    public String getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }
}
