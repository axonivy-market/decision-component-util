package com.axonivy.utils.decisioncomponent.demo.entities;

import java.util.Objects;

import com.axonivy.utils.persistence.beans.AuditableEntity;


public class CustomAuditableEntity extends AuditableEntity {
	
	private static final long serialVersionUID = 8952430704722898141L;

	@Override
	public int hashCode() {
		if (this.getId() == null) {// if id is zero super.hashcode returns wrong hashcode 0
			return System.identityHashCode(this);
		} else {
			return super.hashCode();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getId() == null) {// if id is null super.equals is not consistent with hascode
			return obj != null && Objects.equals(hashCode(), obj.hashCode());
		} else {
			return super.equals(obj);
		}

	}

	@Override
	public boolean hasValidId() {

		if (super.hasValidId()) {
			if (!getId().isBlank()) {
				return true;
			}
		}
		return false;
	}

}
