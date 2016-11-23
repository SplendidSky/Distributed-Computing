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

@Entity
public class OrderLine implements Serializable{

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT")
    private Product product = null;

    @Id
    @Column(name = "AMOUNT")
    private Integer amount = null;

    @Id
    @Column(name = "PURCHASEPRICE")
    private BigDecimal purchasePrice = null;
    
    public OrderLine() {
        super();
    }

    public OrderLine(Product product, Integer amount, BigDecimal purchasePrice) {
        this.product = product;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }


    public Product getProduct() {
        return this.product;
    }
    public void setProduct(final Product product) {
        this.product = product;
    }
    

    public Integer getAmount() {
        return this.amount;
    }
    public void setAmount(final Integer amount) {
        this.amount = amount;
    }


    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }
    public void setPurchasePrice(final BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
}
