package me.database.jdbc_jpa;

import me.database.persistence.model.Foo;
import me.database.config.PersistenceJPAConfig;

import me.database.persistence.service.FooService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    	ctx.register(PersistenceJPAConfig.class);
    	ctx.refresh();
    	
    	System.out.println( "*** step1:"+ctx.getBean("entityManagerFactory").toString() );
    	System.out.println( "*** step2:"+ctx.getBean(LocalContainerEntityManagerFactoryBean.class).toString() );
    	
    	FooService fs = ctx.getBean(FooService.class);
    	System.out.println( fs.toString() );
    	
    	Foo foo = new Foo("test");
    	fs.create(foo);
    	foo = new Foo("test1");
    	fs.create(foo);
    	
    	for (Foo f:fs.findAll()) {
    		System.out.println(f.getName());
    	}
    	
        System.out.println( "Hello World!" );
    }
}
