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
package thymeleafexamples.gtvg.web.application;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import thymeleafexamples.gtvg.business.util.CalendarUtil;
import thymeleafexamples.gtvg.persistence.model.*;
import thymeleafexamples.gtvg.persistence.services.*;
import thymeleafexamples.gtvg.config.PersistenceJPAConfig;
import thymeleafexamples.gtvg.web.controller.IGTVGController;


public class GTVGApplication {


    private TemplateEngine templateEngine;
    private Map<String, IGTVGController> controllersByURL;


    public GTVGApplication(final ServletContext servletContext) {

        super();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

        // HTML is the default mode, but we will set it anyway for better understanding of code
        templateResolver.setTemplateMode(TemplateMode.HTML);
        // This will convert "home" to "/WEB-INF/templates/home.html"
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));

        // Cache is set to true by default. Set to false if you want templates to
        // be automatically updated when modified.
        templateResolver.setCacheable(true);

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);

        this.controllersByURL = new HashMap<String, IGTVGController>();

//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(PersistenceJPAConfig.class);
//        ctx.refresh();
//        ProductService ps = ctx.getBean(ProductService.class);
//        CustomerService cs = ctx.getBean(CustomerService.class);
//        OrderService os = ctx.getBean(OrderService.class);
//        OrderLineService ols = ctx.getBean(OrderLineService.class);
//        CommentService cms = ctx.getBean(CommentService.class);
//
//        Customer customer1 = new Customer();
//        customer1.setId(1);
//        customer1.setName("David");
//        customer1.setCustomerSince(CalendarUtil.calendarFor(2002, 3, 2, 10, 23));
//        Customer customer2 = new Customer();
//        customer2.setId(2);
//        customer2.setName("Nancy");
//        customer2.setCustomerSince(CalendarUtil.calendarFor(2014, 3, 2, 1, 5));
//
//        cs.create(customer1);
//        cs.create(customer2);
//
//        Comment comment1 = new Comment();
//        comment1.setId(1);
//        comment1.setText("comment1");
//        Comment comment2 = new Comment();
//        comment2.setId(2);
//        comment2.setText("comment2");
//
//
//        Product product1 = new Product(1, "test1", false, new BigDecimal(100));
//        Product product2 = new Product(2, "test2", true, new BigDecimal(200));
//        product1.getComments().add(comment1);
//        product1.getComments().add(comment2);
//
//        comment1.setProduct(product1);
//        comment2.setProduct(product2);
//
//
//        ps.create(product1);
//        ps.create(product2);
//
//        cms.create(comment1);
//        cms.create(comment2);
//
//
//        OrderLine orderLine1 = new OrderLine();
//        orderLine1.setProduct(product1);
//        orderLine1.setAmount(5);
//        orderLine1.setPurchasePrice(new BigDecimal("10"));
//        OrderLine orderLine2 = new OrderLine();
//        orderLine2.setProduct(product2);
//        orderLine2.setAmount(10);
//        orderLine2.setPurchasePrice(new BigDecimal("20"));
//
//        ols.create(orderLine1);
//        ols.create(orderLine2);
//
//        ProductOrder order1 = new ProductOrder(1, CalendarUtil.calendarFor(2009, 1, 12, 10, 23), customer1);
//        order1.getOrderLines().add(orderLine1);
//
//        ProductOrder order2 = new ProductOrder(2, CalendarUtil.calendarFor(2016, 3, 2, 8, 3), customer2);
//        order2.getOrderLines().add(orderLine2);
//
//        os.create(order1);
//        os.create(order2);
    }


    public IGTVGController resolveControllerForRequest(final HttpServletRequest request) {
        final String path = getRequestPath(request);
        return this.controllersByURL.get(path);
    }


    public ITemplateEngine getTemplateEngine() {
        return this.templateEngine;
    }


    private static String getRequestPath(final HttpServletRequest request) {

        String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();

        final int fragmentIndex = requestURI.indexOf(';');
        if (fragmentIndex != -1) {
            requestURI = requestURI.substring(0, fragmentIndex);
        }

        if (requestURI.startsWith(contextPath)) {
            return requestURI.substring(contextPath.length());
        }
        return requestURI;
    }


}
