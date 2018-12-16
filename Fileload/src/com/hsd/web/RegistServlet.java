package com.hsd.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;



public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建磁盘文件项工厂
		String tempPath = this.getServletContext().getRealPath("temp");
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, new File(tempPath));
		
		//创建文件上传的核心类
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置文件上传的名称的编码格式
		upload.setHeaderEncoding("utf-8");
		
		//判断表单是否是文件上传的表单
		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
		
		if(multipartContent){
			//是上传文件的表单，解析request获得文件项集合
			try {
				List<FileItem> parseRequest = upload.parseRequest(request);
				
				if(parseRequest!=null){
					//遍历集合
					for (FileItem fileItem : parseRequest) {
						//判断是不是一个普通表单项
						boolean formField = fileItem.isFormField();
						if (formField) {
							//普通表单项
							String filedName = fileItem.getFieldName();
							//对普通表单项进行编码，
							//当表单时enctype="mul.....",request.getparameter相关方法失效
							String filedValue = fileItem.getString("utf-8");
							System.out.println(filedName+" "+filedValue);
						}else{
							//文件上传项，
							String filename = fileItem.getName();
							//获得文件名
							InputStream in = fileItem.getInputStream();
							String path_store = this.getServletContext().getRealPath("upload");
							OutputStream out = new FileOutputStream(path_store+"/"+filename);
							IOUtils.copy(in, out);
							in.close();
							out.close();
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
