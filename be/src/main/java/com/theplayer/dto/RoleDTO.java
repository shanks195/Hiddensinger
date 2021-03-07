package com.theplayer.dto;

import com.theplayer.entity.ERole;

public class RoleDTO extends AbstractDTO<RoleDTO> {
	
	private ERole name;

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
