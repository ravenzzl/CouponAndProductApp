package com.CandP.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CandP.dao.CouponDAO;
import com.CandP.model.Coupon;

/**
 * Servlet implementation class CouponControll
 */
@WebServlet("/CouponControll")
public class CouponControll extends HttpServlet {
	private CouponDAO dao=new CouponDAO();
	
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action.equals("create")) {
			CreateCoupn(req, res);			
		}else {
			findby(req, res);
			
		}
		
	}




	private void CreateCoupn(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String couponCode=req.getParameter("couponcode");
		String discount=req.getParameter("discount");
		String expirydate=req.getParameter("expirydate");
		Coupon cop=new Coupon();
		cop.setCode(couponCode);
		cop.setDiscount(new BigDecimal(discount));
		cop.setExp_date(expirydate);
		dao.save(cop);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("Coupon created");
		out.print("<br>");
		out.print("<a href='/CouponAndProductApp'>HOME</a>");
	}
	private void findby(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String code=req.getParameter("couponcode");
		Coupon coupon = dao.findbyCode(code);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("Coupon got : ");
		out.print("<br>");
		out.print(coupon);
		out.print("<br>");
		out.print("<a href='/CouponAndProductApp'>HOME</a>");
	}

}










