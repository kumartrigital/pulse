package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.dao.UserRoleRepository;
import com.gss.pulseworkflow.model.UserRoles;
import com.gss.pulseworkflow.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<UserRoles> getUserAccessRoles() {
		return userRoleRepository.getUserAccessRoles();
	}

}
