package com.Action;

import java.util.ArrayList;
import java.util.List;

import com.Bean.Link;
import com.Sql.SqlAdd;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {
	private String webName, webAddr;
	private int webID,linkOrder;

	List<Link> link_list = new ArrayList<Link>();

	
	public int getLinkOrder() {
		return linkOrder;
	}

	public void setLinkOrder(int linkOrder) {
		this.linkOrder = linkOrder;
	}

	public List<Link> getLink_list() {
		return link_list;
	}

	public void setLink_list(List<Link> link_list) {
		this.link_list = link_list;
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

	public String delLink() {

		// System.out.println(getWebID());
		SqlDelete.delete("link", "webID", getWebID());
		return SUCCESS;
	}

	public String addLink() {
		// System.out.println(getWebName());
		// System.out.println(getWebAddr());
		SqlAdd.addLink(getWebName(), getWebAddr(),getLinkOrder());
		return SUCCESS;
	}

	public String getLinkList() {
		link_list = SqlQuery.getLinkList();
		return SUCCESS;
	}

	public String modLink() {
		webName = SqlQuery.getTarget("link", "webName", "webID",
				String.valueOf(getWebID()));
		return SUCCESS;
	}

	public String updateLink() {
		SqlUpdate.updateLink(getWebID(), getWebName(), getWebAddr(),getLinkOrder());
		return SUCCESS;
	}
}
