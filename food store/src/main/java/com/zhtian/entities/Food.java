package com.zhtian.entities;

/**
 * Created by Administrator on 2016/11/23.
 */
public class Food {
    private int id;
    private String name;
    private double cost;
    private String src;

    public Food() {}
    public Food(int id, String name, double cost, String src) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.src = src;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSrc() {
        return src;
    }

    public void setImg_src(String src) {
        this.src = src;
    }
}
