package com.e.sante.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "medecin")
@PrimaryKeyJoinColumn(name = "id_user")
public class Medecin extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_service")
	private int idService;

	public int getIdService() {
		return idService;
	}

	public void setIdService(int service) {
		this.idService = service;
	}

}
