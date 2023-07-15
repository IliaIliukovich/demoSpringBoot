package com.telran.demospringboot;

import com.telran.demospringboot.controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {
        System.out.println("Main starts");

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        ConfigurableApplicationContext context = SpringApplication.run(DemoSpringBootApplication.class, args);
        System.out.println("Context created and initialized");

        DemoController demoController = (DemoController) context.getBean("demoController");
        System.out.println(demoController.findAll());

//        context.close();
//        System.out.println("Main ends");
    }

}
