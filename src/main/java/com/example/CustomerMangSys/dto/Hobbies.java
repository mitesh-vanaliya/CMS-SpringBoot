package com.example.CustomerMangSys.dto;

public class Hobbies {

	public Hobbies(int id, String name,boolean isChecked) {
		this.id = id;
		this.name = name;
		this.isChecked = isChecked;
	}
	private int id;
	private String name;
	private boolean isChecked;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	
	
}
