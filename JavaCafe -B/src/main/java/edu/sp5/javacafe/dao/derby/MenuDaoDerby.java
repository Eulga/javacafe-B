package edu.sp5.javacafe.dao.derby;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.sp5.javacafe.dao.MenuDao;
import edu.sp5.javacafe.dao.rowmapper.MenuAndStockRowMapper;
import edu.sp5.javacafe.dao.rowmapper.MenuRowMapper;
import edu.sp5.javacafe.domain.Menu;

@Repository
public class MenuDaoDerby implements MenuDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void addMenu(Menu menu) {
		String sql = "INSERT INTO MenuItem(itemNumber, itemName, itemCategory, itemPrice, itemImage, salesSeason) VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, menu.getItemNumber(), menu.getItemName(), menu.getItemCategory(), menu.getItemPrice(), menu.getItemImage(), menu.getSalesSeason());
	}
	
	@Override
	public void addStock(long itemNumber, long itemStock) {
		String sql = "INSERT INTO Stock(itemNumber, itemStock) VALUES(?, ?)";
		jdbcTemplate.update(sql, itemNumber, itemStock);
	}
	
	@Override
	public void setStock(long itemNumber, long itemStock) {
		String sql = "UPDATE Stock SET itemStock=? WHERE itemNumber = ?";
		jdbcTemplate.update(sql, itemStock, itemNumber);
	}

	@Override
	public void deleteMenu(long itemNumber) {
		String sql = "DELETE FROM MenuItem WHERE itemNumber=? ";
		jdbcTemplate.update(sql, itemNumber);
	}
	
	public void deleteStock(long itemNumber) {
		String sql = "DELETE FROM Stock WHERE itemNumber=? ";
		jdbcTemplate.update(sql, itemNumber);
	}

	@Override
	public void updateMenu(Menu menu) {
		String sql = "UPDATE MenuItem SET itemName=?, itemCategory=?, itemPrice=?, itemImage=?, salesSeason=? WHERE itemNumber = ? ";
		jdbcTemplate.update(sql, menu.getItemName(), menu.getItemCategory(), menu.getItemPrice(), menu.getItemImage(), menu.getSalesSeason(), menu.getItemNumber());
	}

	public Menu findMenuByItemName(String itemName) {
		String sql = "SELECT m.itemNumber, m.itemName, m.itemCategory, m.itemPrice, m.itemImage, m.salesSeason, s.itemStock"
				+ " FROM MenuItem m INNER JOIN Stock s ON m.itemNumber = s.itemNumber"
				+ " WHERE m.itemName = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new MenuAndStockRowMapper(), itemName);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Menu findMenuByItemNumber(long itemNumber) {
		String sql = "SELECT * FROM MenuItem WHERE itemNumber = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new MenuRowMapper(), itemNumber);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}	
	}
	
	public Menu findMenusAndStockByItemNumber(long itemNumber) {
		String sql = "SELECT m.itemNumber, m.itemName, m.itemCategory, m.itemPrice, m.itemImage, m.salesSeason, s.itemStock"
				+ " FROM MenuItem m INNER JOIN Stock s ON m.itemNumber = s.itemNumber"
				+ " WHERE m.itemNumber = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new MenuAndStockRowMapper(), itemNumber);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}	
	}

	public List<Menu> findAllMenusAndStock() {
		String sql = "SELECT MenuItem.*, itemStock "
				+ "FROM MenuItem LEFT JOIN Stock ON MenuItem.itemNumber = Stock.itemNumber";
		return jdbcTemplate.query(sql, new MenuAndStockRowMapper());
	}
	
	@Override
	public List<Menu> findAllMenus() {
		String sql = "SELECT * FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuRowMapper());
	}


}
