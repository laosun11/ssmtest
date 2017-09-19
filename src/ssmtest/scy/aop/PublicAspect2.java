package ssmtest.scy.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.transaction.PlatformTransactionManager;

public class PublicAspect2 {
	
	public void before(JoinPoint jp){
		System.out.println("before round"+jp.getSignature().getName());
	}
	public void after(){
		System.out.println("after round");
	}
	public void afterreturn(){
		System.out.println("afterreturn round");
	}
	public void round(){
		System.out.println("round round");
	}
}
