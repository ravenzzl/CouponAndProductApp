package com.CandP.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CandP.dao.CouponDAO;
import com.CandP.dao.ProductDAO;
import com.CandP.model.Coupon;
import com.CandP.model.Product;

@WebServlet("/createproduct")
public class ProductController extends HttpServlet {
	
	CouponDAO cDao=new CouponDAO();
	ProductDAO pdoa=new ProductDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String coupon=req.getParameter("Coupon");
		String name=req.getParameter("name");
		BigDecimal price=new BigDecimal(req.getParameter("price"));
		String discription=req.getParameter("discription");
		
	    Coupon cop=cDao.findbyCode(coupon);
		BigDecimal discountprice=cop.getDiscount();
		Product prod=new Product();
		prod.setName(name);
		prod.setDescription(discription);
		BigDecimal finalprice=price.subtract(discountprice);
		prod.setPrice(finalprice);
		pdoa.save(prod);
		
	}

}
