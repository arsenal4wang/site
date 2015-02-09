package com.Bean;

/**
 * 侧边栏LOGO
 * **/

public class Logo {
	int picID, sectionID, picOrder;
	String picLocation, picName, sectionName, href;

	public int getPicID() {
		return picID;
	}

	public void setPicID(int picID) {
		this.picID = picID;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public int getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(int picOrder) {
		this.picOrder = picOrder;
	}

	public String getPicLocation() {
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
