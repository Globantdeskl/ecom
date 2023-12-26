package com.aeo.logging;

public enum EnvProperty {
	APP_NAME("spring.application.name"),
	APP_PORT("local.server.port"),
	ORGANIZATION_NAME("cloud.application.organization_name"),
	SPACE_NAME("cloud.application.space_name"),
	ORGANIZATION_ID("cloud.application.organization_id"),
	INSTANCE_ID("cloud.application.instance_id"),
	PROCESS_ID("cloud.application.process_id"),
	APPLICATION_ID("cloud.application.application_id"),
	APPLICATION_VERSION("cloud.application.application_version");
	
	private final String propName;
	private EnvProperty(String propName) {
		this.propName = propName;
	}
	
	public String propName() {
		return this.propName;
	}
	
	public String key() {
		return this.name().toLowerCase();
	}
}
