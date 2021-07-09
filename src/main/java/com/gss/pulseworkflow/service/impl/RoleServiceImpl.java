package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.RoleRepository;
import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.model.Weight;
import com.gss.pulseworkflow.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int saveRole(Role role) {
		int childFlag=0;
		int saveFlag = roleRepository.save(role);
		if (saveFlag > 0) {
			long roleId = roleRepository.getRoleId(role.getRoleName(), role.getRoleType());
			childFlag = roleRepository.saveToChild(roleId, role.getRoleCapWeight());
		}
		return childFlag;
	}

	@Override
	@Transactional
	public int updateRole(Role role) {
		String status = roleRepository.getStatus(role.getRoleId());
		int updateFlag = 0;
		int updateChildFlag = 0;
		int resFlag=0;
		if (status.equalsIgnoreCase("DRAFT") || status == "DRAFT" || status.equalsIgnoreCase("DISABLED")
				|| status == "DISABLED") {
			updateFlag = roleRepository.update(role);
			if (updateFlag > 0) {
				roleRepository.removeFromChild(role.getRoleId());
				if (role.getRoleCapWeight().size() > 0) {
					updateChildFlag = roleRepository.updateToChild(role.getRoleId(), role.getRoleCapWeight());
					if (updateChildFlag > 0) {
						resFlag=1;
					}
				}
			}
		} else if (status.equalsIgnoreCase("ACTIVE") || status == "ACTIVE") {
			updateFlag = roleRepository.update(role);
			if (updateFlag > 0) {
				roleRepository.removeFromChild(role.getRoleId());
				if (role.getRoleCapWeight().size() > 0) {
					updateChildFlag = roleRepository.updateToChild(role.getRoleId(), role.getRoleCapWeight());
					if (updateChildFlag > 0) {
						int logFlag = roleRepository.saveToLog(role.getRoleId(), "Update_" + role.getComment());
						if(logFlag > 0) {
							resFlag=1;
						}
					}
				}
			}
		}
		return resFlag;
	}

	@Override
	@Transactional
	public int deleteById(Long id) {
		int deleteFlag = 0;
		int resFlag = 0;
		String status = roleRepository.getStatus(id);
		if (status.equalsIgnoreCase("DRAFT") || status == "DRAFT") {
			deleteFlag = roleRepository.deleteById(id);
			if (deleteFlag > 0) {
				roleRepository.deleteByIdChild(id);
				resFlag = 1;
			}
		} else if (status.equalsIgnoreCase("ACTIVE") || status == "ACTIVE") {
			deleteFlag = roleRepository.deleteByIdStatus(id);
			if (deleteFlag > 0) {
				roleRepository.saveToLog(id, "Delete");
				resFlag = 1;
			}
		}
		return resFlag;
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roleRes = roleRepository.findAll();
		if (roleRes.size() > 0) {
			for (Role roleObj : roleRes) {
				List<Weight> weightObj = roleRepository.getChildData(roleObj.getRoleId());
				roleObj.setExistingCap(weightObj);
			}
		}
		return roleRes;
	}

	@Override
	public int saveToLog(long roleID, String action) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getRoleId(String roleName, String roleType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveToChild(long roleId, List<Long> capabilities) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int publishRole(long id,String comment) {
		int logFlag=0;
		int publishFlag = roleRepository.publish(id);
		if (publishFlag > 0) {
			logFlag = roleRepository.saveToLog(id, "Add_" + comment);
		}
		return logFlag;
	}

	@Override
	public List<Weight> getChildData(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByIdChild(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdStatus(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFromChild(long roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateToChild(long roleId, List<Weight> addRoles) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateExistingChild(long roleId, List<Weight> existingCaps) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStatus(long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getPositionName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> roleSearch(Role role) {
		String query = "select POSITION_DESCRIPTION,POSITION_NAME,POSITION_TYPE,POSITION_ID,"
				+ "POSITION_STATUS_ID from MSTR_POSITION";
		boolean searchFlag = false;
		if (role.getRoleName() != null) {
			query = query + " WHERE POSITION_NAME LIKE '%" + role.getRoleName().trim() + "%'";
			searchFlag = true;
		}
		if (role.getRoleType() != null && searchFlag) {
			query = query + " AND POSITION_TYPE LIKE '%" + role.getRoleType().trim() + "%'";
			searchFlag = true;
		} else if (role.getRoleType() != null && !searchFlag) {
			query = query + " WHERE POSITION_TYPE LIKE '%" + role.getRoleType().trim() + "%'";
			searchFlag = true;
		}
		if (role.getRoleStatusID() != null && searchFlag) {
			query = query + " AND POSITION_STATUS_ID='" + role.getRoleStatusID().trim() + "'";
			searchFlag = true;
		} else if (role.getRoleStatusID() != null && !searchFlag) {
			query = query + " WHERE POSITION_STATUS_ID='" + role.getRoleStatusID().trim() + "'";
			searchFlag = true;
		}
		List<Role> roleRes = roleRepository.roleSearch(query);
		if (roleRes.size() > 0) {
			for (Role roleObj : roleRes) {
				List<Weight> weightObj = roleRepository.getChildData(roleObj.getRoleId());
				roleObj.setExistingCap(weightObj);
			}
		}
		return roleRes;
	}

	@Override
	public long existingRole(String roleName, String roleType) {
		// TODO Auto-generated method stub
		return roleRepository.existingRole(roleName,roleType);
	}
}
