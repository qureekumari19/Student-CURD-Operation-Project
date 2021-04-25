package com.psl.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.psl.*;")
@EnableWebMvc
public class StudentConfig implements WebMvcConfigurer{


	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}	
	

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		SingleConnectionDataSource dataSource=new SingleConnectionDataSource();
		//Oracle database we are using
			    System.out.println("1");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			    System.out.println("2");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");//change url
			    System.out.println("3");
		dataSource.setUsername("system");//change userid
			    System.out.println("4");
		dataSource.setPassword("quree");//change pwd. using Root credentials is not a good idea. 
		//Instead use dedicated DB users, grant them appropriate privilege
			    System.out.println("5");
		return dataSource;	     
	}	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
				System.out.println("6");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
			    System.out.println("7");
		jdbcTemplate.setDataSource(dataSource());
			    System.out.println("8");
		return jdbcTemplate;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/URLtoReachResources/**").addResourceLocations("WEB-INF/resources/");
	}
}
