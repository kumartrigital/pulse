package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.UserRoleRepository;
import com.gss.pulseworkflow.model.UserRoles;
@Repository
public class UserRoleRepositoryImpl extends JdbcDaoSupport implements UserRoleRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<UserRoles> getUserAccessRoles() {
		return getJdbcTemplate().query(
				"SELECT ROLES.ID,ROLES.ROLE_NAME FROM ROLES",
				(rs, rowNum) -> new UserRoles(rs.getLong("ID"), rs.getString("ROLE_NAME")));
	}

}
