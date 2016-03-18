package com.cxg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


public class ResponseWriter {

		public static void writerUploadString(String arg0)
		{
			HttpServletResponse response = ServletActionContext.getResponse();
			try {
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print(arg0);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public static void writerString(String arg0)
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(arg0);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writerXMLObject(String arg0)
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(arg0);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
