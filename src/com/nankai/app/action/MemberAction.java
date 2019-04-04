package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nankai.app.domain.Department;
import com.nankai.app.domain.Member;
import com.nankai.app.domain.Register;
import com.nankai.app.service.DepartmentService;
import com.nankai.app.service.MemberService;
import com.nankai.app.util.HibernateUtil;
import com.nankai.app.vo.RegisterPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MemberAction extends ActionSupport implements ModelDriven<Member>,ServletResponseAware,ServletRequestAware{
	private Member member=new Member();
	private int currentPage=1;
	private int pageSize=100;
	
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
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String updatePassword(){
		Member mem = memberService.findMemberByID(member.getMemberId());
		if(mem.getMemberPassword().equals(member.getOldmemberPassword()))
		{
			if(member.getNewmemberPassword().equals(member.getRememberPassword())) {
				mem.setMemberPassword(member.getNewmemberPassword());
				memberService.update(mem);
				return SUCCESS;
			}else {
				this.addActionError("两次密码不一致！");
				return "fail";
			}
			
		}
		
		else 
		{
			this.addActionError("用户名或密码错误！");
			return "fail";
		}	
	}
	public String updatePasswordForAndroid(){
		response.setCharacterEncoding("utf-8");
		String name = (String) request.getParameter("username");
		String oldPwd = (String) request.getParameter("oldPwd");
		String newPwd = (String) request.getParameter("newPwd");
		String confirmPwd = (String)request.getParameter("confirmPwd");
		Member mem = memberService.findMemberByID(Integer.parseInt(name));
		if(mem!=null&&mem.getMemberPassword().equals(oldPwd))
		{
			if(newPwd.equals(confirmPwd))
			{
				mem.setMemberPassword(newPwd);
				memberService.update(mem);
				try {
					PrintWriter out = response.getWriter();
					out.print("success");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return SUCCESS;
			}else {
				try {
					PrintWriter out = response.getWriter();
					out.print("difference");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "fail";
			}
			
		}
		else 
		{
			try {
				PrintWriter out = response.getWriter();
				out.print("none");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "fail";
		}	
	}
	public String add(){
    	memberService.add(member);
    	return "member_search";
    }
	public void addForAndroid(){
		response.setCharacterEncoding("utf-8");
		String s=request.getParameter("dpt1");
    	Member mem=new Member();
    	mem.setMemberPassword("1");
    	mem.setMemberId(Integer.parseInt(request.getParameter("rnumber")));
    	mem.setMemberName(request.getParameter("rname"));
    	mem.setMemberGender(request.getParameter("rsex"));
    	mem.setMemberMajor(request.getParameter("rmajor"));
    	mem.setMemberHometown(request.getParameter("rhometown"));
    	mem.setMemberBirthday(request.getParameter("rbirthday"));
    	mem.setMemberPhone(request.getParameter("rphone"));
    	mem.setMemberPosition(request.getParameter("rposition"));
    	mem.setDepartment(departmentService.findDepartmentByID(Integer.parseInt(s)));
    	mem.setMemberPicture(request.getParameter("rpicturePath"));
    	memberService.add(mem);
    	try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public String delete(){
    	Member member1=memberService.findMemberByID(member.getMemberId());
    	memberService.delete(member1);
    	return "member_search";
    }
    public void deleteForAndroid(){//只能删干事
    	response.setCharacterEncoding("utf-8");
		String number = (String) request.getParameter("memberNumber");
		Member mem=memberService.findMemberByID(Integer.parseInt(number));
		if(mem.getMemberPosition().equals("干事")){
		memberService.delete(mem);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else{
			try {
				PrintWriter out = response.getWriter();
				out.print("fail");
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    public String searchBeforeUpdate(){
        Member member1=memberService.findMemberByID(member.getMemberId());
        ServletActionContext.getRequest().setAttribute("member",member1);
        return "update";
    }
    public String search(){
    	RegisterPage memberPage=memberService.findAll(currentPage, pageSize);
    	ServletActionContext.getRequest().setAttribute("membersPage", memberPage);
    	ServletActionContext.getRequest().setAttribute("members", memberPage.getMemberList());
    	return "search_success";
    }
    public String update(){
    	memberService.update(member);
    	return "member_search";
    }
    public String updateMemberForAndroid(){
    	response.setCharacterEncoding("utf-8");
    	//想得到这个人的密码因为修改成员信息修改不了成员的密码
    	Member mem1=memberService.findMemberByID(Integer.parseInt(request.getParameter("number")));
    	Member mem=new Member();
    	mem.setMemberPassword(mem1.getMemberPassword());
    	String s=request.getParameter("dpt").substring(0, 3);
    	mem.setMemberId(Integer.parseInt(request.getParameter("number")));
    	mem.setMemberName(request.getParameter("name"));
    	mem.setMemberGender(request.getParameter("sex"));
    	mem.setMemberMajor(request.getParameter("major"));
    	mem.setMemberHometown(request.getParameter("hometown"));
    	mem.setMemberBirthday(request.getParameter("birthday"));
    	mem.setMemberPhone(request.getParameter("phone"));
    	mem.setMemberPosition(request.getParameter("position"));
    	mem.setDepartment(departmentService.findDepartmentByID(Integer.parseInt(s)));
    	mem.setMemberPicture(request.getParameter("picturePath"));
    	memberService.update(mem);
    	try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "success";
    }
    public String findByID(){
    	//按ID查找，返回的是单个对象，为了统一，也存到链表里面
    	Member member1= memberService.findMemberByID(member.getMemberId());
    	List<Member> list = new ArrayList();
    	list.add(member1);
    	ServletActionContext.getRequest().setAttribute("members", list);
    	return "findMemberBySomething";
    }
    public void findMemberByIdForAndroid(){
    	response.setCharacterEncoding("utf-8");
		String number = (String) request.getParameter("memberNumber");
		Member mem=memberService.findMemberByID(Integer.parseInt(number));
    	JSONObject obj=new JSONObject();
    	obj.put("memberId", mem.getMemberId());
	    obj.put("memberPicture", mem.getMemberPicture());
		obj.put("memberName", mem.getMemberName());
		obj.put("memberGender", mem.getMemberGender());
		obj.put("memberMajor", mem.getMemberMajor());
		obj.put("memberHometown", mem.getMemberHometown());
		obj.put("memberPhone", mem.getMemberPhone());
		obj.put("memberPosition", mem.getMemberPosition());
		obj.put("memberBirthday", mem.getMemberBirthday());
		obj.put("memberDepartment", mem.getDepartment().getDepartmentId()+mem.getDepartment().getDepartmentName());
		try {
			PrintWriter out = response.getWriter();
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
    public String findMemberByDid(){
    	List<Member> list1=memberService.findMemberByDid(member.getDepartment().getDepartmentId());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public String findMemberByName(){
    	List<Member> list1=memberService.findMemberByName(member.getMemberName());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public void findMemberByNameForAndroid(){
    	response.setCharacterEncoding("utf-8");
    	String membername=(String) request.getParameter("memberName");
    	String departmentId = (String) request.getParameter("departmentId");
    	List<Member> list1=memberService.findMemberByNameForAndroid(membername,Integer.parseInt(departmentId));
    	JSONArray array=new JSONArray();
    	
		for(Member mem:list1){
			JSONObject obj=new JSONObject();
			obj.put("memberId", mem.getMemberId());
		    obj.put("memberPicture", mem.getMemberPicture());
			obj.put("memberName", mem.getMemberName());
//			obj.put("memberGender", mem.getMemberGender());
//			obj.put("memberMajor", mem.getMemberMajor());
//			obj.put("memberHometown", mem.getMemberHometown());
//			obj.put("memberphone", mem.getMemberPhone());
//			obj.put("memberPosition", mem.getMemberPosition());
//			obj.put("memberBirthday", mem.getMemberBirthday());
//			obj.put("memberDepartment", mem.getDepartment().getDepartmentId()+mem.getDepartment().getDepartmentName());
			array.add(obj);
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(array.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public String findMemberByGender(){
    	List<Member> list1=memberService.findMemberByGender(member.getMemberGender());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public String findMemberByHometown(){
    	List<Member> list1=memberService.findMemberByHometown(member.getMemberHometown());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public String findMemberByMajor(){
    	List<Member> list1=memberService.findMemberByMajor(member.getMemberMajor());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public String findMemberByPosition(){
    	List<Member> list1=memberService.findMemberByPosition(member.getMemberPosition());
    	ServletActionContext.getRequest().setAttribute("members", list1);
    	return "findMemberBySomething";
    }
    public String findMemberBySomething(){
    	
    	if(member.getMemberId()!=null){
    		return "member_findByID";
    	}
    	if(!member.getMemberName().isEmpty()){
    		System.out.println(member.getMemberName()+"2hjsahd");
    		return "member_findMemberByName";
    	}
    	if(!member.getMemberGender().isEmpty()){
    		System.out.println("findByGender");
    		return "member_findMemberByGender";
    	}
    	if(!member.getMemberPosition().isEmpty()){
    		System.out.println("findByPosition");
    		return "member_findMemberByPosition";
    	}
    	if(!member.getMemberMajor().isEmpty()){
    		return "member_findMemberByMajor";
    	}
    	if(!member.getMemberHometown().isEmpty()){
    		return "member_findMemberByHometown";
    	}
    	if(member.getDepartment().getDepartmentId()!=null){
    		return "member_findMemberByDid";
    	}
    	else{
    		return "member_search";
    	}
    }
    //根据登录权限查询
    public String managerSearch(){
    	RegisterPage memberPage=memberService.findAllForManager(currentPage, pageSize);
    	ServletActionContext.getRequest().setAttribute("managerMembers", memberPage.getMemberList());
    	ServletActionContext.getRequest().setAttribute("membersPage", memberPage);
    	return "managerSearch_success";
    }
    public void managerSearchForAndroid(){
    	response.setCharacterEncoding("utf-8");
    	String username=(String) request.getParameter("username");
    	List<Member> memList=memberService.fingAllForManagerAndroid(username);
    	JSONArray array=new JSONArray();
    	
		for(Member mem:memList){
			JSONObject obj=new JSONObject();
			obj.put("memberId", mem.getMemberId());
		    obj.put("memberPicture", mem.getMemberPicture());
			obj.put("memberName", mem.getMemberName());
//			obj.put("memberGender", mem.getMemberGender());
//			obj.put("memberMajor", mem.getMemberMajor());
//			obj.put("memberHometown", mem.getMemberHometown());
//			obj.put("memberphone", mem.getMemberPhone());
//			obj.put("memberPosition", mem.getMemberPosition());
//			obj.put("memberBirthday", mem.getMemberBirthday());
//			obj.put("memberDepartment", mem.getDepartment().getDepartmentId()+mem.getDepartment().getDepartmentName());
			array.add(obj);
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(array.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	@Override
	public Member getModel() {
		// TODO Auto-generated method stub
		return member;
	}

}
