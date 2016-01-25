
    package com.test.dynamics.test.dynamaicprograming;

import java.util.Scanner;
    public class DynamicProgramingForBag {
    	static int [] articalWeight = new int [100];								//物品重量
    	static int [] articalValue = new int [100];									//物品价值
    	static int [][] recordForPerArticalAndVolume = new int [1001][100];			//记录物品是否考虑过(-1为未曾考虑过)
    	static int wholeVolumeOfBag;												//背包容量
    	static int numberOfArtical;													//物品数
    	static Scanner sc = new Scanner(System.in);
    	static void init(){
    		
    		wholeVolumeOfBag = sc.nextInt();
    		numberOfArtical = sc.nextInt();
    		for(int i = 0 ; i < numberOfArtical ; i ++){
    			articalWeight[i]=0;
    			articalValue[i]=0;
    		}
    		for(int i = 0 ; i <=wholeVolumeOfBag ; i ++){
    			for(int j = 0 ; j < numberOfArtical ; j ++){
    				recordForPerArticalAndVolume[i][j]=-1;
    			}
    		}
    		int i = 0;
    		while(i<numberOfArtical){
    			articalWeight[i]=sc.nextInt();
    			articalValue[i]=sc.nextInt();
    			i++;
    		} 
    	}
    	public static void main(String [] args){
    		while(sc.hasNext()){
    			init();
    			System.out.println(getMaxValueFromArtical(wholeVolumeOfBag,numberOfArtical-1));
    			for(int i = 0 ; i <=wholeVolumeOfBag ; i ++){
        			for(int j = 0 ; j < numberOfArtical ; j ++){
        				if(recordForPerArticalAndVolume[i][j] != -1 && recordForPerArticalAndVolume[i][j] !=0){
        					System.out.println(articalWeight[j]+":"+articalValue[j]);
        				}
        			}
        		}
    		}
    	}
    	
    	private static int getMaxValueFromArtical(int remainVolumeNumber,int remainArticalNumber){
    		
    		int maxValue = 0;
    		if(recordForPerArticalAndVolume[remainVolumeNumber][remainArticalNumber]!=-1){
    			maxValue += recordForPerArticalAndVolume[remainVolumeNumber][remainArticalNumber];
    		}else{
    			if(remainArticalNumber == 0){
    				if(remainVolumeNumber >= articalWeight[remainArticalNumber]){
    					maxValue = articalValue[remainArticalNumber];
    				}else{
    					maxValue = 0;
    				}
    			}else{
    				if(remainVolumeNumber >= articalWeight[remainArticalNumber]){
    					maxValue = max(articalValue[remainArticalNumber]+getMaxValueFromArtical(remainVolumeNumber - articalWeight[remainArticalNumber],remainArticalNumber-1),getMaxValueFromArtical(remainVolumeNumber,remainArticalNumber-1));
    				}else{
    					maxValue = getMaxValueFromArtical(remainVolumeNumber,remainArticalNumber-1);
    				}
    			}
    		}
    		recordForPerArticalAndVolume[remainVolumeNumber][remainArticalNumber] = maxValue;
    		return maxValue;
    	}
    	private static int max(int a , int b){
    		return a>=b?a:b;
    	}
}

  