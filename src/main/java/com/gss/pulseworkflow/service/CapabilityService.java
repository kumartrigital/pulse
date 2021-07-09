package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Capability;

public interface CapabilityService {

	int count();

	int saveCapability(Capability capability,String loggedInUser);

	int updateCapability(Capability capability);

	int deleteCapabilityById(Long id);

	List<Capability> getAllCapabilities();

	int publishCapability(long capabilityID, String comment);
	List<Capability> capabilitySearch(Capability capability);
	long existingCapability(String capabilityNmae,String capabilityType);

}
