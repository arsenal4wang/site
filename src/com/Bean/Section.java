package com.Bean;

public class Section {
	int secID, navOrder, conOrder, secIDforSub;
	String secName, secLocate, subNavName, isFirst, isNav, isContent, showUL,contentName;

	
	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getShowUL() {
		return showUL;
	}

	public void setShowUL(String showUL) {
		this.showUL = showUL;
	}

	public int getSecIDforSub() {
		return secIDforSub;
	}

	public void setSecIDforSub(int secIDforSub) {
		this.secIDforSub = secIDforSub;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getIsNav() {
		return isNav;
	}

	public void setIsNav(String isNav) {
		this.isNav = isNav;
	}

	public String getIsContent() {
		return isContent;
	}

	public void setIsContent(String isContent) {
		this.isContent = isContent;
	}

	public String getSubNavName() {
		return subNavName;
	}

	public void setSubNavName(String subNavName) {
		this.subNavName = subNavName;
	}

	public int getSecID() {
		return secID;
	}

	public void setSecID(int secID) {
		this.secID = secID;
	}

	public int getNavOrder() {
		return navOrder;
	}

	public void setNavOrder(int navOrder) {
		this.navOrder = navOrder;
	}

	public int getConOrder() {
		return conOrder;
	}

	public void setConOrder(int conOrder) {
		this.conOrder = conOrder;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getSecLocate() {
		return secLocate;
	}

	public void setSecLocate(String secLocate) {
		this.secLocate = secLocate;
	}

}
