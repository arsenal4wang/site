package com.Action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Bean.FileInNews;
import com.Bean.GdPic;
import com.Bean.Link;
import com.Bean.News;
import com.Bean.PicSlider;
import com.Bean.Section;
import com.Bean.TeaLea;
import com.Bean.TeacherLeader;
import com.Sql.SqlCount;
import com.Sql.SqlQuery;
import com.Sql.SqlQueryMax;
import com.Sql.SqlUpdate;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	int navID, secID, isNav, isSecID;// 第一导航ID,第二导航ID,isNav判断传过来的数据是一级导航还是二级导航,isSecID来判断哪个ID的二级导航为active（sub.jsp）
	int allNum, pageAll, page = 0;// 用于分页
	String firstName, secondName;
	int newsID;
	String keyWords, keyWordsPage;
	int source;
	int secIDforSub;// section表中
	News hw = new News();
	List<Section> list2 = new ArrayList<Section>();
	List<Section> list1 = new ArrayList<Section>();

	List<Section> listSection = new ArrayList<Section>();
	List<Section> listSubSection = new ArrayList<Section>();
	List<Section> listSubByfirst = new ArrayList<Section>();
	List<Section> listRight = new ArrayList<Section>();

	List<News> listNews = new ArrayList<News>();
	List<News> listNewsTop = new ArrayList<News>();
	List<News> listNewsNew = new ArrayList<News>();// 最新消息
	List<News> listNews_temp = new ArrayList<News>();
	List<News> listNewsTop_temp = new ArrayList<News>();
	List<Link> linkList = new ArrayList<Link>();

	List<TeaLea> teaLea_list = new ArrayList<TeaLea>();

	TeaLea tlInfo = new TeaLea();
	int isTL, teaLeaID, tlID;// teacher or leader

	// 滚动图片
	List<GdPic> gdpic = new ArrayList<GdPic>();

	// 院长寄语
	String shortNews;

	Section s2 = new Section();// 显示在内容版块中的简介

	public Section getS2() {
		return s2;
	}

	public void setS2(Section s2) {
		this.s2 = s2;
	}

	public String getShortNews() {
		return shortNews;
	}

	public void setShortNews(String shortNews) {
		this.shortNews = shortNews;
	}

	public List<Section> getList2() {
		return list2;
	}

	public void setList2(List<Section> list2) {
		this.list2 = list2;
	}

	public List<Section> getList1() {
		return list1;
	}

	public void setList1(List<Section> list1) {
		this.list1 = list1;
	}

	public List<GdPic> getGdpic() {
		return gdpic;
	}

	public void setGdpic(List<GdPic> gdpic) {
		this.gdpic = gdpic;
	}

	public List<Section> getListRight() {
		return listRight;
	}

	public void setListRight(List<Section> listRight) {
		this.listRight = listRight;
	}

	public int getTlID() {
		return tlID;
	}

	public void setTlID(int tlID) {
		this.tlID = tlID;
	}

	public int getTeaLeaID() {
		return teaLeaID;
	}

	public void setTeaLeaID(int teaLeaID) {
		this.teaLeaID = teaLeaID;
	}

	public int getIsTL() {
		return isTL;
	}

	public void setIsTL(int isTL) {
		this.isTL = isTL;
	}

	public TeaLea getTlInfo() {
		return tlInfo;
	}

	public void setTlInfo(TeaLea tlInfo) {
		this.tlInfo = tlInfo;
	}

	public List<TeaLea> getTeaLea_list() {
		return teaLea_list;
	}

	public void setTeaLea_list(List<TeaLea> teaLea_list) {
		this.teaLea_list = teaLea_list;
	}

	// 读取简介
	String showUL;
	// 轮播图片
	int picID;// newsID
	String picLocation, picName, href, newsTitle;

	List<PicSlider> picSliderlist = new ArrayList<PicSlider>();
	List<FileInNews> fin = new ArrayList<FileInNews>();

	// 教师，领导
	List<TeacherLeader> tlList = new ArrayList<TeacherLeader>();

	public List<TeacherLeader> getTlList() {
		return tlList;
	}

	public void setTlList(List<TeacherLeader> tlList) {
		this.tlList = tlList;
	}

	public String getShowUL() {
		return showUL;
	}

	public void setShowUL(String showUL) {
		this.showUL = showUL;
	}

	public List<FileInNews> getFin() {
		return fin;
	}

	public void setFin(List<FileInNews> fin) {
		this.fin = fin;
	}

	public List<PicSlider> getPicSliderlist() {
		return picSliderlist;
	}

	public void setPicSliderlist(List<PicSlider> picSliderlist) {
		this.picSliderlist = picSliderlist;
	}

	public int getPicID() {
		return picID;
	}

	public void setPicID(int picID) {
		this.picID = picID;
	}

	public String getPicLocation() {
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public List<News> getListNewsTop() {
		return listNewsTop;
	}

	public void setListNewsTop(List<News> listNewsTop) {
		this.listNewsTop = listNewsTop;
	}

	public int getSecIDforSub() {
		return secIDforSub;
	}

	public void setSecIDforSub(int secIDforSub) {
		this.secIDforSub = secIDforSub;
	}

	public List<Section> getListSubByfirst() {
		return listSubByfirst;
	}

	public void setListSubByfirst(List<Section> listSubByfirst) {
		this.listSubByfirst = listSubByfirst;
	}

	public List<Section> getListSection() {
		return listSection;
	}

	public void setListSection(List<Section> listSection) {
		this.listSection = listSection;
	}

	public List<Section> getListSubSection() {
		return listSubSection;
	}

	public void setListSubSection(List<Section> listSubSection) {
		this.listSubSection = listSubSection;
	}

	public List<News> getListNewsNew() {
		return listNewsNew;
	}

	public void setListNewsNew(List<News> listNewsNew) {
		this.listNewsNew = listNewsNew;
	}

	public List<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}

	public int getIsSecID() {
		return isSecID;
	}

	public void setIsSecID(int isSecID) {
		this.isSecID = isSecID;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getKeyWordsPage() {
		return keyWordsPage;
	}

	public void setKeyWordsPage(String keyWordsPage) {
		String temp = null;
		try {
			temp = new String(keyWordsPage.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.keyWordsPage = temp;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public News getHw() {
		return hw;
	}

	public void setHw(News hw) {
		this.hw = hw;
	}

	public int getNewsID() {
		return newsID;
	}

	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}

	public int getIsNav() {
		return isNav;
	}

	public void setIsNav(int isNav) {
		this.isNav = isNav;
	}

	public int getPageAll() {
		return pageAll;
	}

	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
	}

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSecID() {
		return secID;
	}

	public void setSecID(int secID) {
		this.secID = secID;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getNavID() {
		return navID;
	}

	public void setNavID(int navID) {
		this.navID = navID;
	}

	public List<News> getListNews() {
		return listNews;
	}

	public void setListNews(List<News> listNews) {
		this.listNews = listNews;
	}

	// 显示首页导航，显示首页新闻
	public String getIndex() throws ParseException {
		// listFirst = SqlQuery.getFirstSecList();
		// listSec = SqlQuery.getSecSecList();

		/**
		 * 
		 * 加滚动图片之前
		 * 
		 * listright = SqlQuery.getContentSectionList("right"); listleft =
		 * SqlQuery.getContentSectionList("left");
		 * 
		 * 
		 * **/

		list1 = SqlQuery.getSection(1, "left");// 第1行 左
		list1.addAll(SqlQuery.getSection(1, "right"));// 加上第1行右

		list2 = SqlQuery.getSection(2, "left");// 第1行 左
		list2.addAll(SqlQuery.getSection(2, "right"));// 加上第1行右
		// for (int i = 0; i < list2.size(); i++) {
		// Section s = new Section();
		// s = list2.get(i);
		// // System.out.println(s.getContentName());
		// }
		// 轮播列表
		picSliderlist = SqlQuery.getPicSliderList();

		listSection = SqlQuery.getSectionList(0);
		listRight = SqlQuery.getSectionList(2);// 右侧边栏
		listSubSection = SqlQuery.getSubSectionList();

		List<Section> list = new ArrayList<Section>();
		list = SqlQuery.getisContentSection();
		Section s = new Section();
		// 循环获取要显示的新闻列表
		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			if (s.getIsFirst().equals("Y")) {
				// 一级导航中新闻
				listNews_temp = SqlQuery.getNewsList(s.getSecID(), 1);
			} else {
				// 二级导航中新闻
				listNews_temp = SqlQuery.getNewsList(s.getSecID(), 2);
			}
			listNews.addAll(listNews_temp);
		}

		s2 = SqlQuery.getSection2();
		// System.out.println(s2.getContentName());
		// System.out.println(s2.getIsFirst());
		shortNews = SqlQuery.getShortNews(s2.getSecID(), s2.getIsFirst());// 得到这个SECTION的新闻，只选取少部分
	//	System.out.println(shortNews);
		gdpic = SqlQuery.getGdAddList();// 滚动图片
		listNewsNew = SqlQuery.getLatestNewsList();
		linkList = SqlQuery.getLinkList();
		return SUCCESS;
	}

	// 进入二级模块后显示新闻列表
	public String newsList() {
		// 生成导航Top.jsp

		listSection = SqlQuery.getSectionList(0);
		listSubSection = SqlQuery.getSubSectionList();

		// 得到该ID对应的导航名，在Sub.jsp中显示
		firstName = SqlQuery.get_target("section", "secName", "secID",
				String.valueOf(getNavID()));

		// 查询该ID下所有的二级导航，用于左侧边栏显示
		listSubByfirst = SqlQuery.getSubSectionListByFirstID(getNavID());
		// isNav=1,从一级导航过来的
		if (getIsNav() == 1) {
			if (page == 0)
				page = 1;
			// 得到该二级ID下一共多少新闻
			allNum = SqlQuery.getNewsListNav(1, getNavID());
			// 页数
			pageAll = judge(allNum, 20);

			int topNewsNum = SqlQuery.queryTargetNum("news", "isTop", "1",
					"secFirstID", String.valueOf(getNavID()));

			// System.out.println(getPage());
			if (page == 1) {
				listNewsTop = SqlQuery.getNewsListSub(getNavID(), 3, 0, 20);
				listNews = SqlQuery.getNewsListSub(getNavID(), 1,
						(getPage() - 1) * 20, 20 - topNewsNum);
			} else {
				listNews = SqlQuery.getNewsListSub(getNavID(), 1,
						(getPage() - 1) * 20 - topNewsNum, 20 - topNewsNum);

			}
			listNewsTop.addAll(listNews);
			isNav = 1;
		} else {
			isSecID = getSecID();
			if (page == 0)
				page = 1;
			secondName = SqlQuery.get_target("section", "subNavName", "secID",
					String.valueOf(getSecID()));
			allNum = SqlQuery.getNewsListNav(2, getSecID());
			pageAll = judge(allNum, 20);

			int topNewsNum = SqlQuery.queryTargetNum("news", "isTop", "1",
					"secSecID", String.valueOf(getSecID()));

			// System.out.println("topNewsNum  "+topNewsNum);
			if (getPage() > 1) {
				listNews = SqlQuery.getNewsListSub(getSecID(), 2,
						(getPage() - 1) * 20 - topNewsNum, 20);
			} else {
				listNewsTop = SqlQuery.getNewsListSub(getSecID(), 4, 0, 20);

				listNews = SqlQuery.getNewsListSub(getSecID(), 2,
						(getPage() - 1) * 20, 20 - topNewsNum);
			}
			listNewsTop.addAll(listNews);
			isNav = 0;
		}
		return SUCCESS;
	}

	// 读取新闻
	public String readNews() {
		// 生成导航Top.jsp

		int newsIDtemp;
		listSection = SqlQuery.getSectionList(0);
		listSubSection = SqlQuery.getSubSectionList();

		// 得到该ID对应的导航名，在Sub.jsp中显示
		firstName = SqlQuery.get_target("section", "secName", "secID",
				String.valueOf(getNavID()));
		// 查询该ID下所有的二级导航，用于左侧边栏显示
		listSubByfirst = SqlQuery.getSubSectionListByFirstID(getNavID());
		secondName = SqlQuery.get_target("section", "subNavName", "secID",
				String.valueOf(getSecID()));
		isSecID = getSecID();
		if (getShowUL() == null) {
			showUL = "1";
		} else
			showUL = "2";
		if (showUL.equals("2")) {
			hw = SqlQuery.getIntroduction(getSecID());
			newsIDtemp=hw.getNewsID();
		} else {
			hw = SqlQuery.getNews(getNewsID());
			newsIDtemp=hw.getNewsID();
		}

		fin = SqlQuery.getFileInNewsList(getNewsID());// fileInNews
		// System.out.println("多少个附件" + fin.size());
		// 阅读次数+1
		int readTime = hw.getReadTimes();
		readTime++;
		SqlUpdate.update("news", "newsID", newsIDtemp, "readTimes",
				String.valueOf(readTime));
		return SUCCESS;
	}

	// 分页函数
	public int judge(int end_num, int pageEachNum) {
		int page_num;
		if (end_num % pageEachNum == 0) {
			page_num = end_num / pageEachNum;
		} else {
			page_num = end_num / pageEachNum + 1;
		}
		return page_num;
	}

	public String newsSearch() {
		// 生成导航Top.jsp
		listSection = SqlQuery.getSectionList(0);
		listSubSection = SqlQuery.getSubSectionList();

		if (getSecID() == 0) {
			firstName = "全局搜索";
		} else {
			firstName = SqlQuery.get_target("section", "secName",
					"secIDforSub", String.valueOf(getSecID()));
		}

		if (page >= 1) {
			keyWords = getKeyWordsPage();
		}
		if (page == 0) {
			listNews = SqlQuery.getNewsListBySearch(getPage() * 10, 10,
					getKeyWords(), getSecID());
			page = 1;
		} else {
			listNews = SqlQuery.getNewsListBySearch((getPage() - 1) * 10, 10,
					keyWords, getSecID());
		}
		allNum = SqlQuery.getNewsListBySearch(getKeyWords(), getSecID());
		pageAll = judge(allNum, 10);
		return SUCCESS;
	}

	public String readNewsBySlider() {
		System.out.println(getNewsID());
		System.out.println("navID" + navID);
		System.out.println("secID" + secID);
		return SUCCESS;
	}

	public String getTL() {
		// 生成导航Top.jsp

		listSection = SqlQuery.getSectionList(0);
		listSubSection = SqlQuery.getSubSectionList();

		// 得到该ID对应的导航名，在Sub.jsp中显示
		firstName = SqlQuery.get_target("section", "secName", "secID",
				String.valueOf(getNavID()));
		// 查询该ID下所有的二级导航，用于左侧边栏显示
		listSubByfirst = SqlQuery.getSubSectionListByFirstID(getNavID());
		secondName = SqlQuery.get_target("section", "subNavName", "secID",
				String.valueOf(getSecID()));
		isSecID = getSecID();
		if (getShowUL().equals("3")) {
			teaLea_list = SqlQuery.getTeacher_LeaderList("teacher");// 教师详细列表
			tlList = SqlQuery.getTL(1);

		} else if (getShowUL().equals("4")) {
			teaLea_list = SqlQuery.getTeacher_LeaderList("leader");// 领导列表
			tlList = SqlQuery.getTL(2);
		}
		return SUCCESS;
	}

	public String getTLinfo() {
		// System.out.println("teaLeaID" + getTeaLeaID());
	//	System.out.println("tlID" + getIsTL());
		// 生成导航Top.jsp
		listSection = SqlQuery.getSectionList(0);
		listSubSection = SqlQuery.getSubSectionList();

		// 得到该ID对应的导航名，在Sub.jsp中显示
		firstName = SqlQuery.get_target("section", "secName", "secID",
				String.valueOf(getNavID()));
		// 查询该ID下所有的二级导航，用于左侧边栏显示
		listSubByfirst = SqlQuery.getSubSectionListByFirstID(getNavID());
		secondName = SqlQuery.get_target("section", "subNavName", "secID",
				String.valueOf(getSecID()));
		isSecID = getSecID();

		int tyType = Integer.valueOf(SqlQuery.get_target("teacherLeader",
				"tlType", "tlID", String.valueOf(getIsTL())));
		// 取得老师领导的信息
		tlInfo = SqlQuery.getTlInfo(tyType, getTeaLeaID());

		return SUCCESS;
	}
}
