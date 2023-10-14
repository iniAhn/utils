package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.config.BeanContext;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo" })
public class DemoApplication {

	private final ApplicationContext context;	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		BeanContext.init(context); // 3. 객체의 생명주기를 이용해 스태틱 참조변수에 주입한다.
	} // 스프링 앱이 정상적으로 기동된 후에 주입된다.
	
	public DemoApplication(ApplicationContext context) {
		this.context = context;
	}
}
