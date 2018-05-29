package com.social.scframework.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.FileTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

public class Utility {
	String uid;
	public void getHbs(HttpServletResponse response,String file,Map<String, Object> hashMap,String templatePath) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		TemplateLoader loader = new FileTemplateLoader(templatePath,".hbs");
		Handlebars handlebars = new Handlebars(loader);
		Template template = handlebars.compile(file);
		if(hashMap==null){
			hashMap  = new HashMap<String, Object>();}
		out.print(template.apply(hashMap));
	}

	public String getHbsAsString(String file,Map<String, Object> hashMap,String templatePath) throws ServletException, IOException {
		System.out.println("I am here in hbs...");

		TemplateLoader loader = new FileTemplateLoader(templatePath,".hbs");
		Handlebars handlebars = new Handlebars(loader);
		Template template = handlebars.compile(file);
		if(hashMap==null){			
			hashMap  = new HashMap<String, Object>();
		}

		System.out.println("I am here in hbs...");
		return template.apply(hashMap);
	}


	public String getSession(HttpServletRequest request){

		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie cookie : cookies){
				System.out.println("cookies "+cookie);

				if(cookie.getName().equals("uid")){
					uid = cookie.getValue();

				}}
		} else{
			uid=null;
		}
		return uid;
	}
	public Object changeType(String type,String data){
		Object changedData = null;
		if(type.equals("int")){
			changedData = Integer.parseInt(data);
		}
		if(type.equals("Float")){
			changedData = Float.parseFloat(data);
		}
		if(type.equals("Double")){
			changedData = Double.parseDouble(data);
		}
		if(type.equals("Boolean")){
			changedData = Boolean.parseBoolean(data);
		}
		if(type.equals("Date")){
			System.out.println("I am date");
			SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
			try {
				changedData = format.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return changedData;
	}
}
