package com.Action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String s1 = sdf.format(date);// 这里得到：26/03/1999 这个格式的日期
		sdf = new SimpleDateFormat("HH:mm");
		String s2 = sdf.format(date);// 这里得到的是 18:00 这个格式的时间
		// String time = s1 + " " + s2;
		String time = s1;
		return time;
	}
}