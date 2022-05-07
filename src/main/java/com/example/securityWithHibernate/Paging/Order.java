package com.example.securityWithHibernate.Paging;

import java.util.Objects;

public class Order {
    private Integer column;
    private Direction dir;

    public Order(Integer column, Direction dir) {
        this.column = column;
        this.dir = dir;
    }

    public Order() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(column, order.column) && dir == order.dir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, dir);
    }

    public Integer getColumn() {
        return column;
    }

    public Direction getDir() {
        return dir;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
