package com.CandP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CandP.model.Coupon;
import com.CandP.util.ConnectionUtil;

public class CouponDAO {
	
	public void save(Coupon cop) {
		Connection con=ConnectionUtil.getconnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into coupon (code,discount,exp_date) values(?,?,?)");
			stmt.setString(1, cop.getCode());
			stmt.setBigDecimal(2,cop.getDiscount());
			stmt.setString(3,cop.getExp_date());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Coupon findbyCode(String code) {
		Coupon cop=new Coupon();
		Connection con=ConnectionUtil.getconnection();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from coupon where code=?");
			stmt.setString(1, code);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				cop.setId(rs.getInt(1));
				cop.setCode(rs.getString(2));
				cop.setDiscount(rs.getBigDecimal(3));
				cop.setExp_date(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cop;
		
	}

}
