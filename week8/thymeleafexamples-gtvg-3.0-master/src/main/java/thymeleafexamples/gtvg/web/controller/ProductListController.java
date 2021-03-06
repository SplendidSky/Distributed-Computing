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
package thymeleafexamples.gtvg.web.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleafexamples.gtvg.config.PersistenceJPAConfig;
import thymeleafexamples.gtvg.persistence.model.Product;
import thymeleafexamples.gtvg.persistence.services.ProductService;

@Controller
public class ProductListController {
	@RequestMapping("product/list")
	public String productList(Model model) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceJPAConfig.class);
		ctx.refresh();
		ProductService ps = ctx.getBean(ProductService.class);
		final List<Product> allProducts = ps.findAll();
		model.addAttribute("prods", allProducts);
		return "product/list";
	}
}