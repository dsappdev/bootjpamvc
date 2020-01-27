package com.dspohn.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	
	@Id
	private int alienID;
	private String alienName;
	private String tech;
	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getAlienID() {
		return alienID;
	}
	public void setAlienID(int alienID) {
		this.alienID = alienID;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	@Override
	public String toString() {
		return "Alien [ID=" + alienID + ", Name=" + alienName + ", Ability=" + tech + "]";
	}	
}
