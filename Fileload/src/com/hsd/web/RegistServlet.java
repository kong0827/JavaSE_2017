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
		//���������ļ����
		String tempPath = this.getServletContext().getRealPath("temp");
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, new File(tempPath));
		
		//�����ļ��ϴ��ĺ�����
		ServletFileUpload upload = new ServletFileUpload(factory);
		//�����ļ��ϴ������Ƶı����ʽ
		upload.setHeaderEncoding("utf-8");
		
		//�жϱ��Ƿ����ļ��ϴ��ı�
		boolean multipartContent = ServletFileUpload.isMultipartContent(request);
		
		if(multipartContent){
			//���ϴ��ļ��ı�������request����ļ����
			try {
				List<FileItem> parseRequest = upload.parseRequest(request);
				
				if(parseRequest!=null){
					//��������
					for (FileItem fileItem : parseRequest) {
						//�ж��ǲ���һ����ͨ����
						boolean formField = fileItem.isFormField();
						if (formField) {
							//��ͨ����
							String filedName = fileItem.getFieldName();
							//����ͨ������б��룬
							//����ʱenctype="mul.....",request.getparameter��ط���ʧЧ
							String filedValue = fileItem.getString("utf-8");
							System.out.println(filedName+" "+filedValue);
						}else{
							//�ļ��ϴ��
							String filename = fileItem.getName();
							//����ļ���
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
