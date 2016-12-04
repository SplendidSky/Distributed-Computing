package com.zhtian.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/23.
 */

@Entity
@Table(name = "food")
public class Food {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "cost")
    private double cost;
	
	@Column(name = "src")
    private String src;

    @Column(name = "bargain")
    private boolean bargain;

    public Food() {
    	super();
    }
    
    public Food(Integer id, String name, double cost, String src) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.src = src;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
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

    public void setBargain(boolean bargain) {
        this.bargain = bargain;
    }

    public boolean getBargain() {
        return bargain;
    }
}
