package com.CandP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.CandP.model.Product;
import com.CandP.util.ConnectionUtil;

public class ProductDAO {

	public void save(Product prod) {
		Connection con=ConnectionUtil.getconnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into product (name,description,price) values(?,?,?)");
			stmt.setString(1,prod.getName());
			stmt.setString(2, prod.getDescription());
			stmt.setBigDecimal(3, prod.getPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
