package com.ryas.inheritanceHbm;

public class Cheque extends Payment {

	private String bankName;
	private String chequeName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getChequeName() {
		return chequeName;
	}

	public void setChequeName(String chequeName) {
		this.chequeName = chequeName;
	}

}
