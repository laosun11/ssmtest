package ssmtest.scy.arithmetic;

import java.util.Arrays;
import java.util.Collections;

public class arithmeticTest {
	public static Integer count=0;
	public static void main(String[] args) {
		Integer[] a = new Integer[]{10,8,20,7,11,12,4};
//		System.out.println(Arrays.asList(a));
//		System.out.println(Arrays.asList(xuanZeSort(a)));
//		System.out.println(Arrays.asList(insertSort(a)));
		
		/*StackTest test = new StackTest();
		test.push(1);
		test.push(2);
		System.out.println(test.pop());
		System.out.println(test.pop());*/
		
		/*hanNuoTa(9, 'A', 'C', 'B');
		System.out.println(count);*/
		
		System.out.println(Arrays.asList(recuiseSort(new Integer[]{10,2,4,3,5,9,11,21,7})));
	}
	
	
	//归并排序
	public static Integer[] recuiseSort(Integer[] source){
		//1.二分
		if(source.length==1){
			return source;
		}
		Integer middel = (Integer)source.length/2;
		Integer[] left =new Integer[middel];
		Integer[] right = new Integer[source.length-middel];
		//赋值
		System.arraycopy(source, 0, left, 0, left.length);
		System.arraycopy(source, middel, right, 0, right.length);
		left = recuiseSort(left);//递归调用，排好序
		right = recuiseSort(right);
		//2.合并
		source  = mergeSort(left,right);
		return source;
	};
	
	
	private static Integer[] mergeSort(Integer[] left, Integer[] right) {
		// TODO Auto-generated method stub
		//1.创建第三个数组，用于存放 left和right数组内的值
		Integer[] source = new Integer[left.length+right.length];
		Integer sourceIndex=0;
		Integer leftIndex=0;
		Integer rightIndex=0;
		//2.判断合并
		//1)如果都存在数组
		while(leftIndex<left.length && rightIndex<right.length){
			if(left[leftIndex]<=right[rightIndex]){
				source[sourceIndex]=left[leftIndex];
				leftIndex++;
			}else{
				source[sourceIndex]=right[rightIndex];
				rightIndex++;
			}
			sourceIndex++;
		}
		//2)如果left数据不存在了
		while(leftIndex==left.length && rightIndex<right.length ){
			source[sourceIndex]=right[rightIndex];
			rightIndex++;
			sourceIndex++;
		}
		//3)如果right数据不存在了
		while(rightIndex==right.length && leftIndex<left.length ){
			source[sourceIndex]=left[leftIndex];
			leftIndex++;
			sourceIndex++;
		}
		
		return source;
	}


	/**
	 * 汉诺塔
	 * 步骤 A B C
	 * 1. n-1个移动到 B
	 * 2. 第n个移动到C
	 * 3. 将B下的n-1个移动到C
	 */
	public static void hanNuoTa(Integer n,char from ,char to,char insert){
		count++;
		if(n==1){
			System.out.println("disk1 from "+from+"-->"+to);
		}else{
			hanNuoTa(n-1,from,insert,to);
			System.out.println("disk"+n+" from "+from+"-->"+to);
			hanNuoTa(n-1,insert,to,from);
		}
	}
	
	
	/**
	 * 选择排序，依次比较，选择最小的进行标记，最后交换到左边
	 * @param arrInt
	 * @return
	 */
	public static Integer[] xuanZeSort(Integer[] arrInt){
		
		Integer temp=0;
		//循环arrInt.length次
		for (int i = 0; i < arrInt.length-1; i++) {
			//当前最小值对应的位置
			Integer k=i;
			for (int j = i+1; j < arrInt.length; j++) {
				if(arrInt[k]>arrInt[j]){
					k=j;
				}
			}
			//交换
			temp = arrInt[i];
			arrInt[i]=arrInt[k];
			arrInt[k]=temp;
		}
		return arrInt;
	}
	
	/**
	 * 插入排序思想
	 * 局部有序，将被标记的数，依次跟局部有序数据比较，然后插入到正确的位置
	 * 实现思想：
	 *  从左边第二个开始，对左边的有序集合进行比较
	 * @param arrInt
	 * @return
	 */
	public static Integer[] insertSort(Integer[] arrInt){
		Integer temp = 0;
		Integer aj=0;
		for (int i = 1; i < arrInt.length; i++) {
			boolean flag= false;//用于标识是否已经进行了插入
			for (int j = 0; j < i; j++) {
				//插入要排序的值,跟j比较，如果小于并且没有插入则进行插入操作
				if(!flag && arrInt[i]<=arrInt[j]){
					temp=arrInt[j];
					arrInt[j]=arrInt[i];
					aj=temp;
					flag=true;
					continue;
				}
				//将插入值对应的原位置及以后往后移动
				if(flag){
					//当前值等于保存的 
					temp=arrInt[j];
					arrInt[j]=aj;
					aj=temp;
				}
			}
			if(flag){
				arrInt[i]=aj;
			}
			System.out.println(aj);
		}
		return arrInt;
	}
	
}	
