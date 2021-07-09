package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.CapabilityRepository;
import com.gss.pulseworkflow.model.Capability;
import com.gss.pulseworkflow.service.CapabilityService;

@Service
public class CapabilityServiceImpl implements CapabilityService {
	@Autowired
	private CapabilityRepository capabilityRepository;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int saveCapability(Capability capability,String loggedInUser) {
		int logFlag = 0;
		int saveFlag = capabilityRepository.save(capability,loggedInUser);
		if (saveFlag > 0) {
			long capabilityId = capabilityRepository.getCapabilityId(capability.getCapabilityName(),
					capability.getCapabilityType());
			logFlag = capabilityRepository.saveToLog(capabilityId, "Add");

		}
		return logFlag;
	}

	@Override
	@Transactional
	public int updateCapability(Capability capability) {
		int logFlag = 0;
		int updateFlag = capabilityRepository.update(capability);
		if (updateFlag > 0) {
			String action = "Update _" + capability.getComment();
			logFlag = capabilityRepository.saveToLog(capability.getCapabilityID(), action);

		}
		return logFlag;
	}

	@Override
	@Transactional
	public int deleteCapabilityById(Long id) {
		int logFlag = 0;
		int deletedFlag = capabilityRepository.deleteById(id);
		if (deletedFlag > 0) {
			logFlag = capabilityRepository.saveToLog(id, "Delete");
		}
		return logFlag;
	}

	@Override
	public List<Capability> getAllCapabilities() {
		return capabilityRepository.findAll();
	}

	@Override
	@Transactional
	public int publishCapability(long capabilityID, String comment) {
		int logFlag = 0;
		int publishFlag = capabilityRepository.publish(capabilityID);
		if (publishFlag > 0) {
			logFlag = capabilityRepository.saveToLog(capabilityID, "Add_" + comment);
		}
		return logFlag;
	}
	
	@Override
	public List<Capability> capabilitySearch(Capability capability) {
		String query="SELECT MSTR_CAPABILITY.CAPABILITY_ID,MSTR_CAPABILITY.CAPABILITY_NAME,"
				+ "MSTR_CAPABILITY.CAPABILITY_TYPE,"
				+ "MSTR_CAPABILITY.CAPABILITY_DESCRIPTION,MSTR_CAPABILITY.CAPABILITY_STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
				+ "MSTR_CAPABILITY.CREATOR_ID,EMP_DETAIL.EMAIL,MSTR_CAPABILITY.CREATED_DATE FROM MSTR_CAPABILITY "
				+ "JOIN MSTR_STATUS ON MSTR_STATUS.STATUS_ID=MSTR_CAPABILITY.CAPABILITY_STATUS_ID JOIN "
				+ "EMP_DETAIL ON EMP_DETAIL.EMPLOYEE_ID=MSTR_CAPABILITY.CREATOR_ID";
		boolean searchFlag=false;
		if (capability.getCapabilityName() != null) {
			query = query + " WHERE MSTR_CAPABILITY.CAPABILITY_NAME LIKE '%" + capability.getCapabilityName().trim() + "%'";
			searchFlag = true;
		}
	if (capability.getCapabilityType() != null && searchFlag) {
		query = query + " AND MSTR_CAPABILITY.CAPABILITY_TYPE='" + capability.getCapabilityType().trim() + "'";
		searchFlag = true;
	} else if (capability.getCapabilityType() != null && !searchFlag) {
		query = query + " WHERE MSTR_CAPABILITY.CAPABILITY_TYPE='" + capability.getCapabilityType().trim() + "'";
		searchFlag = true;
	}
	if (capability.getCapabilityStatusId() != null && searchFlag) {
		query = query + " AND MSTR_CAPABILITY.CAPABILITY_STATUS_ID='" + capability.getCapabilityStatusId().trim() + "'";
		searchFlag = true;
	} else if (capability.getCapabilityStatusId() != null && !searchFlag) {
		query = query + " WHERE MSTR_CAPABILITY.CAPABILITY_STATUS_ID='" + capability.getCapabilityStatusId().trim() + "'";
		searchFlag = true;
	}
		return capabilityRepository.capabilitySearch(query);
	}

	@Override
	public long existingCapability(String capabilityNmae, String capabilityType) {
		// TODO Auto-generated method stub
		return capabilityRepository.existingCapability(capabilityNmae,capabilityType);
	}

}
