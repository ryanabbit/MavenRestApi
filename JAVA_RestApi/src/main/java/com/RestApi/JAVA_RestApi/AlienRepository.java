package com.RestApi.JAVA_RestApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.*;

import javax.ws.rs.PathParam;
public class AlienRepository {

	
	// create CRUD
	
	Connection con=null;
	
	public AlienRepository(){
		String url="jdbc:mysql://localhost:3306/restdb?serverTimezone=UTC&useSSL=false";
		String username="root";
		String password="ryangolf4226";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		    
			con=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public List<Alien>getAliens(){
		
		List<Alien> aliens=new ArrayList<Alien>();
		String sql="select * from alien";
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			
			Alien a=new Alien(); 
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setAge(rs.getInt(3));
			aliens.add(a);
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return aliens;
	}
    public Alien  getAlien(int id){
		
    	String sql="select * from Alien where id="+id;
    	Alien a=new Alien(); 
		try{
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			a.setAge(rs.getInt(3));
		
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return a;
	}

	public void create(Alien a1) {
		
		String sql="insert into alien values(?,?,?)";
		try{
			PreparedStatement st=con.prepareStatement(sql);
			
	    	st.setInt(1, a1.getId());
	        st.setString(2,a1.getName());
			st.setInt(3,a1.getAge());
			
			st.executeUpdate(); 
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
	 
	 public void Update(Alien a1){
		 

			String sql="Update alien set name=?, age=? where id=?";
			try{
				PreparedStatement st=con.prepareStatement(sql);
		    	
		        st.setString(1,a1.getName());
				st.setInt(2,a1.getAge());
				st.setInt(3,a1.getId());
				
				st.executeUpdate(); 
				
				}
				catch(Exception e){
					System.out.println(e);
				}
		 
	 }
	 
	 public void delete(int id){
		 
		 
		 String sql="delete from Alien where id=?";
			try{
				PreparedStatement st=con.prepareStatement(sql);
		    	
		       
				st.setInt(1,id);
				
			    st.executeUpdate(); 
			    
				}
				catch(Exception e){
					System.out.println(e);
				}
		 
	 } 

	
	
}
