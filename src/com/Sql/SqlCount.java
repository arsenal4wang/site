package com.Sql;

public class SqlCount {

	public static int countAll(String table) {

		int i = 0;
		SqlConnect db = new SqlConnect();
		if (db.createConnection()) {
			String count = "select count(1) from " + table;
			db.query(count);
			while (db.next()) {
				i = db.getIntValue(1);
			}
		}
		db.closeAll();
		return i;
	}
}
