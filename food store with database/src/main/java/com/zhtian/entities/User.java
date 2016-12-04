package com.zhtian.entities;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * Created by zhtian on 2016/11/2.
 */
@Entity
@Table(name = "user")
public class User {

	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = null;

    private String username = null;
	
	@OneToMany(mappedBy = "User", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("name ASC")
	@JoinColumn(name = "userId")
	private List<Order> orders = new ArrayList<Order>();

    @Column(name = "password")
    private String password;

    private boolean vip;


    public User() {
		super();
	}

    public User(Integer id, String name) {
    	this.id = id;
    	orders = new ArrayList<Order>();
        this.username = name;
    }

    public void setId(Integer id) {
    	this.id = id;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setName(String name) {
    	this.username = name;
    }
    
    public String getName() {
        return username;
    }
    
    public void setOrders(List<Order> orders) {
    	this.orders = orders;
    }
    
    public List<Order> getOrders() {
    	return orders;
    }
    
    public void addOrder(Order order) {
    	orders.add(order);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public boolean getVip() {
        return vip;
    }
}
