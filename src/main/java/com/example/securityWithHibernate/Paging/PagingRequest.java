package com.example.securityWithHibernate.Paging;

import java.util.List;

public class PagingRequest {

    private int start;
    private int draw;
    private int length;
    private List<Order> order;
    private List<Column> columns;
    private Search search;

    public PagingRequest(){

    }

    public int getStart() {
        return start;
    }

    public int getDraw() {
        return draw;
    }

    public int getLength() {
        return length;
    }

    public List<Order> getOrder() {
        return order;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public Search getSearch() {
        return search;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
