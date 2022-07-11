package ch.zli.m223.ksh19a.mj.CRM.controller;


import ch.zli.m223.ksh19a.mj.CRM.model.AppUser;

public class UserDTO {

	public Long id;
	public String name;
	
	public UserDTO(AppUser appUser) {
		id = appUser.getID();
		name = appUser.getName();
	}
}
