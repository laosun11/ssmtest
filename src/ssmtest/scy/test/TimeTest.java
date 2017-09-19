package ssmtest.scy.test;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {
	public static void main(String[] args) {
		//测试问题，Date的getTime()方法和Calendar的getMillTime()方法
		Date d = new Date();
		Calendar cc = Calendar.getInstance();
		cc.setTime(d);
		
		System.out.println(d.getTime());
		System.out.println(cc.getTimeInMillis());
		
	}
}
