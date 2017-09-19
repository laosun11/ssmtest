package ssmtest.scy.test;

public class ThreadLocalDemo {
	private static ThreadLocal<Integer> threadlocal=new ThreadLocal<>();
	private static Integer i=500;
	static{
		threadlocal.set(i);
	}
	
	public static int getNumber(){
		return threadlocal.get()+1;
	}
}
