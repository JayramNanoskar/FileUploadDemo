package com.jayram;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try 
		{
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			while (iterator.hasNext())
			{
				FileItem item = iterator.next();
				item.write(new File("E:\\Jayram Java Project\\JSP and Servlet\\FileUploadDemo\\"+item.getName()));
			}
			out.println("File/s uploaded !!!");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
