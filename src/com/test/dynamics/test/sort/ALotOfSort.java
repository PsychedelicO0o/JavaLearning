
package com.test.dynamics.test.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALotOfSort {
	
	static int [] numberArray;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String [] args){
		
		init();
	//	straightInsertionSort();
	//	shellSort();
	//	simplySort();
	//	heapSort();
	//	bubbleSort();
	//	quickSort();
	//	mergeSort();
		radixSort();
		for(int j = 0 ; j < numberArray.length ; j ++){
			System.out.print(numberArray[j]+" ");
		}
		System.out.println();
	}
	
	static private void init(){
		System.out.println("请输入数列个数：");
		int length = sc.nextInt();
		int i = 0 ;
		numberArray = new int [length]; 
		System.out.println("请输入数列值，以空格分隔：");
		while(i<length&&sc.hasNext()){
			numberArray[i]=sc.nextInt();
			i++;
		}
	}
	
	//直接插入法
	static private void straightInsertionSort(){
		
		int temp = 0, j = 0;
		for(int i = 1 ; i < numberArray.length ; i ++){
			
			j = i-1;
			temp = numberArray[i];
			for( ; j >= 0 && numberArray[j] > temp ; j-- ){
				numberArray[j+1] = numberArray[j];
			}
			numberArray[j+1] = temp;
		}
	}
	
	//希尔排序
	static private void shellSort(){
		
		int d = numberArray.length;
		int temp = 0 , j = 0;
		
		while(true){
			
			d/=2;
			
			for(int x = 0 ; x < d ; x ++){
				
				for(int i = x + d ;i < numberArray.length ; x += d){
					
					j = i - d ;
					temp = numberArray[i] ;
					for(;j >= 0 && numberArray[j] > temp ; j -= d){
						numberArray[j+d] = numberArray[j] ;
					}
					numberArray[j+d] = temp ;
				}
			}
			
			if(d == 1){
				
				break ;
			}
		}
	}
	
	//简单排序算法
	static private void simplySort(){
		
		int posion,temp;
		for(int i = 0 ; i < numberArray.length ; i ++ ){
			
			temp = numberArray[i];
			posion = i;
			for(int j = i + 1 ; j < numberArray.length ; j ++){
				if(numberArray[j] < temp){
					temp = numberArray[j];
					posion = j;
				}
			}
			numberArray[i] = temp;
			numberArray[posion] = numberArray[i];
		}
	}
	//堆排序算法
		static private void heapSort(){
			
			for(int i = 0 ; i < numberArray.length - 1 ; i ++){
			//	System.out.println("第"+(i+1)+"次构建堆");
				//构造大根堆
				buildMaxHeap(numberArray.length - i - 1);
				//交换堆顶与最后一个元素
				swap(0,numberArray.length - i - 1);
				//查看每次构建堆后数组的排序情况
				for(int j = 0 ; j < numberArray.length ; j ++){
					System.out.print(numberArray[j]+" ");
				}
				System.out.println();
			}
			
		}
		//交换两个位置的元素
		static private void swap(int i ,int j){
			
			int temp = numberArray[i];
			numberArray[i] = numberArray[j];
			numberArray[j] = temp;
		}
		//从0到lastIndex的位置构造大根堆
		static private void buildMaxHeap(int lastIndex){
			
			int k = 0,biggerIndex = 0,times = 1;
			for(int i = (lastIndex-1)/2 ; i >= 0 ; i --){
				//	System.out.println("***第"+((lastIndex-1)/2-i+1)+"次");
					//k用来保存正在判断的节点位置
				k = i ;
				//如果当前节点存在
				while(k*2+1 <= lastIndex){
					//k节点的左子节点位置
					biggerIndex = k*2+1;
					//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				//	System.out.println("******节点"+k);
					if(biggerIndex < lastIndex){
						//若果右子节点的值较大
						if(numberArray[biggerIndex] < numberArray[biggerIndex+1]){
							//biggerIndex总是记录较大子节点的索引
				//			System.out.println("******由于第"+k+"个节点的索引为"+biggerIndex+"的左孩子的值小于其索引为"+(biggerIndex+1)+"的右孩子的值，则将其右孩子作为本次与节点比较的对象");
							biggerIndex ++;
						}
					}
					//如果k节点的值小于其较大的子节点的值
					if(numberArray[k] < numberArray[biggerIndex]){
						//交换他们  
				//		System.out.println("******本次比较，左右孩子中值交大的元素"+biggerIndex+"的值("+numberArray[biggerIndex]+")比父节点"+k+"的值("+numberArray[k]+")大,则交换其位置");
						swap(k,biggerIndex);
						for(int j = 0 ; j < numberArray.length ; j ++){
							System.out.print(numberArray[j]+" ");
						}
						System.out.println();
						//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值 
						k = biggerIndex ;
					}else{
						break ;
					}
				}
			}
		}
	//冒泡排序
	static void bubbleSort(){
		
		int temp = 0;
		for(int i = 0 ; i < numberArray.length - 1 ; i ++){
			for(int j = 0 ; j < numberArray.length - i - 1 ; j ++ ){
				if(numberArray[j] > numberArray[j + 1 ]){
					temp = numberArray[j];
					numberArray[j] = numberArray[j + 1];
					numberArray[j + 1] = temp;
				}
			}
		}
	}
	
	//快速排序
		static void quickSort(){
			if(numberArray.length > 0){
				circleSortForQuickSort(0,numberArray.length -1);
			}
		}
		static private void circleSortForQuickSort(int lowIndex,int highIndex){
			if(lowIndex < highIndex){
				
				int middleIndex = findMiddleIndex(lowIndex,highIndex);
				circleSortForQuickSort(lowIndex,middleIndex-1);
				circleSortForQuickSort(middleIndex+1,highIndex);
			}
		}
		static private int findMiddleIndex(int lowIndex,int highIndex){
			
			int temp = numberArray[lowIndex];
			while(lowIndex < highIndex){
				
				while(lowIndex < highIndex && temp <= numberArray[highIndex]){
					highIndex -- ;
				}
				numberArray[lowIndex] = numberArray[highIndex];
				
				while(lowIndex < highIndex && temp >= numberArray[lowIndex]){
					lowIndex ++ ; 
				}
				numberArray[highIndex] = numberArray[lowIndex];
			}
			
			numberArray[lowIndex] = temp;
			return lowIndex;
		}
	
	//归并排序
		static void mergeSort(){
			if(numberArray.length > 0){
				circleSortForMergeSort(0,numberArray.length -1);
			}
		}
		static void circleSortForMergeSort(int low,int high){
			
			if(low < high){
				
				int mid = (low + high) / 2;
				circleSortForMergeSort(low,mid);
				circleSortForMergeSort(mid + 1,high);
				mergeArray(low,mid,high);
			}
		}
		static void mergeArray(int low , int mid , int high){
			
			int [] middleArray = new int [high - low + 1];
			int tempIndex = 0;
			int tempmid = mid + 1;
			int templow = low ;
			
			while(templow <= mid && tempmid <= high){
				if(numberArray[templow] < numberArray[tempmid]){
					middleArray[tempIndex++] = numberArray[templow++];
				}else{
					middleArray[tempIndex++] = numberArray[tempmid++];
				}
			}
			while(templow <= mid){
				middleArray[tempIndex++] = numberArray[templow++];
			}
			while(tempmid <= high){
				middleArray[tempIndex++] = numberArray[tempmid++];
			}
			tempIndex = 0;
			while(low <= high){
				numberArray[low ++] = middleArray[tempIndex++];
			}
			
			for(int j = 0 ; j < numberArray.length ; j ++){
				System.out.print(numberArray[j]+" ");
			}
			System.out.println();
		}
	
	//基数排序
	static private void radixSort(){
		
		int temp = numberArray[0];
		int times = 1 ;
		for(int i = 1 ; i < numberArray.length ; i ++ ){
			if(temp < numberArray[i]){
				temp = numberArray[i];
			}
		}
		
		while((temp/=10) != 0){
			times ++ ;
		}
		
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for(int i = 0 ; i < 10 ; i ++){
			queue.add(i,new ArrayList<Integer>());
		}
		
		int x = 0;
		
		for(int i = 0 ; i < times ; i ++){
			for(int j = 0 ; j < numberArray.length ; j ++){
				x = (int) ((numberArray[j]%Math.pow(10, i+1))/Math.pow(10, i));
				ArrayList tempList = queue.get(x);
				tempList.add(tempList.size(), numberArray[j]);
			}
			
			int index = 0;
			for(int k = 0 ; k < 10 ; k ++){
				for(int  j = 0 ; j < queue.get(k).size() ; j ++){
					numberArray[index++] = (Integer) queue.get(k).get(j);
				}
				queue.get(k).clear();
			}
			for(int j = 0 ; j < numberArray.length ; j ++){
				System.out.print(numberArray[j]+" ");
			}
			System.out.println();
		}
		
		
		
	}
}

  