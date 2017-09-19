package ssmtest.scy.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 栈：先进后出的思想
 * @author suda
 *
 */
public class StackTest {
	private List<Integer> list=new ArrayList<>();
	
	//进栈
	public void push(Integer i){
		list.add(i);
	}
	
	//出栈--先进后出
	public Integer pop(){
		if(list.size()>0){
			Integer i = list.get(list.size()-1);
			list.remove(list.size()-1);
			return i;
		}
		return 0;
	}
}
