
package com.test.dynamics.test.maze;

import java.util.Scanner;

public class GetWayFormMaze {
	
	static private int [][] mazeMap;			//迷宫图  0代表短路，1代表通路
	static private String [][] locationMap;		//记录位置
	static private int fromCol,fromRow;		//迷宫入口 fromCol入口列，fromRow入口行
	static private int toCol,toRow;			//迷宫出口 toCol出口列，toRow出口行
	static private int colNumber,rowNumber; 	//迷宫大小 colNumber列数，rowNumber行数
	static private String road="";
	static private String roadtmp="";
	
	static Scanner sc = new Scanner(System.in);
	
	//初始化
	static void initData(){
		System.out.println("请输入迷宫行数和列数，以空格隔开：");
		rowNumber=sc.nextInt();
		colNumber=sc.nextInt();
		mazeMap = new int [rowNumber+2][colNumber+2];
		locationMap = new String [rowNumber+2][colNumber+2];
		System.out.println("请输入迷宫：");
		for(int i = 1 ; i < rowNumber+1 ; i ++){
			for(int j = 1 ; j < colNumber+1 ; j ++){
				mazeMap[i][j] = sc.nextInt();
				locationMap[i][j] = "△";
			}
		}
		for(int i = 0 ; i < rowNumber+2 ; i ++){
			mazeMap[0][i]=0;
			mazeMap[rowNumber+1][i]=0;
			locationMap[0][i]="△";
			locationMap[rowNumber+1][i]="△";
		}
		for(int i = 0 ; i < colNumber+2 ; i ++){
			mazeMap[i][0]=0;
			mazeMap[i][colNumber+1]=0;
			locationMap[i][0]="△";
			locationMap[i][colNumber+1]="△";
		}
		System.out.println("请输入迷宫入口位置行和列，以空格隔开：");
		fromRow=sc.nextInt();
		fromCol=sc.nextInt();
		System.out.println("请输入迷宫出口位置行和列，以空格隔开：");
		toRow=sc.nextInt();
		toCol=sc.nextInt();
	}
	/**
	 * 
	 * <p>Discription:[查找路径]</p> 
	 *@param locationRow
	 *@param locationCol
	 */
	static void findWayFromMaze(int locationRow,int locationCol){
		
		road+=locationRow+","+locationCol+";";
		roadtmp+=locationRow+","+locationCol+";";
		locationMap[locationRow][locationCol]="☆";
		while(roadtmp!=null&&!"".equalsIgnoreCase(roadtmp)&&!(locationRow==toRow&&locationCol==toCol)){
			if(mazeMap[locationRow][locationCol+1]==1&&!road.contains(locationRow+","+(locationCol+1)+";")){
				locationCol+=1;
				locationMap[locationRow][locationCol]="☆";
				road+=locationRow+","+locationCol+";";
				roadtmp+=locationRow+","+locationCol+";";
			}else if(mazeMap[locationRow+1][locationCol]==1&&!road.contains((locationRow+1)+","+locationCol+";")){
				locationRow+=1;
				locationMap[locationRow][locationCol]="☆";
				road+=locationRow+","+locationCol+";";
				roadtmp+=locationRow+","+locationCol+";";
			}else if(mazeMap[locationRow][locationCol-1]==1&&!road.contains(locationRow+","+(locationCol-1)+";")){
				locationCol-=1;
				locationMap[locationRow][locationCol]="☆";
				road+=locationRow+","+locationCol+";";
				roadtmp+=locationRow+","+locationCol+";";
			}else if(mazeMap[locationRow-1][locationCol]==1&&!road.contains((locationRow-1)+","+locationCol+";")){
				locationRow-=1;
				locationMap[locationRow][locationCol]="☆";
				road+=locationRow+","+locationCol+";";
				roadtmp+=locationRow+","+locationCol+";";
			}else{
				locationMap[locationRow][locationCol]="△";
				roadtmp=roadtmp.replace(roadtmp.split(";")[roadtmp.split(";").length-1]+";", "");
				if("".equalsIgnoreCase(roadtmp)||roadtmp==null||" ".equalsIgnoreCase(roadtmp)){
					break;
				}
				locationRow = Integer.parseInt(roadtmp.split(";")[roadtmp.split(";").length-1].split(",")[0]);
				locationCol = Integer.parseInt(roadtmp.split(";")[roadtmp.split(";").length-1].split(",")[1]);
				road+=locationRow+","+locationCol+";";
			}
		}
		if("".equalsIgnoreCase(roadtmp)||roadtmp==null||" ".equalsIgnoreCase(roadtmp)){
			System.out.println("没有路径");
		}else{
			System.out.println(road);
			System.out.println(roadtmp);
			for(int i = 0 ; i < rowNumber+2 ; i ++){
				for(int j = 0 ; j < colNumber+2 ; j ++){
					System.out.print(locationMap[i][j]);
				}
				System.out.println();
			}
		}
	}
	public static void main(String [] args){
		initData();
		findWayFromMaze(fromRow,fromCol);
	}
}

  