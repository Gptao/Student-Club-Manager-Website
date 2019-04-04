package com.nankai.app.action;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.nankai.app.domain.Member;
import com.nankai.app.service.MemberService;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import sun.misc.BASE64Decoder;

public class LoadImage implements ServletResponseAware,ServletRequestAware{
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String GenerateImage() {   //���ֽ������ַ�������Base64���벢����ͼƬ
	    String imgStr= (String)request.getParameter("data");
	    String username=(String)request.getParameter("id");
		System.out.println(imgStr);
        if (imgStr == null) //ͼ������Ϊ��
            return "false";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64����
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//�����쳣����
                    b[i] += 256;
                }
            }
            //����jpegͼƬE:\EclipseWorkspace\Spring_7_17\ClubManager\WebContent\images\head
            String imgFilePath = "E://EclipseWorkspace/Spring_7_17/ClubManager/WebContent/images/head/"+username+".png";//�����ɵ�ͼƬ
            String imgPath;
            imgPath = LoadImage.class.getClassLoader().getResource("").getPath();
            imgPath = imgPath.split("WEB-INF")[0];
            imgPath = imgPath+"images/head/"+username+".png";
            System.out.println(imgPath+"--------------");
            //����ͷ��
            Member member=memberService.findMemberByID(Integer.parseInt(username));
            member.setMemberPicture("head/"+username+".png");
            memberService.update(member);
            OutputStream out1 = new FileOutputStream(imgFilePath);
            out1.write(b);
            out1.flush();
            out1.close();
            OutputStream out2 = new FileOutputStream(imgPath);
            out2.write(b);
            out2.flush();
            out2.close();
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
	
	public String GenerateImageForActivity() {   //���ֽ������ַ�������Base64���벢����ͼƬ
	    String imgStr= (String)request.getParameter("data");
	    String username=(String)request.getParameter("id");
		System.out.println(imgStr);
        if (imgStr == null) //ͼ������Ϊ��
            return "false";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64����
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//�����쳣����
                    b[i] += 256;
                }
            }
            //����jpegͼƬE:\EclipseWorkspace\Spring_7_17\ClubManager\WebContent\images\head
            String imgFilePath = "E://EclipseWorkspace/Spring_7_17/ClubManager/WebContent/images/head/"+username+".png";//�����ɵ�ͼƬ
            String imgPath;
            imgPath = LoadImage.class.getClassLoader().getResource("").getPath();
            imgPath = imgPath.split("WEB-INF")[0];
            imgPath = imgPath+"images/head/"+username+".png";
            
            System.out.println("���ߵ�ַ-----"+imgPath);
            System.out.println("���ص�ַ-----"+imgFilePath);
            
            OutputStream out1 = new FileOutputStream(imgFilePath);
            out1.write(b);
            out1.flush();
            out1.close();
            OutputStream out2 = new FileOutputStream(imgPath);
            out2.write(b);
            out2.flush();
            out2.close();
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
