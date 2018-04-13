package com.comr.escxxi.model;

public enum Roles {
	
	ADMIN("ADMIN"), TEACHER("PROFESOR"),STUDENT("ALUMNO"),ADVISOR("TUTOR");
	
	private final String text;
	
	Roles(final String text) {
        this.text = text;
    }
	
	@Override
    public String toString() {
        return text;
    }
}
