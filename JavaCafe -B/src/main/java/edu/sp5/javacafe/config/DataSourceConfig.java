package edu.sp5.javacafe.config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/javacafe");
		ds.setUsername("root");
		ds.setPassword("adminadmin");
		
		ds.setInitialSize(2);
		ds.setMaxActive(10);	//default 100
		ds.setMaxIdle(10);		//idle �� ���Խ� ������ ���� idle �� maxActive���� Ŭ���� ���� ����
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
}
