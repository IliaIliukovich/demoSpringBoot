package com.telran.demospringboot.configuration;

import com.telran.demospringboot.controller.DemoController;
import com.telran.demospringboot.repository.DemoRepository;
import com.telran.demospringboot.service.DemoService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Configuration
public class AppContext {

//    @Bean(name = "demoContr", initMethod = "initDemoMethod", destroyMethod = "destroyDemoMethod")
//    @Lazy
//    public DemoController demoController(){
//        return new DemoController(demoService());
//    }
//
//    @Bean(name = "demoContr2")
//    public DemoController demoController2(){
//        return new DemoController(demoService());
//    }
//
//    @Bean
//    public DemoService demoService(){
//        return new DemoService(demoRepository());
//    }
//
//    @Bean
////    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public DemoRepository demoRepository(){
//        return new DemoRepository();
//    }

}
