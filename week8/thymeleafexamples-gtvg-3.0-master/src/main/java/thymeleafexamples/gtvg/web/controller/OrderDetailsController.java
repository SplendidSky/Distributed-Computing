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


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleafexamples.gtvg.config.PersistenceJPAConfig;
import thymeleafexamples.gtvg.persistence.model.ProductOrder;
import thymeleafexamples.gtvg.persistence.services.OrderService;

@Controller
public class OrderDetailsController  {
	@RequestMapping("/order/details")
	public String orderDetails(@RequestParam(value="orderId") int orderId, Model model) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceJPAConfig.class);
		ctx.refresh();
		OrderService os = ctx.getBean(OrderService.class);
		final ProductOrder productOrder = os.findById(orderId);
		model.addAttribute("productOrder", productOrder);
		return "productOrder/details";
	}
}
