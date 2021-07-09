package com.gss.pulseworkflow.model;

import java.util.List;

public class Hierarchies {
	private List<Hierarchy> updateHierarchy;

	public List<Hierarchy> getUpdateHierarchy() {
		return updateHierarchy;
	}

	public void setUpdateHierarchy(List<Hierarchy> updateHierarchy) {
		this.updateHierarchy = updateHierarchy;
	}

	public Hierarchies(List<Hierarchy> updateHierarchy) {
		super();
		this.updateHierarchy = updateHierarchy;
	}

	@Override
	public String toString() {
		return "Hierarchies [updateHierarchy=" + updateHierarchy + "]";
	}
	public Hierarchies() {
		super();
	}

}
