package com.e.sante.enu;

public enum GroupeType {
	A("Groupe A"), B("Groupe B"), AB("Groupe AB"), O("Groupe O");

	private String groupe = "";

	GroupeType(String groupe) {
		this.setGroupe(groupe);
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
}
