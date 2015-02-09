package com.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.Section;
import com.Sql.SqlAdd;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

public class SectionActionN extends ActionSupport {

	/**
	 * public String addLOGO() {
	 * 
	 * SqlAdd.addSecFirstNew("N", "N", "1", "N", getNavOrder(), 0, getSecName(),
	 * "center", getSubNavName(), getSecIDforSub(), 2); //
	 * System.out.println(getPicLocation()); int sectionID =
	 * SqlQueryMax.query_max("section", "secID");
	 * SqlAdd.addLogo(getPicLocation(), sectionID, getSubNavName(),
	 * getSecIDforSub(), getSecName()); return SUCCESS; }
	 * 
	 * // public String getSecionCenterList() { listSection =
	 * SqlQuery.getSectionList(2); return SUCCESS; }
	 **/
	// 添加第一模块
	public String addSection() {
		// System.out.println(getSecName());
		SqlAdd.addSecFirstNew(getIsNav(), "Y", "1", getIsContent(),
				getNavOrder(), getConOrder(), getSecName(), getSecLocate(),
				getSubNavName(), -1, 1);
		return SUCCESS;
	}

	// 添加二级模块
	public String addsubSection() {
		SqlAdd.addSecFirstNew("Y", "N", getShowUL(), getIsContent(),
				getNavOrder(), getConOrder(), getSecName(), getSecLocate(),
				getSubNavName(), getSecIDforSub(), 2);
		return SUCCESS;
	}

	// 得到第一模块列表
	public String getSecionList() {
		listSection = SqlQuery.getSectionList(1);
		return SUCCESS;
	}

	// 删除模块
	public String delSection() {
		if (getIsFirst().equals("Y")) {

			List<Integer> list_news = new ArrayList<Integer>();// 新闻列表 用来删除
			list_news = SqlQuery.getNewsDelete("secFirstID", getSecID());
			for (int i = 0; i < list_news.size(); i++) {
				SqlDelete.delete("picslider", "newsID", list_news.get(i));// 新闻下的图片
				SqlDelete.delete("fileinnews", "newsID", list_news.get(i));// 新闻下的文件
			}
			SqlDelete.delete("news", "secFirstID", getSecID());// 第一版块下的新闻

			// System.out.println(list_news.size());
			// System.out.println("删除第一");
			SqlDelete.delete("section", "secID", getSecID());
			SqlDelete.delete("section", "secIDforSub", getSecID());// 第一版块下的第二版块
		} else {
			// System.out.println("删除第二");
			List<Integer> list_news = new ArrayList<Integer>();// 新闻列表 用来删除
			list_news = SqlQuery.getNewsDelete("secSecID", getSecID());
			for (int i = 0; i < list_news.size(); i++) {
				SqlDelete.delete("picslider", "newsID", list_news.get(i));// 新闻下的图片
				SqlDelete.delete("fileinnews", "newsID", list_news.get(i));// 新闻下的文件
			}
			// System.out.println(list_news.size());
			SqlDelete.delete("section", "secID", getSecID());
		}
		return SUCCESS;
	}

	// 得到所有导航列表
	public String getSecionNavList() {
		listSection = SqlQuery.getSectionList(1);
		listSubSection = SqlQuery.getSubSectionList();
		// System.out.println(listSubSection.size());
		return SUCCESS;
	}

	// 修改
	public String modSection() {
		if (getIsFirst().equals("Y")) {
			secName = getSectionNameMod();
			return "is";
		} else {
			listSection = SqlQuery.getSectionList(1);
			subNavName = getSubNavNameMod();
			secName = getSectionNameMod();
			secIDforSub = getSecIDforSub();
			// System.out.println("secName" + secName);
			// System.out.println("subNavName" + subNavName);
			return "not";
		}
	}

	// 更新
	public String updateSection() {
		// System.out.println(getIsFirst());
		if (getIsFirst().equals("Y")) {
			SqlUpdate.updateSection(getSecID(), 0, getNavOrder(),
					getConOrder(), getSecName(), "Y", getSecLocate(), "null",
					getIsNav(), getIsContent(), 1);
			SqlUpdate.update("section", "secIDforSub", getSecID(), "secName",
					getSecName());
			// 尚未修改新闻里
			int newsIDMod[] = SqlQuery.getnewsIDMod(1, getSecID());// 1代表第一导航
			for (int i = 0; i < newsIDMod.length; i++) {
			//	System.out.println(newsIDMod[i]);

				SqlUpdate.update("news", "newsID", newsIDMod[i], "secFirstName",
						getSecName());
			}
		} else {
			// System.out.println(getSecIDforSub());
			// System.out.println(getSecID());
			SqlUpdate.updateSection(getSecID(), getSecIDforSub(),
					getNavOrder(), getConOrder(), getSecName(), getShowUL(),
					getSecLocate(), getSubNavName(), "Y", getIsContent(), 2);
			

			int newsIDMod[] = SqlQuery.getnewsIDMod(2, getSecID());// 1代表第一导航
			for (int i = 0; i < newsIDMod.length; i++) {
			//	System.out.println(newsIDMod[i]);
				
				SqlUpdate.update("news", "newsID", newsIDMod[i], "secSecName",
						getSubNavName());
			}
		}
		return SUCCESS;
	}

	List<Section> listSection = new ArrayList<Section>();
	List<Section> listSubSection = new ArrayList<Section>();

	int secID, navOrder, conOrder, secIDforSub;
	String secName, secLocate, subNavName, isFirst, isNav, isContent,
			subNavNameMod, sectionNameMod, showUL;// showUL,点击二级模块时，是否以新闻列表形式出现，还是以简介（只一条消息）出现
	String picLocation;

	public String getPicLocation() {
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	public String getShowUL() {
		return showUL;
	}

	public void setShowUL(String showUL) {
		this.showUL = showUL;
	}

	public String getSectionNameMod() {
		return sectionNameMod;
	}

	public void setSectionNameMod(String sectionNameMod) {
		String temp = null;
		try {
			temp = new String(sectionNameMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sectionNameMod = temp;
		// this.sectionNameMod =sectionNameMod;
	}

	public String getSubNavNameMod() {
		return subNavNameMod;
	}

	public void setSubNavNameMod(String subNavNameMod) {
		String temp = null;
		try {
			temp = new String(subNavNameMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.subNavNameMod = temp;
		// this.subNavNameMod = subNavNameMod;
	}

	public List<Section> getListSubSection() {
		return listSubSection;
	}

	public void setListSubSection(List<Section> listSubSection) {
		this.listSubSection = listSubSection;
	}

	public int getSecIDforSub() {
		return secIDforSub;
	}

	public void setSecIDforSub(int secIDforSub) {
		this.secIDforSub = secIDforSub;
	}

	public List<Section> getListSection() {
		return listSection;
	}

	public void setListSection(List<Section> listSection) {
		this.listSection = listSection;
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
