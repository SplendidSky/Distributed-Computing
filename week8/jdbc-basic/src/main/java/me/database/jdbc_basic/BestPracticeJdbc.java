package me.database.jdbc_basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.database.business.model.Foo;
import me.database.business.service.FooService;
import me.database.config.PersistenceJDBCConfig;

// see more
// http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#jdbc
public class BestPracticeJdbc {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(PersistenceJDBCConfig.class);
		ctx.refresh();
		
    	FooService fs = ctx.getBean(FooService.class);
    	System.out.println( fs.toString() );
    	
    	Foo foo = new Foo("jdbc test");
    	fs.create(foo);
    	foo = new Foo("jdbc test1");
    	fs.create(foo);
    	
    	for (Foo f:fs.findAll()) {
    		System.out.println(f.getName());
    	}
    	
        System.out.println( "Hello World!" );		
		
	}

}
