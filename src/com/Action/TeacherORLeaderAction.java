package com.Action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.TeaLea;
import com.Sql.SqlAdd;
import com.Sql.SqlDelete;
import com.Sql.SqlQuery;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author FS
 * 
 */
public class TeacherORLeaderAction extends ActionSupport {
	/**
	 * 
	 */
	private int tlID, tlType;
	private String tlName, tlNameMod;
	int tlOrder;
	List<TeacherORLeaderAction> listTL = new ArrayList<TeacherORLeaderAction>();

	int addType;

	public int getTlOrder() {
		return tlOrder;
	}

	public void setTlOrder(int tlOrder) {
		this.tlOrder = tlOrder;
	}

	public int getAddType() {
		return addType;
	}

	public void setAddType(int addType) {
		this.addType = addType;
	}

	public String getTlNameMod() {
		return tlNameMod;
	}

	public void setTlNameMod(String tlNameMod) {
		String temp = null;
		try {
			temp = new String(tlNameMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		this.tlNameMod = temp;
	}

	public List<TeacherORLeaderAction> getListTL() {
		return listTL;
	}

	public void setListTL(List<TeacherORLeaderAction> listTL) {
		this.listTL = listTL;
	}

	public int getTlID() {
		return tlID;
	}

	public void setTlID(int tlID) {
		this.tlID = tlID;
	}

	public int getTlType() {
		return tlType;
	}

	public void setTlType(int tlType) {
		this.tlType = tlType;
	}

	public String getTlName() {
		return tlName;
	}

	public void setTlName(String tlName) {
		this.tlName = tlName;
	}

	public String torlAdd() {
		SqlAdd.tlAdd(getTlName(), getTlType(),getTlOrder());
		return SUCCESS;
	}

	public String getTLList() {
		listTL = SqlQuery.getTLList(0);
		return SUCCESS;
	}

	public String delTL() {
		SqlDelete.delete("teacherLeader", "tlID", getTlID());
		return SUCCESS;
	}

	public String modTL() {

		return SUCCESS;
	}

	public String tlUpdate() {
		// System.out.println("tlID" + getTlID());
		// System.out.println("getTlName" + getTlName());
		// System.out.println("getTlType" + getTlType());
		SqlUpdate.updateTL(getTlID(), getTlName(), getTlType(),getTlOrder());
		return SUCCESS;
	}

	public String goAdd() {
		String r = null;
		if (getAddType() == 1) {
			listTL = SqlQuery.getTLList(1);// 读取教师职位列表
			r = "teacher";
		} else if (getAddType() == 2) {
			listTL = SqlQuery.getTLList(2);// 读取领导职位列表
			r = "leader";
		}
		return r;
	}

	public String addTeacher() {
		SqlAdd.addLeader("teacher", getTlID(), getTlName(), getTeaLeaName(),
				getTeaLeaProfile());// 通过参数(表)不同，来复用。因为两个表设计完全一样
		return SUCCESS;
	}

	public String addLeader() {
		// System.out.println(getTeaLeaName());
		// System.out.println(getTeaLeaProfile());
		SqlAdd.addLeader("leader", getTlID(), getTlName(), getTeaLeaName(),
				getTeaLeaProfile());
		return SUCCESS;
	}

	public String getTeaLeaList() {
		teaLea_list2 = SqlQuery.getTeacher_LeaderList("teacher");
		teaLea_list = SqlQuery.getTeacher_LeaderList("leader");
		return SUCCESS;
	}

	public String delLeader() {
		// System.out.println("delLeader" + getTeaLeaID());
		SqlDelete.delete("leader", "teaLeaID", getTeaLeaID());
		return SUCCESS;
	}

	public String delTeacher() {
		// System.out.println(getTeaLeaID());
		SqlDelete.delete("teacher", "teaLeaID", getTeaLeaID());
		return SUCCESS;
	}

	public String modTeacher() {
		listTL = SqlQuery.getTLList(1);// 读取教师职位列表
		teaLeaProfile = SqlQuery.getTarget("teacher", "teaLeaprofile",
				"teaLeaID", String.valueOf(getTeaLeaID()));
		return SUCCESS;
	}

	public String modLeader() {
		listTL = SqlQuery.getTLList(2);// 读取领导职位列表
		// System.out.println(getTeaLeaProfileMod());
		teaLeaProfile = SqlQuery.getTarget("leader", "teaLeaprofile",
				"teaLeaID", String.valueOf(getTeaLeaID()));
		// System.out.println(teaLeaProfile);
		return SUCCESS;
	}

	public String addColleage() {
		System.out.println(getColleageName());
		// SqlAdd.addColleage(getColleageName());
		return SUCCESS;
	}

	public String updateLeader() {
		SqlUpdate.updateLeaTea("leader", getTeaLeaID(), getTeaLeaName(),
				getTeaLeaProfile(), getTlName(), getTlID());
		return SUCCESS;
	}

	public String updateTeacher() {
		SqlUpdate.updateLeaTea("teacher", getTeaLeaID(), getTeaLeaName(),
				getTeaLeaProfile(), getTlName(), getTlID());
		return SUCCESS;
	}

	int teaLeaID, teaLeaBelong;
	String teaLeaName, teaLeaProfile;
	List<TeaLea> teaLea_list = new ArrayList<TeaLea>();
	List<TeaLea> teaLea_list2 = new ArrayList<TeaLea>();

	String teaLeaNameMod, teaLeaProfileMod;

	public String getTeaLeaNameMod() {
		return teaLeaNameMod;
	}

	public void setTeaLeaNameMod(String teaLeaNameMod) {
		String temp = null;
		try {
			temp = new String(teaLeaNameMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.teaLeaNameMod = temp;
	}

	public String getTeaLeaProfileMod() {
		return teaLeaProfileMod;
	}

	public void setTeaLeaProfileMod(String teaLeaProfileMod) {
		String temp = null;
		try {
			temp = new String(teaLeaProfileMod.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.teaLeaProfileMod = temp;
	}

	public List<TeaLea> getTeaLea_list2() {
		return teaLea_list2;
	}

	public void setTeaLea_list2(List<TeaLea> teaLea_list2) {
		this.teaLea_list2 = teaLea_list2;
	}

	// 院系
	private String colleageName;
	private int colleageID;

	public String getColleageName() {
		return colleageName;
	}

	public void setColleageName(String colleageName) {
		this.colleageName = colleageName;
	}

	public int getColleageID() {
		return colleageID;
	}

	public void setColleageID(int colleageID) {
		this.colleageID = colleageID;
	}

	public List<TeaLea> getTeaLea_list() {
		return teaLea_list;
	}

	public void setTeaLea_list(List<TeaLea> s) {
		teaLea_list = s;
	}

	public int getTeaLeaID() {
		return teaLeaID;
	}

	public void setTeaLeaID(int teaLeaID) {
		this.teaLeaID = teaLeaID;
	}

	public int getTeaLeaBelong() {
		return teaLeaBelong;
	}

	public void setTeaLeaBelong(int teaLeaBelong) {
		this.teaLeaBelong = teaLeaBelong;
	}

	public String getTeaLeaName() {
		return teaLeaName;
	}

	public void setTeaLeaName(String teaLeaName) {
		this.teaLeaName = teaLeaName;
	}

	public String getTeaLeaProfile() {
		return teaLeaProfile;
	}

	public void setTeaLeaProfile(String teaLeaProfile) {
		this.teaLeaProfile = teaLeaProfile;
	}

}
