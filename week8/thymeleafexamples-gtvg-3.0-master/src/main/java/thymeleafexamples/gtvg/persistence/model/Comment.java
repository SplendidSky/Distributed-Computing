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

@Entity
public class Comment implements Serializable {

    @Id
    @Column(name = "COMMENT_ID")
    private Integer id = null;

    @Column(name = "TEXT")
    private String text = null;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product = null;

    public Comment() {
        super();
    }

    public Comment(final Integer id, final String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(final Integer id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }
    public void setText(final String text) {
        this.text = text;
    }

    public Product getProduct() { return  this.product; }
    public void setProduct(Product product) { this.product = product; }
    
}