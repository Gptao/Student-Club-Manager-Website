package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;
import com.nankai.app.service.ChatService;
import com.nankai.app.service.CollectionService;
import com.nankai.app.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CollectionAction  extends ActionSupport implements ModelDriven<Collection>,ServletResponseAware,ServletRequestAware{
	private Collection collection;
	private MemberService memberService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	

	private CollectionService collectionService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	public String select()
	{
		System.out.println("collection test 函数");	
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String activityId = request.getParameter("activityId");
		String userId = request.getParameter("userId");
		String state = request.getParameter("state");
		System.out.println("activityId------------"+activityId);
		System.out.println("userId------------"+userId);
		System.out.println("state------------"+state);
		
		//从数据库找出当前userId和activityId对应的收藏记录
		//Collection mCollection = collectionService.findCollectionByUserAndActivity(Integer.parseInt(userId), Integer.parseInt(activityId));
		int actID = Integer.parseInt(activityId);
		int userID = Integer.parseInt(userId);
		
		if(state.equals("true"))
		{//添加收藏
			Collection mCollection = new Collection();
			mCollection.setActivityId(actID);
			mCollection.setUserId(userID);
			collectionService.add(mCollection);
		}
		else
		{//删除收藏
			Collection nCollection = collectionService.findCollectionByUserAndActivity(userID, actID);
			collectionService.delete(nCollection);
		}

		return null;
	}
	
	public String findCollectionByUserAndActivity() {
		
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String activityId = request.getParameter("activityId");
		String userId = request.getParameter("userId");
		//去数据库查记录
		Collection mCollection = collectionService.findCollectionByUserAndActivity(Integer.parseInt(userId), Integer.parseInt(activityId));
		
		PrintWriter out;
		try {
			out = response.getWriter();
			if(mCollection != null)
			{
				out.println("writesuccess");
			}
			else{
				out.println("writefail");
			}
			out.flush();
			out.close();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public Collection getModel() {
		return collection;
	}

}
