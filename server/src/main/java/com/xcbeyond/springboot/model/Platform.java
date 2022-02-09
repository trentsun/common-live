package com.xcbeyond.springboot.model;


import java.io.Serializable;

public class Platform implements Serializable {
    private static final long serialVersionUID = 0L;

    private long id;
    private String name;
    private String icon_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon_url='" + icon_url + '\'' +
                '}';
    }
}
