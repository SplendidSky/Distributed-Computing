package com.zhtian.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/11/23.
 */

@Entity
@Table(name = "orders")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("name ASC")
	@JoinColumn(name = "orderId")
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Integer userId = null;

    public Order() {
        super();
    }
    
    public Order(Integer id, List<OrderLine> orderLines, Integer userId) {
    	this.id = id;
    	this.orderLines = orderLines;
    	this.userId = userId;
    }

    public void setId(Integer id) {
    	this.id = id;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setOrderLines(List<OrderLine> orderLines) {
    	this.orderLines = orderLines;
    }
    
    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }
    
    public void setUserId(Integer userId) {
    	this.userId = userId;
    }
    
    public Integer getUserId() {
    	return userId;
    }

//    public BigDecimal getTotal() {
//        BigDecimal total = new BigDecimal(0);
//        for (OrderLine orderLine : getOrderLines())
//            total = total.add(orderLine.getPurchasePrice().multiply(new BigDecimal(orderLine.getAmount())));
//        return total;
//    }
}
