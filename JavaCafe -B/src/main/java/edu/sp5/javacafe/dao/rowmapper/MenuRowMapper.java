package edu.sp5.javacafe.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.javacafe.domain.Menu;

public class MenuRowMapper implements RowMapper<Menu>{

	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu menu = new Menu();
		menu.setItemNumber(rs.getLong("itemNumber"));
		menu.setItemName(rs.getString("itemName"));
		menu.setItemCategory(rs.getString("itemCategory"));
		menu.setItemPrice(rs.getDouble("itemPrice"));
		menu.setItemImage(rs.getString("itemImage"));
		menu.setSalesSeason(rs.getString("salesSeason"));
		
		return menu;
	}
}
