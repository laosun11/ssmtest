package ssmtest.scy.test;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;

import ssmtest.scy.dao.UserDao;
import ssmtest.scy.pojo.User;
import ssmtest.scy.service.impl.BeanTest;

public class Test {
	public static void main(String[] args) {
		// 1.获取application配置文件
//		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
	/*	UserDao userdao = (UserDao) context.getBean("userDao");
//		User u = new User();
//		u.setId(UUID.randomUUID().toString().replace("-", ""));
//		u.setXm("张三");
//		userdao.add(u);
		int delcount=userdao.delete("a3554748b0b211e680a31c3947eb3247");
		System.out.println(delcount);
		List<User> list=userdao.find();
		for(User u1:list){
			System.out.println(u1.getId()+"--"+u1.getXm());
		}*/
		
//		BeanTest bt=(BeanTest) context.getBean("hello");
//		System.out.println(bt.getName()+"---"+bt.getAge()+"--"+bt.getAddress());
		/*int all=sumAll(0,1);
		System.out.println(all);
		int sum=0;
		for (int i = 0; i <= 100; i++) {
			sum=sum+i;
		}
		System.out.println(sum);*/
		
		ThreadLocalDemo t=new ThreadLocalDemo();
		t.getNumber();
	}
	
	
	//递归加和
	public static int sumAll(int sum,int i){
		if(i<=100){
			sum=sumAll(sum,++i);
			sum=sum+(i-1);
			System.out.println(sum);
		}
		return sum;
	}
}
