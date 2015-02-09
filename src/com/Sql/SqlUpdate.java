package com.Sql;

public class SqlUpdate {

	/**
	 * 更新链接
	 * 
	 * **/
	public static void updateLink(int webID, String webName, String webAddr,
			int linkOrder) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String u = "update link set webName='" + webName + "',webAddr='"
					+ webAddr + "',linkOrder=" + linkOrder + " where webID="
					+ webID;
	//		System.out.println(u);
			db.update(u);
			db.closeAll();
		}
	}

	/**
	 * 更新新闻
	 * 
	 * **/
	public static void updateNews(String author, String isTop,
			String newsContent, String newsTitle, String secFirstName,
			String secSecName, int secFirstID, int secSecID, int newsID,
			String time) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String u = "update news set modAuthor='" + author + "',isTop='"
					+ isTop + "',newsContent='" + newsContent + "',newsTitle='"
					+ newsTitle + "',secFirstName='" + secFirstName
					+ "',secSecName='" + secSecName + "',secFirstID="
					+ secFirstID + ",secSecID=" + secSecID + ",modDate='"
					+ time

					+ "'where newsID=" + newsID;
			// System.out.println(u);
			db.update(u);
			db.closeAll();
		}
	}

	/**
	 * 第1个String是修改的内容，第2个是要修改的凭据，即ID
	 * 
	 * **/
	public static void change_status(String lie, String content, int id) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update news set " + lie + "='" + content
					+ "' where newsID  =" + id;
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	/**
	 * 
	 * 修改轮播图片里的isChecked
	 * 
	 * **/
	public static void changePicstatus(String lie, String content, int id) {
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update picslider set " + lie + "='" + content
					+ "' where newsID  =" + id;
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	// 更新导航
	public static void updateSection(int secID, int secIDforSub, int navOrder,
			int conOrder, String secName, String showUL, String secLocate,
			String subNavName, String isNav, String isContent, int type) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = null;
			if (type == 1) {
				sql = "update section set secName='" + secName + "',navOrder ="
						+ navOrder + ",conOrder =" + conOrder + ",secLocate ='"
						+ secLocate + "',isNav ='" + isNav + "',isContent ='"
						+ isContent + "' where secID=" + secID;
			} else {

				/**
				 * SqlUpdate.updateSection(getSecID(), getSecIDforSub(),
				 * getNavOrder(), getConOrder(), getSecName(),getShowUL(),
				 * getSecLocate(), getSubNavName(), "Y", getIsContent(), 2);
				 * **/
				sql = "update section set secName='" + secName
						+ "',secIDforSub =" + secIDforSub + ",navOrder ="
						+ navOrder + ",conOrder =" + conOrder + ",secLocate ='"
						+ secLocate + "',subNavName ='" + subNavName
						+ "',isContent ='" + isContent + "',showUL ='" + showUL
						+ "' where secID=" + secID;
			}
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	public static void updateSecSec(int secID, int firstID, int orders,
			String secName, String firstName) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update secondSec set  secName='" + secName
					+ "',firstID =" + firstID + ",firstName ='" + firstName
					+ "',orders =" + orders + " where secID=" + secID;
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	public static void updateFirstSec(int firstID, String firstSectionName,
			String isNav, String isContent, String secLocate, int orders) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update firstSec set  firstSectionName='"
					+ firstSectionName + "',isNav ='" + isNav
					+ "',isContent ='" + isContent + "',secLocate ='"
					+ secLocate + "',orders =" + orders + " where firstID="
					+ firstID;
			db.update(sql);
			db.closeAll();
		}
	}

	/**
	 * 用于简单的一列值更新
	 * 
	 * @param table
	 *            表名
	 * @param lieID
	 *            一般都是根据ID去更新
	 * @param id
	 *            需要更新的ID
	 * @param lie2
	 *            被更新的列
	 * @param content
	 *            最新的内容
	 * 
	 * **/
	public static void update(String table, String lieID, int id, String lie2,
			String content) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update " + table + " set  " + lie2 + "='" + content
					+ "' where " + lieID + "=" + id;
		//	System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void updateTL(int tlID, String tlName, int tlType, int tlOrder) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update teacherLeader set  tlName ='" + tlName
					+ "',tlType=" + tlType + ",tlOrder=" + tlOrder
					+ " where  tlID =" + tlID;
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}

	}

	public static void updateLeaTea(String table, int teaLeaID,
			String teaLeaName, String teaLeaProfile, String tlName, int tlID) {
		// TODO Auto-generated method stub

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update " + table + " set tlID  =" + tlID
					+ ",teaLeaName='" + teaLeaName + "',teaLeaProfile='"
					+ teaLeaProfile + "',tlName='" + tlName
					+ "' where  teaLeaID =" + teaLeaID;
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}
}
