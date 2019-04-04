package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nankai.app.domain.Department;
import com.nankai.app.domain.Member;
import com.nankai.app.domain.Register;
import com.nankai.app.service.DepartmentService;
import com.nankai.app.service.MemberService;
import com.nankai.app.service.RegisterService;
import com.nankai.app.vo.RegisterPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;



public class RegisterAction extends ActionSupport implements ModelDriven<Register>,ServletResponseAware,ServletRequestAware{
	private Register register = new Register();	
	//分页需要使用的参数
	private int currentPage=1;
	private int pageSize=6;
	
	
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	//配置service
	private RegisterService registerService;
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	} 
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	private MemberService memberService;
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	//新增报名记录
	public String add(){
		register.setRegisterPassword(register.getRegisterId().toString());
		registerService.add(register);	
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("success", "报名成功！");
		return "addsuccess";	
	}
	public void addForAndroid(){
		response.setCharacterEncoding("utf-8");
		Register register=new Register();
		register.setRegisterId(Integer.parseInt(request.getParameter("number")));
		register.setRegisterName(request.getParameter("name"));
		register.setRegisterGender(request.getParameter("sex"));
		register.setRegisterBirthday(request.getParameter("birthday"));
		register.setRegisterMajor(request.getParameter("major"));
		register.setRegisterHometown(request.getParameter("hometown"));
		if(request.getParameter("choice").equals("yes")){
			register.setRegisterAdjust("是");
		}else{
			register.setRegisterAdjust("否");
		}
		register.setRegisterDate(request.getParameter("date"));
		register.setRegisterIntroduction(request.getParameter("introduction"));
		register.setDepartmentByRegisterIntention1(departmentService.findDepartmentByID(Integer.parseInt(request.getParameter("intent1"))));
		register.setDepartmentByRegisterIntention2(departmentService.findDepartmentByID(Integer.parseInt(request.getParameter("intent2"))));
		registerService.add(register);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查询报名记录
	public String search(){
		RegisterPage registerPage1 = registerService.findAll(currentPage, pageSize);
		System.out.println("这里是search函数");
		ServletActionContext.getRequest().setAttribute("registersPage", registerPage1);
		return SUCCESS;
	}
	public void managerSearchForAndroid(){
		System.out.println("managerSearchForAndroid执行");
		response.setCharacterEncoding("utf-8");
		String position=(String) request.getParameter("position");
		String username=(String) request.getParameter("username");
		System.out.println("收到"+position+"--------"+username);
		Member mem=memberService.findMemberByID(Integer.parseInt(username));
		System.out.println("人员"+mem);
		List<Register> regList=registerService.managerSearchForAndroid(mem, position);
		System.out.println("kk"+regList.toString());
		JSONArray array=new JSONArray();
    	
		for(Register reg:regList){
			JSONObject obj=new JSONObject();
			obj.put("registerId", reg.getRegisterId());
		    obj.put("registerPicture", reg.getRegisterPicture());
			obj.put("registerName", reg.getRegisterName());
			array.add(obj);

			System.out.println("m内容b"+obj.toString());
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
	//真删
	public String delete(){
		Register register1=registerService.findRegisterByID(register.getRegisterId());
		registerService.delete(register1);
		return "register_search";
	}
	//假删，对同一组织下报名两个部门
	public String falseDelete() {
		Register register1=registerService.findRegisterByID(register.getRegisterId());
		if(register1.getRegisterStatus()==0) {
			register1.setRegisterStatus(1);
		}
		else{
			if(register1.getRegisterStatus()==1){
			register1.setRegisterStatus(2);
			}
		}
		if(register1.getRegisterStatus()==2||register1.getRegisterAdjust().equals("否")) {
			registerService.delete(register1);
			return "register_search";
		}
		registerService.update(register1);//刷新
		return "register_search";
	}
	public void deleteForAndroid(){
		response.setCharacterEncoding("utf-8");
		String regId=(String) request.getParameter("registerNumber");
		Register register1=registerService.findRegisterByID(Integer.parseInt(regId));
		if(register1.getRegisterStatus()==0) {
			register1.setRegisterStatus(1);
		}
		else{
			if(register1.getRegisterStatus()==1){
			register1.setRegisterStatus(2);
			}
		}
		if(register1.getRegisterStatus()==2&&register1.getRegisterAdjust().equals("否")) {
			registerService.delete(register1);
			return;
		}
		registerService.update(register1);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//查找ID
	public String findByID(){
		Register register1=registerService.findRegisterByID(register.getRegisterId());
		ServletActionContext.getRequest().setAttribute("register", register1);
		return "findByID";
	}
	public String findByIDForDetail(){
		Register register1=registerService.findRegisterByID(register.getRegisterId());
		ServletActionContext.getRequest().setAttribute("register", register1);
		return "findByIDForDetail";
	}
	public void findRegisterByIdForAndroid(){
		response.setCharacterEncoding("utf-8");
		String number = (String) request.getParameter("registerNumber");
		Register reg=registerService.findRegisterByID(Integer.parseInt(number));
		JSONObject obj=new JSONObject();
		obj.put("registerId", reg.getRegisterId());
	    obj.put("registerPicture", reg.getRegisterPicture());
		obj.put("registerName", reg.getRegisterName());
		obj.put("registerGender", reg.getRegisterGender());
		obj.put("registerMajor", reg.getRegisterMajor());
		obj.put("registerHometown", reg.getRegisterHometown());
		obj.put("registerPhone", reg.getRegisterPhone());
		obj.put("registerBirthday", reg.getRegisterBirthday());
		obj.put("registerDepartment1", reg.getDepartmentByRegisterIntention1().getDepartmentId()+reg.getDepartmentByRegisterIntention1().getDepartmentName());
		obj.put("registerDepartment2", reg.getDepartmentByRegisterIntention2().getDepartmentId()+reg.getDepartmentByRegisterIntention2().getDepartmentName());
		try {
			PrintWriter out = response.getWriter();
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//进行刷新
	public String flush()
	{
		ServletActionContext.getRequest().removeAttribute("registersPage");
		return SUCCESS;
	}
	@Override
	public Register getModel() {
		// TODO Auto-generated method stub
		return register;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
