package com.iiitb.academia.pojo;

public class FilterOptionPojo {
    String label;
    int id;

    public FilterOptionPojo(int id, String label) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
