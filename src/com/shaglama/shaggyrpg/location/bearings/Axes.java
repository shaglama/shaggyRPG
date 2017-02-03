package com.shaglama.shaggyrpg.location.bearings;

public enum Axes {
	LATERAL("Side to Side"),LONGITUDINAL("Front to Back"),VERTICAL("Top to bottom"),X("Side to side"),Y("Front to back"),Z("Top to bottom");
	private String description;
	private Axes(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	
}
