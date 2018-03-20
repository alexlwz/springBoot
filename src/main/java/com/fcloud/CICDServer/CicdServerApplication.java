package com.fcloud.CICDServer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.fcloud.CICDServer.Mapper")
public class CicdServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicdServerApplication.class, args);

		// SpringApplication app = new
		// SpringApplication(CicdServerApplication.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.run(args);
	}
	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// return args -> {
	//
	// System.out.println("Let's inspect the beans provided by Spring Boot:");
	//
	// String[] beanNames = ctx.getBeanDefinitionNames();
	// Arrays.sort(beanNames);
	// for (String beanName : beanNames) {
	// System.out.println(beanName);
	// }
	//
	// };
	// }

	/*
	 * @Override public void run(String... arg0) throws Exception {
	 * System.out.println(arg0);
	 * 
	 * }
	 */
}
