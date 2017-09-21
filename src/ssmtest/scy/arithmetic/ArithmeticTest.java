package ssmtest.scy.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.thoughtworks.xstream.converters.reflection.SortableFieldKeySorter;

public class ArithmeticTest {
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
		
//		System.out.println(Arrays.asList(recuiseSort(new Integer[]{10,2,4,3,5,9,11,21,7})));
		
		Integer[] source =new Integer[]{10,2,4,3,5,9,11,21,7};
//		System.out.println(Arrays.asList(shellSort(source, 4)));
		
		System.out.println(Arrays.asList(recQuickSort(source)));
	}
	
	/**
	 * 
	 * Description:快速排序思想
	 * 选择一个关键字，将小于关键字的放在左边，大于关键字的放在右边，递归调用。
	 * <br/>
	 * Date: 2017年9月21日 下午3:02:03 <br/>
	
	 * @author sunchaoyuan
	 * @param source
	 * @return
	 */
	public static Integer[] recQuickSort(Integer[] source){
		if(source.length==0){
			return null;
		}
		if(source.length==1){
			return source;
		}
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		List<Integer> targetList = new ArrayList<>();
		Integer target = source[source.length-1];//关键字用于站队的标杆
		for (int i = 0; i < source.length-1; i++) {
			if(source[i]<=target){
				left.add(source[i]);
			}else{
				right.add(source[i]);
			}
		}
		if(left.size()>0){
			left =Arrays.asList(recQuickSort(left.toArray(new Integer[left.size()])));
		}
		if(right.size()>0){
		    right =Arrays.asList(recQuickSort(right.toArray(new Integer[right.size()])));
		}
		targetList.addAll(left);
		targetList.add(target);
		targetList.addAll(right);
		source = targetList.toArray(new Integer[left.size()]);
		return source;
	}
	
	public static Integer[] shellSort(Integer[] source,Integer k){
		while(k>0){
			for(int h = 0;h<k;h++){//只遍历到k-1下标，因为其它的都会通过增量判定到
				System.out.println(h+"---"+k);
				//插入排序
				for (int i = h+k; i < source.length; i=i+k) {
					boolean flag = false;//用于表示是否进行了插入操作
					Integer temp=0;
					for (int j = h; j < i; j=j+k) {
						if(!flag && source[i]<=source[j]){
						   	temp = source[j];
						   	source[j]=source[i];
						   	flag=true;
						   	break;
						}
						if(flag){
							Integer tempj= source[j];
						   	source[j]=temp;
							temp = tempj;
						}
					}
					if(flag){
						source[i]=temp;
					}
				}
			}
			k=(Integer)k/2;
		}
		return source;
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
