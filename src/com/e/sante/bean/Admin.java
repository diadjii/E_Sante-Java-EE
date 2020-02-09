package com.e.sante.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id_admin")
public class Admin extends User {
	private static final long serialVersionUID = 1L;

}
