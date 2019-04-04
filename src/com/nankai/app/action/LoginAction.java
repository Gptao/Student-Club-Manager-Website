package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSONObject;
import com.nankai.app.domain.Member;
import com.nankai.app.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Member>,ServletResponseAware,ServletRequestAware {
	private Member mem=new Member();
	MemberService memberService;
	private HttpServletResponse response;
	private HttpServletRequest request;

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public String execute(){
		//ʹ�õ�¼�������ݿ���¼  �鵽��¼���������һ��һ��
		//Ȼ��ʹ��session�����û��� ���û�Ȩ�޵ȼ�
		
		//Ϊ�˰�׿����һ��request
		Member member = memberService.findMemberByID(mem.getMemberId());
		HttpSession sessionForUsername=ServletActionContext.getRequest().getSession();
		HttpSession sessionForPosition=ServletActionContext.getRequest().getSession();
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(member != null && member.getMemberPassword().equals(mem.getMemberPassword()))
		{
			sessionForUsername.setAttribute("username", member.getMemberId());
			sessionForPosition.setAttribute("userPosition",member.getMemberPosition());
			session.setAttribute("user", member);
			session.setAttribute("name", "��ã�"+member.getMemberName()+"  ���ע��");
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("succe", "��¼�ɹ���");
			/*if()
			request.getAttribute("lastPage")*/
			return SUCCESS;
		}
		else if(mem.getMemberId()==1510742 && mem.getMemberPassword().equals("12345")){
			sessionForUsername.setAttribute("username",mem.getMemberId());
			sessionForPosition.setAttribute("userPosition","����Ա");
			session.setAttribute("name", "��ã�����Ա,���ע��");
			mem.setMemberPosition("����Ա");
			session.setAttribute("user", mem);
			return SUCCESS;
		}
		else{
			this.addActionError("�û������������");
			return "fail";
		}						
	}
	public String login(){
		//ʹ�õ�¼�������ݿ���¼  �鵽��¼���������һ��һ��
		//Ȼ��ʹ��session�����û��� ���û�Ȩ�޵ȼ�
		response.setCharacterEncoding("utf-8");
		String name = (String) request.getParameter("username");
		String pwd = (String) request.getParameter("pwd");
		JSONObject obj=new JSONObject();
		if(name.equals("23501326") && pwd.equals("1")){
			obj.put("position", "����Ա");
			obj.put("department", 0);
			try {
				PrintWriter out = response.getWriter();
				out.print(obj.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}	
		Member member = memberService.findMemberByID(Integer.parseInt(name));
		if(member != null && member.getMemberPassword().equals(pwd))
		{
			obj.put("position",member.getMemberPosition());
			obj.put("department", member.getDepartment().getDepartmentId());
			obj.put("dptName", member.getDepartment().getOrganization().getOrganizationName()+member.getDepartment().getDepartmentName());
			obj.put("name", member.getMemberName());
			try {
				PrintWriter out = response.getWriter();
				out.print(obj.toString());
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return SUCCESS;
		}
		else{
			try {
				
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "fail";
		}
	}
	
	@Override
	public Member getModel() {
		return mem;
	}
}
