package com.e.sante.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "rv")
public class RendezVous implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rv")
	private int id;

	@Column(name = "id_patient")
	private int idPatient;

	@Column(name = "id_service")
	private int idService;

	@Column(name = "etat")
	private int etat;

	@Column(name = "date")
	private String date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPa) {
		this.idPatient = idPa;
	}

	public int getIdService() {
		return idService;
	}

	public void setIdService(int idSer) {
		this.idService = idSer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}
