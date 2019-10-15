package com.RestApi.JAVA_RestApi;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement


public class Alien {

	
	private String name;
	
	private int Id;
	private int age;
	public String getName(){
		
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getId(){
		return this.Id;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return this.age;
	}
	public void setId(int Id){
		this.Id=Id;
	}
	@Override
	public String toString() {
		return "Alien [name=" + name + ", Id=" + Id + ", age=" + age + "]";
	}

	
	
}
