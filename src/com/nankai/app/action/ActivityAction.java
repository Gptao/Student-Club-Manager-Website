
package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.nankai.app.domain.Activity;
import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;
import com.nankai.app.domain.Organization;
import com.nankai.app.service.ActService;
import com.nankai.app.service.CollectionService;
import com.nankai.app.service.OrgService;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.OrgPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActivityAction extends ActionSupport implements ModelDriven<Activity>,ServletResponseAware,ServletRequestAware{
	private Activity act = new Activity();
	private ActService actService;
	private OrgService orgService;
	private CollectionService collectionService;
	
	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	//给安卓传数据用到的
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	//分页需要使用的参数
	private int currentPage=1;
	private int pageSize=6;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setActService(ActService actService) {
		this.actService = actService;
	}
	//向数据库Activity表添加记录
	public String add()
	{
		actService.add(act);
		return SUCCESS;
	}
	//显示数据库中所有记录---分页
	public String showAll()
	{
		ActPage actPage = actService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().getSession().setAttribute("actPage", actPage);
		return SUCCESS;
	}
	//显示数据库中所有记录---不分页
	public String showAllForList()
	{
		//先从数据库读出所有活动记录，存在list
		List<Activity> actList = actService.findAllForList();

		//设置编码格式
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//将活动的列表转成json
		//首先
		List<HashMap<String, Object>> map_List = new ArrayList<HashMap<String, Object>>();
             
        
        System.out.println("---"+actList.size());
        for(Activity act :actList)    
        {    
            System.out.println(act.getActivityName());
            HashMap<String,Object> map = new HashMap();

            map.put("ActivityId", act.getActivityId());
            map.put("ActivityName",act.getActivityName());
            map.put("ActivityIntroduction", act.getActivityIntroduction());
            map.put("ActivityLocatio", act.getActivityLocation());
            map.put("ActivityContent", act.getActivityContent());
            map.put("ActivityPicture", act.getActivityPicture());
            map.put("ActivityOrganization", act.getOrganization().getOrganizationName());
            map_List.add(map);
        }
        
   	 	String result = JSON.toJSONString(map_List);
   	 	System.out.println("JSON-----"+result);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String showAllCollection()
	{
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String userId = request.getParameter("userId");
		System.out.println(userId+"------userId");
		//找到这个人的所有收藏记录
		List<Collection> list = collectionService.findCollectionByUser(Integer.parseInt(userId));
		//用一个列表，存所有收藏的活动
		List<Activity> actList = new ArrayList<Activity>();
		int actId;
		for(int i = 0; i < list.size(); i++)
		{
			actId = list.get(i).getActivityId();
			actList.add(actService.findMemberByID(actId));
		}
		
		//将活动的列表转成json
		//首先
		List<HashMap<String, Object>> map_List = new ArrayList<HashMap<String, Object>>();
             
        
        System.out.println("收藏数量---"+actList.size());
        for(Activity act :actList)    
        {    
            System.out.println(act.getActivityName());
            HashMap<String,Object> map = new HashMap();

            map.put("ActivityId", act.getActivityId());
            map.put("ActivityName",act.getActivityName());
            map.put("ActivityIntroduction", act.getActivityIntroduction());
            map.put("ActivityLocatio", act.getActivityLocation());
            map.put("ActivityContent", act.getActivityContent());
            map.put("ActivityPicture", act.getActivityPicture());
            map.put("ActivityOrganization", act.getOrganization().getOrganizationName());
            map_List.add(map);
        }
        
   	 	String result = JSON.toJSONString(map_List);
   	 	System.out.println("收藏JSON-----"+result);

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(result);
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String showAllForManager()
	{
		ActPage actPage = actService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("actPage", actPage);
		return "manager";
	}
	//删除数据库中记录
	public String delete(){
		Activity activity=actService.findMemberByID(act.getActivityId());
		actService.delete(activity);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("activity", "delete");
	    return "manager";
	}
	//更新数据库记录
	public String update(){
    	actService.update(act);
    	return "manager";
    }
	//根据ID查询，返回跳转到修改页面
	public String findActivityById()
	{
		Activity activity = actService.findMemberByID(act.getActivityId());
		ServletActionContext.getRequest().setAttribute("activity", activity);
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("Activity", "Act_update");
		return "update";
	}
	//根据ID查询，返回值使action调到活动详情页面
	public String findById()
	{
		Activity activity = actService.findMemberByID(act.getActivityId());
		ServletActionContext.getRequest().getSession().setAttribute("activity", activity);
		return "content";
	}
	@Override
	public Activity getModel() {
		return act;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String addActivityForAndroid()
	{
		
		
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ActivityName = request.getParameter("ActivityName");
		String ActivityContent = request.getParameter("ActivityContent");
		String ActivityOrganization = request.getParameter("ActivityOrganization");
		String ActivityTime = request.getParameter("ActivityTime");
		String ActivityIntroduction = request.getParameter("ActivityIntroduction");
		String ActivityLocation = request.getParameter("ActivityLocation");
		String ActivityCover = request.getParameter("ActivityCover");
		
		
		System.out.println(ActivityName+"------ActivityName");
		System.out.println(ActivityContent+"------ActivityContent");
		System.out.println(ActivityOrganization+"------ActivityOrganization");
		System.out.println(ActivityTime+"------ActivityTime");
		System.out.println(ActivityIntroduction+"------ActivityIntroduction");
		System.out.println(ActivityCover+"------ActivityCover");
		System.out.println(ActivityLocation+"------ActivityLocation");
		
		//if(ActivityName != null && ActivityContent != null &&  ActivityOrganization != null && ActivityTime != null && ActivityIntroduction != null){
			Activity activity = new Activity();
			activity.setActivityContent(ActivityContent);
			activity.setActivityName(ActivityName);
			activity.setActivityTime(ActivityTime);
			Organization organization = orgService.findById(Integer.parseInt(ActivityOrganization.substring(0,1)));
			activity.setOrganization(organization);
			activity.setActivityIntroduction(ActivityIntroduction);
			activity.setActivityLocation(ActivityLocation);
			activity.setActivityPicture(ActivityCover);
			System.out.println("将写入数据库--------");
			actService.add(activity);
			System.out.println("写入数据库成功！");
			
		//}
		return SUCCESS;
		
	}
}
