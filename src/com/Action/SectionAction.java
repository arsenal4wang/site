package com.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.SecFirst;
import com.Bean.SecSec;
import com.Sql.SqlAdd;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

public class SectionAction extends ActionSupport {

	
	
	
	/**OLD**/
	String firstSectionName, firstSectionNameMod, isNav, isContent, secLocate;
	int orders;

	List<SecFirst> listFirst = new ArrayList<SecFirst>();
	List<SecSec> listSec = new ArrayList<SecSec>();

	int firstID, secID;// 用于添加第二模块。其中orders firstSectionName isContent secLocate
						// 共用
	String secondSecName, secondSecNameMod;

	public String getSecondSecName() {
		return secondSecName;
	}

	public void setSecondSecName(String secondSecName) {
		this.secondSecName = secondSecName;
	}

	public String getSecondSecNameMod() {
		return secondSecNameMod;
	}

	public void setSecondSecNameMod(String secondSecNameMod) {
		String temp = null;
		try {
			temp = new String(secondSecNameMod.getBytes("iso-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.secondSecNameMod = temp;
	}

	public int getSecID() {
		return secID;
	}

	public void setSecID(int secID) {
		this.secID = secID;
	}

	public String getFirstSectionNameMod() {
		return firstSectionNameMod;
	}

	public void setFirstSectionNameMod(String firstSectionNameMod) {
		String temp = null;
		try {
			temp = new String(firstSectionNameMod.getBytes("iso-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.firstSectionNameMod = temp;
	}

	public List<SecSec> getListSec() {
		return listSec;
	}

	public void setListSec(List<SecSec> listSec) {
		this.listSec = listSec;
	}

	public int getFirstID() {
		return firstID;
	}

	public void setFirstID(int firstID) {
		this.firstID = firstID;
	}

	public List<SecFirst> getListFirst() {
		return listFirst;
	}

	public void setListFirst(List<SecFirst> listFirst) {
		this.listFirst = listFirst;
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

	public String getSecLocate() {
		return secLocate;
	}

	public void setSecLocate(String secLocate) {
		this.secLocate = secLocate;
	}

	public String getFirstSectionName() {
		return firstSectionName;
	}

	public void setFirstSectionName(String firstSectionName) {
		this.firstSectionName = firstSectionName;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String addFirstSec() {

		SqlAdd.addSecFirst(getIsNav(), getIsContent(), getFirstSectionName(),
				getSecLocate(), getOrders());
		return SUCCESS;
	}

	// 得到第一模块列表
	public String getFirstSecList() {
		listFirst = SqlQuery.getFirstSecList(0);
		return SUCCESS;
	}

	// 添加第二模块
	public String addSecSec() {
		SqlAdd.addSecSec(getFirstID(), getOrders(), getSecondSecName(),
				getFirstSectionName());

		return SUCCESS;
	}

	// 得到第一、第二模块列表
	public String getSecList() {
		listFirst = SqlQuery.getFirstSecList(1);
		listSec = SqlQuery.getSecSecList();
		return SUCCESS;
	}

	// 删除第一导航模块
	public String delFirstSec() {
		SqlDelete.delete("secondSec", "firstID", getFirstID());
		SqlDelete.delete("firstSec", "firstID", getFirstID());
		SqlDelete.delete("news", "secFirstID", getFirstID());
		return SUCCESS;
	}

	// 删除第一导航模块
	public String delSecSec() {
		SqlDelete.delete("secondSec", "secID", getSecID());
		SqlDelete.delete("news", "secSecID", getSecID());
		return SUCCESS;
	}

	// 修改第一分类
	public String modFirstSec() {
		orders = getOrders();
		isNav = getIsNav();
		isContent = getIsContent();
		secLocate = getSecLocate();
		firstSectionNameMod = getFirstSectionNameMod();
		firstID = getFirstID();
		return SUCCESS;
	}

	// 更新第一分类
	public String updateFirstCat() {
		// System.out.println(getFirstID());
		SqlUpdate.updateFirstSec(getFirstID(), getFirstSectionName(),
				getIsNav(), getIsContent(), getSecLocate(), getOrders());
		return SUCCESS;
	}

	// 修改第二模块
	public String modSecSec() {
	//	System.out.println(getFirstSectionNameMod());
		firstSectionNameMod = getFirstSectionNameMod();
		firstID = getFirstID();
		orders = getOrders();
		listFirst = SqlQuery.getFirstSecList(0);
		secondSecNameMod = getSecondSecNameMod();
		secID = getSecID();
		return SUCCESS;
	}

	// 更新第二模块
	public String updateSecSec() {
		// System.out.println(getSecondSecName());
		SqlUpdate.updateSecSec(getSecID(), getFirstID(), getOrders(),
				getSecondSecName(), getFirstSectionName());
		return SUCCESS;
	}

}
