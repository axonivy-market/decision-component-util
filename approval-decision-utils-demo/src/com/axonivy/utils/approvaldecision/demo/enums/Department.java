package com.axonivy.utils.approvaldecision.demo.enums;

public enum Department {

	IT("It", "It@axonivy.com"), HR("Hr", "Hr@axonivy.com"), MARKETING("Marketing", "Marketing@axonivy.com"),
	PRODUCTION("Production", "Production@axonivy.com");

	private String name;
	private String email;

	private Department(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
