package com.e.sante.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "patient")
@PrimaryKeyJoinColumn(name = "id_user")
public class Patient extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "etat")
	private int etat;

	@Column(name = "groupe")
	private String groupe;

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
