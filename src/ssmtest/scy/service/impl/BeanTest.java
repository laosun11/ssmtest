package ssmtest.scy.service.impl;

public class BeanTest {
	private String name;
	private Integer age;
	private String address="";
	public BeanTest(String address) {
		super();
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void test(){
		System.out.println("beantest初始化");
	}
}
