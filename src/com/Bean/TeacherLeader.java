package com.Bean;

/**
 * 
 * 列表形式
 * 
 * 如教授，院长，书记
 * **/
public class TeacherLeader {
	int tlID, tlType,tlOrder;
	String tlName;

	public int getTlOrder() {
		return tlOrder;
	}

	public void setTlOrder(int tlOrder) {
		this.tlOrder = tlOrder;
	}

	public int getTlID() {
		return tlID;
	}

	public void setTlID(int tlID) {
		this.tlID = tlID;
	}

	public int getTlType() {
		return tlType;
	}

	public void setTlType(int tlType) {
		this.tlType = tlType;
	}

	public String getTlName() {
		return tlName;
	}

	public void setTlName(String tlName) {
		this.tlName = tlName;
	}

}
