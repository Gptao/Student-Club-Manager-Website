package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.nankai.app.domain.Activity;
import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Member;
import com.nankai.app.service.ChatService;
import com.nankai.app.service.MemberService;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.ChatPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChatAction  extends ActionSupport implements ModelDriven<Chatroom>,ServletResponseAware,ServletRequestAware{
	private Chatroom chatroom=new Chatroom();
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	private HttpServletResponse response;
	private HttpServletRequest request;
	
	//使用chatService对数据库中 聊天室这张表进行增删改查
	private ChatService chatService;
	public String add()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String messageTime = df.format(new Date());// new Date()为获取当前系统时间
		chatroom.setMessageTime(messageTime);
		chatService.add(chatroom);
		return "add";
	}
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
	public String search()
	{
		ChatPage chatPage = chatService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("chatPage", chatPage);
		return SUCCESS;	
	}
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}

	public String test()
	{
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String content = request.getParameter("content");
		String userId = request.getParameter("userId");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String messageTime = df.format(new Date());// new Date()为获取当前系统时间
		System.out.println(content+"------"+userId+"---------"+messageTime);
		if(content != null ){
			Chatroom newChat = new Chatroom();
			newChat.setMessageAuthor(Integer.parseInt(userId));
			newChat.setMessageContent(content);
			newChat.setMessageTime(messageTime);
			chatService.add(newChat);
			System.out.println("保存数据库成功！");
			//把成功信息写出去	
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("chatSuccess");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		return SUCCESS;
		
	}
	
	//查询所有公告
	public String findAll() {
		//为了安卓，出一个request
		response.setContentType("text/html; charset=utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//从数据库查询所有的公告
		List<Chatroom> list = chatService.findAllForList();
		//将活动的列表转成json
		//首先
		List<HashMap<String, Object>> map_List = new ArrayList<HashMap<String, Object>>();
             
        System.out.println("公告数量---"+list.size());
        for(Chatroom chat :list)    
        {    
            HashMap<String,Object> map = new HashMap();
            Member mem = memberService.findMemberByID(chat.getMessageAuthor());
            if(mem == null)
            	continue;
            String authorName = mem.getMemberName();
            map.put("MessageAuthor", authorName);
            map.put("MessageContent",chat.getMessageContent());
            map.put("MessageTime", chat.getMessageTime());
            map_List.add(map);
        }
        
   	 	String result = JSON.toJSONString(map_List);
   	 	System.out.println("公告JSON-----"+result);

		//把json写出去	
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
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public Chatroom getModel() {
		return chatroom;
	}

}
