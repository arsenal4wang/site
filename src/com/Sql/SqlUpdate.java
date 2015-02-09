package com.Sql;

import java.util.List;

public class SqlUpdate {

	public static void updateSecSec(int secID, int firstID, int orders,
			String secName, String firstName) {

		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String sql = "update secondSec set  secName='" + secName
					+ "',firstID =" + firstID + ",firstName ='" + firstName
					+ "',orders =" + orders + " where secID=" + secID;
		//	System.out.println(sql);
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
			// System.out.println(sql);
			db.update(sql);
			db.closeAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
