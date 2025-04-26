package com.dbs;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.Product;

public class DBService {
	Connection con=null;

	public DBService() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/10mar25ad?user=root&password=root");
			
		}
		catch(Exception e) {
			System.out.println("Error in loading driver and making connection");
		}
	}
	public boolean addProduct(Product pd) {
		boolean b= false;
		try {
			PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?)");
			ps.setInt(1, pd.getpId());
			ps.setString(2, pd.getpName());
			ps.setDouble(3, pd.getPrice());
			int x=ps.executeUpdate();
			if(x>0)
				return true;
			else
				return false;
			
		}
		catch(SQLException e) 
		{
	System.out.println("Error in sql statement");
	return false;
		}

	}
		public boolean UpdateProduct(Product pd) {
			boolean b= false;
			try {
				PreparedStatement ps=con.prepareStatement("update product set pname=?,price=? where pid=?");
				ps.setString(1, pd.getpName());
				ps.setDouble(2, pd.getPrice());
				ps.setInt(3, pd.getpId());
				int x=ps.executeUpdate();
				if(x>0)
					return true;
				else
					return false;
			}
			catch(SQLException e) 
			{
		System.out.println("Error in sql statement");
		return false;
	}

	}
			
			public boolean DeleteProduct(Product pd) {
				boolean b= false;
				try {
					PreparedStatement ps=con.prepareStatement("Delete from product where pid=?");
					//ps.setString(1, pd.getpName());
					//ps.setDouble(2, pd.getPrice());
					ps.setInt(1, pd.getpId());
					int x=ps.executeUpdate();
					if(x>0) {
						return true;
					}
					
					else {
						return false;
					}
				}
				catch(SQLException e) 
				{
			System.out.println("Error in sql statement");
			return false;
				}
			}	
	
			public Product getProduct(Product pd) {
				Product p=new Product();
				try {
					PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
					
					ps.setInt(1, pd.getpId());
					ResultSet rs=ps.executeQuery();
					if(rs.next()==true) {
					System.out.println("11111111111111111111");
					p.setpId(rs.getInt("pid"));
					p.setpName(rs.getString("pname"));
					p.setPrice(rs.getDouble("price"));
					}
					else 
						return null;
					
					}
				catch(SQLException e) 
				{
			System.out.println("Error in sql statement");
				}
			return p;
				}
			public ArrayList<Product> getAllProduct(){
				ArrayList<Product>lst=new ArrayList<>();
				try {
				PreparedStatement ps=con.prepareStatement("select * from product ");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Product p=new Product();
					p.setpId(rs.getInt("pid"));
					p.setpName(rs.getString("pname"));
					p.setPrice(rs.getDouble("price"));
					lst.add(p);
				}
					
				}	
			catch(SQLException e) 
			{
		System.out.println("Error in sql statement");
			}
		return lst;
			}
}
	



