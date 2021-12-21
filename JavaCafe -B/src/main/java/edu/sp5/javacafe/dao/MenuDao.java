package edu.sp5.javacafe.dao;

import java.util.List;

import edu.sp5.javacafe.domain.Menu;

public interface MenuDao {
	public void addMenu(Menu menu);
	public void addStock(long itemNumber, long itemStock);
	public void setStock(long itemNumber, long itemStock);
	public void deleteMenu(long itemNumber);
	public void updateMenu(Menu menu);
	public Menu findMenuByItemNumber(long itemNumber);
	public List<Menu> findAllMenus();

}
