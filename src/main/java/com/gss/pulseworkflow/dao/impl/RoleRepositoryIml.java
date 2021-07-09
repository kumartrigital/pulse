package com.gss.pulseworkflow.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.RoleRepository;
import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.model.Weight;
@Repository
public class RoleRepositoryIml extends JdbcDaoSupport implements RoleRepository{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Role role) {
		role.setRoleStatusID("2");
		return jdbcTemplate.update(
                "insert into MSTR_POSITION (POSITION_NAME, POSITION_TYPE,POSITION_DESCRIPTION,POSITION_STATUS_ID,CREATOR_ID) values(?,?,?,?,?)",
                role.getRoleName(), role.getRoleType(),role.getRoleDescription(),role.getRoleStatusID(),role.getCreatorId());
	}
	@Override
	public int createRoleFromBulkLoad(String roleName) {
		//role.setRoleStatusID("2");
		return jdbcTemplate.update(
                "insert into MSTR_POSITION (POSITION_NAME,POSITION_STATUS_ID) values(?,?)",
                roleName,"2");
	}

	@Override
	public int update(Role role) {
		return jdbcTemplate.update(
                "update MSTR_POSITION set POSITION_NAME = ?, POSITION_TYPE=?, POSITION_DESCRIPTION=? where POSITION_ID = ?",
                role.getRoleName(),role.getRoleType(),role.getRoleDescription(),role.getRoleId());
		// TODO Auto-generated method stub
		//return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "DELETE FROM MSTR_POSITION where POSITION_ID=?",
                id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		System.out.println("Reository");
		return jdbcTemplate.query(
                "select POSITION_DESCRIPTION,POSITION_NAME,POSITION_TYPE,POSITION_ID,POSITION_STATUS_ID from MSTR_POSITION",
                (rs, rowNum) ->
                        new Role(
                                rs.getString("POSITION_DESCRIPTION"),
                                rs.getString("POSITION_NAME"),
                                rs.getString("POSITION_TYPE"),
                                rs.getLong("POSITION_ID"),
                                rs.getString("POSITION_STATUS_ID"))
        );
	}

	@Override
	public int saveToLog(long roleID, String action) {
		return jdbcTemplate.update(
                "insert into POSITION_LOG (POSITION_ID, EVENT_DESCRIPTION) values(?,?)",
                roleID, action);
	}

	@Override
	public long getRoleId(String roleName, String roleType) {
		return jdbcTemplate.queryForObject(
                "select POSITION_ID from MSTR_POSITION WHERE POSITION_NAME= ? and POSITION_TYPE=?",
                new Object[]{roleName,roleType},
                long.class
        );
	}
	@Override
	public  String getPositionIdByName(String roleName) {
		return jdbcTemplate.queryForObject(
                "select POSITION_ID from MSTR_POSITION WHERE POSITION_NAME= ?",
                new Object[]{roleName},
                String.class
        );
	}

	@Override
	public int saveToChild(long roleId, List<Weight> capWeights) {
		int x=0;
		for(Weight capWeight:capWeights) {
			x=jdbcTemplate.update(
	                "insert into POSITION_DETAIL (POSITION_ID, CAPABILITY_ID,WEIGHT) values(?,?,?)",
	                roleId,capWeight.getCapabilityId(),capWeight.getWeight());
		}
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int publish(long id) {
		return jdbcTemplate.update(
                "update MSTR_POSITION set POSITION_STATUS_ID = '0' where POSITION_ID = ?",
                id);
	}

	@Override
	public List<Weight> getChildData(long id) {
		return jdbcTemplate.query("SELECT POSITION_DETAIL.CAPABILITY_ID AS CAPABILITYID,POSITION_DETAIL.WEIGHT AS WEIGHT, MSTR_CAPABILITY.CAPABILITY_NAME AS CAPABILITYNAME FROM  POSITION_DETAIL JOIN MSTR_CAPABILITY ON"
				+ " POSITION_DETAIL.CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID where POSITION_DETAIL.POSITION_ID=?", new Object[]{id},
				(rs, rowNum) ->new Weight(
                rs.getLong("CAPABILITYID"),
                rs.getString("WEIGHT"),
                rs.getString("CAPABILITYNAME")));
	}

	@Override
	public int deleteByIdChild(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "DELETE FROM POSITION_DETAIL where POSITION_ID=?",
                id);
	}

	@Override
	public int deleteByIdStatus(Long id) {
		return jdbcTemplate.update(
                "update MSTR_POSITION set POSITION_STATUS_ID = '1' where POSITION_ID = ?",
                id);
	}

	@Override
	public int removeFromChild(long roleId) {
		// TODO Auto-generated method stub
		int x=0;
		//for(long capabilityId:removeRoles) {
			return jdbcTemplate.update(
	                "DELETE from POSITION_DETAIL where POSITION_ID=?",
	                roleId);
		//}
		//return x;
	}

	@Override
	public int updateToChild(long roleId, List<Weight> addRoles) {
		int x=0;
		for(Weight weight:addRoles) {
			x=jdbcTemplate.update(
	                "insert into POSITION_DETAIL (POSITION_ID, CAPABILITY_ID,WEIGHT) values(?,?,?)",
	                roleId,weight.getCapabilityId(),weight.getWeight());
		
		}
		return x;
	}
	@Override
	public List<Object> getPositionName(){
		HashMap<Long,String> data=new HashMap<Long,String>();
		return jdbcTemplate.query(
                "SELECT POSITION_ID,POSITION_NAME FROM MSTR_POSITION WHERE MSTR_POSITION.POSITION_STATUS_ID='0'",
                (rs, rowNum) ->
                data.put(rs.getLong("POSITION_ID"), rs.getString("POSITION_NAME"))
                               
        );
	}

	@Override
	public int updateExistingChild(long roleId, List<Weight> existingCaps) {
		int x=0;
		for(Weight weight:existingCaps) {
			x=jdbcTemplate.update(
	                "update POSITION_DETAIL set WEIGHT= ? where POSITION_ID=? and CAPABILITY_ID=?",
	                weight.getWeight(),roleId,weight.getCapabilityId());
		
		}
		return x;
	}

	@Override
	public String getStatus(long roleId) {
		return jdbcTemplate.queryForObject(
                "SELECT STATUS_VALUE FROM MSTR_STATUS WHERE STATUS_ID IN (SELECT POSITION_STATUS_ID FROM MSTR_POSITION WHERE POSITION_ID=?)",
                new Object[]{roleId},
                String.class
        );
	}
	@Override
	public List<Role> roleSearch(String query) {
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Role(rs.getString("POSITION_DESCRIPTION"), rs.getString("POSITION_NAME"),
						rs.getString("POSITION_TYPE"), rs.getLong("POSITION_ID"), rs.getString("POSITION_STATUS_ID")));
	}
	
	
	public static void main(String args[]){  
		try{  
			//String role=getPositionIdByName("");
			//System.out.println("role  "+role);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://142.4.9.16:3306/pulse?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","pulse","G$$1nfot3ch");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select COUNT(POSITION_NAME) from MSTR_POSITION WHERE POSITION_NAME= 'Lead Architect'");  
		while(rs.next())  
		System.out.println(rs.getString(1));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}

	 
	@Override
	public  long positionAvailability(String roleName) {
		System.out.println("inside ");
		return jdbcTemplate.queryForObject(
                "select COUNT(*) from MSTR_POSITION WHERE POSITION_NAME=?",
                new Object[]{roleName},
                long.class
        );
	}

	@Override
	public long existingRole(String roleName, String roleType) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM MSTR_POSITION WHERE POSITION_NAME=? AND POSITION_TYPE=?",
                new Object[]{roleName,roleType},
                long.class
        );
	}

}
