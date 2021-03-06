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
package thymeleafexamples.gtvg.business.services;

import java.math.BigDecimal;
import java.util.List;

import thymeleafexamples.gtvg.business.entities.Order;
import thymeleafexamples.gtvg.business.entities.OrderLine;
import thymeleafexamples.gtvg.business.entities.repositories.OrderRepository;

public class OrderService {

    
    
    public OrderService() {
        super();
    }
    
    
    
    public List<Order> findAll() {
        return OrderRepository.getInstance().findAll();
    }

    public Order findById(final Integer id) {
        return OrderRepository.getInstance().findById(id);
    }

    public List<Order> findByCustomerId(final Integer customerId) {
        return OrderRepository.getInstance().findByCustomerId(customerId);
    }
    
    public BigDecimal getTotal() {
    	List<Order> list = findAll();
    	BigDecimal total = new BigDecimal(0);
    	for (int i = 0; i < list.size(); i++) {
    		for (OrderLine orderLine : list.get(i).getOrderLines()) {
    			total = total.add(orderLine.getPurchasePrice().multiply(new BigDecimal(orderLine.getAmount())));
    		}
    	}
    	return total;
    }
    
}
