
package com.test.dynamics.test.dynamaicprograming;

import java.util.Scanner;
public class DynamicProgramingForDiggingGold {

	static int [] neededPeople = new int [100];							//用来记录金矿需要多少人挖
	static int [] goldCanBeCollected = new int [100];					//用来记录金矿可以挖出多少金子
	static int [][] recordForPerOREAndPeople = new int [1001][100];		//记录金矿是否已经挖过(-1为未曾挖过)
	static int numberOfTotalPeople;										//总人数
	static int numberOfORE;												//金矿数
	static Scanner sc = new Scanner(System.in);
	static void init(){
		
		numberOfTotalPeople = sc.nextInt();
		numberOfORE = sc.nextInt();
		for(int i = 0 ; i < numberOfORE ; i ++){
			neededPeople[i]=0;
			goldCanBeCollected[i]=0;
		}
		for(int i = 0 ; i <=numberOfTotalPeople ; i ++){
			for(int j = 0 ; j < numberOfORE ; j ++){
				recordForPerOREAndPeople[i][j]=-1;
			}
		}
		int i = 0;
		while(i<numberOfORE){
			neededPeople[i]=sc.nextInt();
			goldCanBeCollected[i]=sc.nextInt();
			i++;
		} 
	}
	public static void main(String [] args){
		while(sc.hasNext()){
			init();
			System.out.println(getMaxGoldFromORE(numberOfTotalPeople,numberOfORE-1));
		}
	}
	
	static int getMaxGoldFromORE(int numberOfTotalPeople,int numberOfORE){
		
		int maxGoldNumber = 0;
		if(recordForPerOREAndPeople[numberOfTotalPeople][numberOfORE] !=-1){
			//若本次挖矿方案已经实施过，则记录下来，下次直接使用
			maxGoldNumber = recordForPerOREAndPeople[numberOfTotalPeople][numberOfORE];
		}else if(numberOfORE==0){
			if(numberOfTotalPeople>=neededPeople[numberOfORE]){
				//剩余人数足够挖矿，则本次挖到goldCanBeCollected[numberOfORE]
				maxGoldNumber =  goldCanBeCollected[numberOfORE];
			}else{
				//剩余人数不足以挖矿，则本次挖到0
				maxGoldNumber = 0;
			}
		}else{
			if(numberOfTotalPeople>=neededPeople[numberOfORE]){
				//如果剩余人数 比 本金矿需要的人多则 比较 挖本金矿与不挖本金矿可以获得的金子数，将大的作为方案实施
				maxGoldNumber = max(getMaxGoldFromORE(numberOfTotalPeople-neededPeople[numberOfORE],numberOfORE-1)+goldCanBeCollected[numberOfORE],getMaxGoldFromORE(numberOfTotalPeople,numberOfORE-1));
			}else{
				//否则 ，人数不足以挖本金矿，剩余人挖剩下numberOfORE-1 金矿
				maxGoldNumber = getMaxGoldFromORE(numberOfTotalPeople,numberOfORE-1);
			}
		}
		//记录本次挖矿
		recordForPerOREAndPeople[numberOfTotalPeople][numberOfORE] = maxGoldNumber;
		return maxGoldNumber;
	}
	static int max(int a , int b){
		return a>=b?a:b;
	}
}

  