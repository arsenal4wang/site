package com.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Bean.Statistic;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

public class StatisticAction extends ActionSupport {

	private int visitID;
	private long visitTimes;
	List<Statistic> st = new ArrayList<Statistic>();
	Statistic statistic = new Statistic();

	private Map<String, Object> dataMap;

	/**
	 * 构造方法
	 */
	public StatisticAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public List<Statistic> getSt() {
		return st;
	}

	public void setSt(List<Statistic> st) {
		this.st = st;
	}

	public int getVisitID() {
		return visitID;
	}

	public void setVisitID(int visitID) {
		this.visitID = visitID;
	}

	public long getVisitTimes() {
		return visitTimes;
	}

	public void setVisitTimes(long visitTimes) {
		this.visitTimes = visitTimes;
	}

	public String getStastic() {
		visitTimes = Long.valueOf(SqlQuery.get_target("statistic",
				"visitTimes", "visitID", String.valueOf(1)));
		statistic.setVisitTimes(visitTimes);
		// System.out.println("访问次数" + visitTimes);
		st.add(statistic);
		dataMap.clear();
		dataMap.put("statistic", st);
		dataMap.put("success", true);
		return SUCCESS;
	}
}
