package com.iao.model;

import java.io.Serializable;
import java.sql.Date;

public class CreditModel implements Serializable {

	private int NumCred;
	private int NumCli;
	private double MonCre;
	private double dureeCre;
	private double tauxCre;
	private double AnnCred;
	private java.util.Date DatPre;

	public CreditModel() {
		super();
	}

	public int getNumCred() {
		return NumCred;
	}

	public void setNumCred(int numCred) {
		NumCred = numCred;
	}

	public int getNumCli() {
		return NumCli;
	}

	public java.util.Date getDatPre() {
		return DatPre;
	}

	public void setDatPre(java.util.Date date) {
		DatPre = date;
	}

	public void setNumCli(int numCli) {
		NumCli = numCli;
	}

	public double getMonCre() {
		return MonCre;
	}

	public void setMonCre(double monCre) {
		MonCre = monCre;
	}

	public double getDureeCre() {
		return dureeCre;
	}

	public void setDureeCre(double duree) {
		this.dureeCre = duree;
	}

	public double getTauxCre() {
		return tauxCre;
	}

	public void setTauxCre(double tauxCre) {
		this.tauxCre = tauxCre;
	}

	public double getAnnCred() {
		return AnnCred;
	}

	public void setAnnCred(double annCred) {
		AnnCred = annCred;
	}

	@Override
	public String toString() {
		return "CreditModel [NumCred=" + NumCred + ", NumCli=" + NumCli + ", MonCre=" + MonCre + ", dureeCre="
				+ dureeCre + ", tauxCre=" + tauxCre + ", AnnCred=" + AnnCred + ", DatPre=" + DatPre + "]";
	}

}
