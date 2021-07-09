package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.model.Weight;

public interface RoleService {
	
	int count();

	int saveRole(Role role);

	int updateRole(Role role);

	int deleteById(Long id);

	List<Role> getAllRoles();

	int saveToLog(long roleID, String action);

	long getRoleId(String roleName, String roleType);

	int saveToChild(long roleId, List<Long> capabilities);

	int publishRole(long id,String comment);

	List<Weight> getChildData(long id);

	int deleteByIdChild(Long id);

	int deleteByIdStatus(Long id);

	int removeFromChild(long roleId);

	int updateToChild(long roleId, List<Weight> addRoles);

	int updateExistingChild(long roleId, List<Weight> existingCaps);

	String getStatus(long roleId);

	List<Object> getPositionName();
	List<Role> roleSearch(Role role);
	long existingRole(String roleName, String roleType);

}
