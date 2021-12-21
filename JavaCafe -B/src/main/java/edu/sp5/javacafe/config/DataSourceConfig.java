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
		ds.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		ds.setUrl("jdbc:derby://localhost:1527/javacafe");
		ds.setUsername("javacafe");
		ds.setPassword("javacafe");
		
		ds.setInitialSize(2);
		ds.setMaxActive(10);	//default 100
		ds.setMaxIdle(10);		//idle 미 기입시 경고딱지 붙음 idle 이 maxActive보다 클수는 없기 때문
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	
}
