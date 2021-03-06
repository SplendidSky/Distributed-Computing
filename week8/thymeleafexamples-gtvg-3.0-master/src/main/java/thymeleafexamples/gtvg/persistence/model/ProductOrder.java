/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2016, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafexamples.gtvg.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class ProductOrder implements Serializable{

    @Id
    @Column(name = "ORDER_ID")
    private Integer id = null;

    @Column(name = "DATE")
    private Calendar date = null;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CUSTOMER")
    private Customer customer = null;

    @Column(name = "ORDERLINES")
    @ElementCollection(targetClass=OrderLine.class)
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    public ProductOrder() {
        super();
    }

    public ProductOrder(Integer id, Calendar date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }
    

    public Calendar getDate() {
        return this.date;
    }
    public void setDate(final Calendar date) {
        this.date = date;
    }
    

    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public BigDecimal getTotal() {
    	BigDecimal total = new BigDecimal(0);
    	for (OrderLine orderLine : getOrderLines())
    		total = total.add(orderLine.getPurchasePrice().multiply(new BigDecimal(orderLine.getAmount())));
    	return total;
    }
}
