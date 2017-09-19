package ssmtest.scy.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {
	
	@Before("execution(* find(..))")
	public void round(){
		System.out.println("before round");
	}
}
