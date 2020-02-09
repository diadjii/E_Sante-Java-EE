package com.e.sante.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "consultation")
public class Consultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consultation")
	private int id;

	@Column(name = "id_patient")
	private int idPatient;

	@Column(name = "id_medecin")
	private int idMedecin;

	@Column(name = "facture")
	private double facture;

	@Column(name = "motif")
	private String motif;

	@Column(name = "examen")
	private String examen;

	@Column(name = "prescription")
	private String prescription;

	@Column(name = "date_cslt")
	private String datecslt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public double getFacture() {
		return facture;
	}

	public void setFacture(double facture) {
		this.facture = facture;
	}

	public String getExamen() {
		return examen;
	}

	public String getDatecslt() {
		return datecslt;
	}

	public void setExamen(String examen) {
		this.examen = examen;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public void setDatecslt(String datecslt) {
		this.datecslt = datecslt;
	}

}
