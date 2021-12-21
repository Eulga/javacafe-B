package edu.sp5.javacafe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import edu.sp5.javacafe.dao.derby.CafeMasterDaoDerby;
import edu.sp5.javacafe.dao.derby.CustomerDaoDerby;
import edu.sp5.javacafe.dao.derby.MenuDaoDerby;
import edu.sp5.javacafe.dao.derby.OrderDaoDerby;
import edu.sp5.javacafe.service.CafeMasterService;
import edu.sp5.javacafe.service.CustomerService;
import edu.sp5.javacafe.service.MenuService;
import edu.sp5.javacafe.service.OrderService;

@Configuration
@ComponentScan(basePackages = "edu.sp5.javacafe")
@EnableTransactionManagement
@Import(DataSourceConfig.class)
public class JavaCafeConfig extends DataSourceConfig {
	
	@Bean
	public CafeMasterDaoDerby cafeMasterDaoDerby() {
		return new CafeMasterDaoDerby();
	}
	
	@Bean
	public CustomerDaoDerby customerDaoDerby() {
		return new CustomerDaoDerby();
	}
	
	@Bean
	public MenuDaoDerby menuDaoDerby() {
		return new MenuDaoDerby();
	}
	
	@Bean
	public OrderDaoDerby orderDaoDerby() {
		return new OrderDaoDerby();
	}
	
	@Bean
	public CafeMasterService cafeMasterService() {
		return new CafeMasterService();
	}
	
	@Bean
	public CustomerService customerService() {
		return new CustomerService();
	}
	
	@Bean
	public MenuService menuService() {
		return new MenuService();
	}
	
	@Bean
	public OrderService orderService() {
		return new OrderService();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
}
