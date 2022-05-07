package com.example.securityWithHibernate.Paging;



public class Search {
    private String value;
    private Boolean regex;

    public String getValue() {
        return value;
    }

    public Boolean getRegex() {
        return regex;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRegex(Boolean regex) {
        this.regex = regex;
    }

    public Search(){

    }
}
