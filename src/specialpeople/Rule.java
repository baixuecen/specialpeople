package specialpeople;

import java.util.Arrays;

public class Rule {
	Date date=new Date();
	public int calRange(int i,int j,int m,int n,int R){
		//判断方向的方法
		//将计算【i】【j】与四周墙的距离 存入数组 使用sort方法进行排序
		//首先判断距离出口长度
		//其次将数组最小值分别与4个值比较 得到方向
		int f=5;
		int north=i;
		int east=m-j;
		int south=m-i;
		int west=j;
		int ran[]=new int[4];
		ran[0]=north;
		ran[1]=east;
		ran[2]=south;
		ran[3]=west;
		Arrays.sort(ran);
			if(ran[0]==north){
				f=2;
			}
			else if(ran[0]==east){
				f=6;
			}
			else if(ran[0]==south){
				f=8;
			}
			else if(ran[0]==west){
				f=4;
			}
			return f;		
	}
	public int calRangeDouble(int i,int j){
		//沿着墙走时 判断遇到拐角的方法
		int f=0;{//输出方向
			if (i==1){//如果行人在最上面
				if(j==1){//如果在最左边
					f=6;//方向向右
				}
			}else if(j==date.n-2){//如果在最右边
				f=4;
			}
			else{
				if(j>date.n/2){//如果在右半部
					f=4;
				}
				else{//左半边
					f=6;
				}
			}
		}
		if(i==date.m-2){//最下面
			if(j==1){//最左边
				f=2;
			}
			else if(j==date.n-2){//最右边
				f=2;
			}
			else{
				if(j>date.m/2){//右半部分
					f=6;
				}
				else {//左边部分
					f=4;
				}
			}
		}
		if (j==1){
			if(i==1){
				f=6;
			}
			else{
				f=2;
			}
		}
		if(j==date.n-2){
			if(i==1){
				f=4;
			}
			else{
				f=2;
			}
		}
		return  f;
	}
	public int stopChange(int a[][],int i,int j){
		//判断墙
		int fr=0;
		if(i==1||j==1||i==date.m-2||j==date.n-2){
			fr=2;
		}
		return fr;
	}
	public boolean exitDose(int a[][],int i,int j){
		//判断是否到达出口 如果是出口，flag 改为ture
		boolean flag=false;
		int exitId=date.n/2;
		if(i==1){
			if(j==exitId){
				flag=true;
			}
			if(j==exitId+1){
				flag=true;
			}
			if(j==exitId-1){
				flag=true;
			}
		}
		return flag;
		
	}

}
