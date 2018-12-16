package com.hsd.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.hsd.domain.Product;
import com.hsd.service.AdminProductListService;

public class AdminUpdateProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//1����ȡ����
		Map<String, String[]> properties = request.getParameterMap();
		
        //2����װ����
		Product product = new Product();
		try {
			BeanUtils.populate(product, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//��λ��Product�Ѿ���װ���----���������ݷ�װ���
		//�ֶ����ñ���û������
		
		//2����private String pimage;
		product.setPimage("products/1/c_0033.jpg");
		//3����private String pdate;//�ϼ�����
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String pdate = format.format(new Date());
		product.setPdate(pdate);
		//4����private int pflag;//��Ʒ�Ƿ����� 0����δ�¼�
		product.setPflag(0);
        
		//3����������
		AdminProductListService service = new AdminProductListService();
		try {
			service.updateProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��ת���б�ҳ��
		response.sendRedirect(request.getContextPath()+"/adminProductList");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}