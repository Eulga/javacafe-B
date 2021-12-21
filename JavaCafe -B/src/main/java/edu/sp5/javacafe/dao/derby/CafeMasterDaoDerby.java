package edu.sp5.javacafe.dao.derby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.sp5.javacafe.dao.CafeMasterDao;
import edu.sp5.javacafe.dao.rowmapper.CafeMasterRowMapper;
import edu.sp5.javacafe.domain.CafeMaster;




public class CafeMasterDaoDerby implements CafeMasterDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public CafeMaster findCafeMaster() {
		String sql;
		sql = "SELECT * FROM CafeMaster";
		try {
			return jdbcTemplate.queryForObject(sql, new CafeMasterRowMapper());
		} catch(Exception e) {
			return null;
		}
		
	}
	
	@Override
	public void update(String masterNumber, String phoneNumber, String passwd) {
		String sql = "UPDATE CafeMaster SET phoneNumber=? passwd=? WHERE masterNumber=?";
		jdbcTemplate.update(sql, masterNumber, phoneNumber, passwd);
	}
}
