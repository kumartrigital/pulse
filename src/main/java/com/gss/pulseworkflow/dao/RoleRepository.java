package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.model.Weight;

public interface RoleRepository {

	int count();

	int save(Role role);

	int update(Role role);

	int deleteById(Long id);

	List<Role> findAll();

	int saveToLog(long roleID, String action);

	long getRoleId(String roleName, String roleType);
	String getPositionIdByName(String roleName);
	int createRoleFromBulkLoad(String roleName);
	long positionAvailability(String roleName);

	int saveToChild(long roleId, List<Weight> capWeight);

	int publish(long id);

	List<Weight> getChildData(long id);

	int deleteByIdChild(Long id);

	int deleteByIdStatus(Long id);

	int removeFromChild(long roleId);

	int updateToChild(long roleId, List<Weight> addRoles);

	int updateExistingChild(long roleId, List<Weight> existingCaps);

	String getStatus(long roleId);

	List<Object> getPositionName();
	List<Role> roleSearch(String query);
	long existingRole(String roleName, String roleType);

}
