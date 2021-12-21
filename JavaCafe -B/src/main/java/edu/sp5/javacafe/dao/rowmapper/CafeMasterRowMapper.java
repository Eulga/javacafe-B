package edu.sp5.javacafe.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.sp5.javacafe.domain.CafeMaster;

public class CafeMasterRowMapper implements RowMapper<CafeMaster>{
	/**
	 * 
	 * CafeMaster
	 * long masterNumber
	 * String passwd
	 * String phoneNumber
	 */
	
	@Override
	public CafeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		CafeMaster cm = new CafeMaster();
		cm.setMasterNumber(rs.getLong("masterNumber"));
		cm.setPasswd(rs.getString("passwd"));
		cm.setPhoneNumber(rs.getString("phoneNumber"));
		return cm;
	}
}
