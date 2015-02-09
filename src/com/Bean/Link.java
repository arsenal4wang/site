package com.Bean;

public class Link {
	private String webName, webAddr;
	private int webID, visitTimes, linkOrder;

	public int getLinkOrder() {
		return linkOrder;
	}

	public void setLinkOrder(int linkOrder) {
		this.linkOrder = linkOrder;
	}

	public int getVisitTimes() {
		return visitTimes;
	}

	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getWebAddr() {
		return webAddr;
	}

	public void setWebAddr(String webAddr) {
		this.webAddr = webAddr;
	}

	public int getWebID() {
		return webID;
	}

	public void setWebID(int webID) {
		this.webID = webID;
	}

}
