package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.UserRoles;

public interface UserRoleRepository {
	List<UserRoles> getUserAccessRoles();

}
