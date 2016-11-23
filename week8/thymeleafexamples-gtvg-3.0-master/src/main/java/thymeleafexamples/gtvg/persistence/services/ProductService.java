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
package thymeleafexamples.gtvg.persistence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thymeleafexamples.gtvg.persistence.dao.ProductDaoImpl;
import thymeleafexamples.gtvg.persistence.model.Product;
import thymeleafexamples.gtvg.persistence.dao.ProductDao;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao dao;

    public ProductService() {
        super();
    }

    public void create(Product product) {
        dao.create(product);
    }

    public List<Product> findAll() {
        return dao.findAll();
    }

    public Product findById(final Integer id) {
        return dao.findOne(id);
    }

}
