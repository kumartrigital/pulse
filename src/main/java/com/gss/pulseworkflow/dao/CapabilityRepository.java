package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Capability;

public interface CapabilityRepository {

	int count();

	int save(Capability capability,String loggedInUser);

	int update(Capability capability);

	int deleteById(Long id);

	List<Capability> findAll();

	int saveToLog(long capabilityID, String action);

	long getCapabilityId(String capabilityName, String capabiliyType);

	int publish(long capabilityID);

	int perDelete(long capabilityId);

	Capability getCapabilityObj(String capabilityName, String capabiliyType);
	List<Capability> capabilitySearch(String query);
	long existingCapability(String capabilityNmae,String capabilityType);

}
