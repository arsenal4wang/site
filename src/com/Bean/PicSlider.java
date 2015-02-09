package com.Bean;

public class PicSlider {

	int newsID, picID,picOrder;
	String picLocation,isChecked, picName, href, newsTitle;
	
	public int getPicOrder() {
		return picOrder;
	}

	public void setPicOrder(int picOrder) {
		this.picOrder = picOrder;
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public int getPicID() {
		return picID;
	}

	public void setPicID(int picID) {
		this.picID = picID;
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

}
