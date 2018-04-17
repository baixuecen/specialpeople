package specialpeople;

import java.util.ArrayList;

import jdk.nashorn.internal.ir.Block;

public class Run {
	Date date=new Date();
	
//	public Kind[][] peoMove1(Kind k[][]){
//		for(int i=1;i<date.m-1;i++){
//			for(int j=1;j<date.n-1;j++){
//				if(k[i][j].getLogo()==1){
//					if(k[i][j].getType()){
//						
//					}
//					else{
//						
//					}
//				}
//			}
//		}
//		return k;
//	}


	public int pengzhuangjiance(Kind k[][],int i,int j,int d){//碰撞检测
//		boolean pzjc=false;//如果下一点不能行动，返回TRUE
		int x=0;
		int y=0;
		switch (d) {
		case 1:
			x=i-1;
			y=j-1;
			break;
		case 2:
			x=i-1;
			y=j;
			break;
		case 3:
			x=i-1;
			y=j+1;
			break;
		case 4:
			x=i;
			y=j-1;
			break;
		case 5:
			x=i;
			y=j;
			break;
		case 6:
			x=i;
			y=j+1;
			break;
		default:
			break;
		}
		if(k[x][y].logo==date.Loge_people){
			d=5;
		}
		else if(k[x][y].logo==date.Loge_wall){
			d=5;
		}
		else if(k[x][y].logo==date.Loge_exit){
			d=2;
		}
		else{
			
		}
 		return d;
	}
//	public int young(Kind k[][],int i,int j){//最终方向
//		int d=1;
//		int h=0;
//		boolean flag=false;
//		if(flag){//墙，人，出口
//			d=5;//原地不动
//		}
//		else if(i==1&&j==1){//四个角
//			d=6;
//		}
//		else if(i==1&&j==date.n-2){
//			d=4;
//		}
//		else if((i==date.m-2&&j==1)||(i==date.m-2&&j==date.n-2)){
//			d=2;
//		}
//		else if((i>1&&i<date.m-2)&&(j==1||j==date.n-2)){//四个墙
//			d=2;
//		}
//		else if(i==1&&(j>1&&j<date.n/2)){
//			d=6;//
//		}
//		else if(i==1&&(j>date.n/2&&j<date.n-2)){
//			d=4;
//		}
//		else if(i==date.m-2&&(j>1&&j<date.n/2)){
//			d=4;
//		}
//		else if(i==date.m-2&&(j>date.n/2&&j<date.n-2)){
//			d=6;//
//		}
//		else if(i==1&&j==date.n/2){//door
//			d=2;
//		}
//		else{//空地
//			d=(int)(1+Math.random()*5);
//		}
//		return d;
//	}
	
	public int young(Kind k[][],int i,int j){
  		int d=5;
		int h=0;
//		boolean flag=true;
//		if(flag==true){//墙，人，出口
//			d=5;//原地不动
//		}
		if(i>0&&i<date.m-1&&j==10){//zhong
			if(i==1&&j==10){//door
				d=2;
			}
			else if(i==2&&j==10){
				d=2;
			}
			else{//other
				h=(int)(Math.random()*2);//0-2random
				if(h-1<0){//1.2.3 move 1/3
					d=1;
				}
				else if(h-1>0){
					d=2;
				}
				else{
					d=3;
				}
			}			
		}
		else if(i==1&&(j>0&&j<date.n/2)){//zuo wall
			if(i==1&&j==date.n/2-1){//door
				d=2;
			}
			else{
				d=6;
			}	
		}
		else if((i>1&&i<date.m-1)&&(j>0&&j<date.n/2)){//zuo
			h=(int)(Math.random()*3);//0-3random
			if(h-2<0){//2 move 2/4 3.6 move 1/4
				d=2;
			}
			else if(h-2>0){
				d=3;
			}
			else{
				d=6;
			}
		}
		else if(i==1&&(j>date.n/2&&j<date.n-1)){//you wall
			if(i==1&&j==date.n/2+1){//door
				d=2;
			}
			else{
				d=4;
			}
		}
		else if((i>1&&i<date.m-1)&&(j>date.n/2&&j<date.n-1)){//you
			h=(int)(Math.random()*3);//0-3random
			if(h-2<0){//2 move 2/4 1.4 move 1/4
				d=2;
			}
			else if(h-2>0){
				d=1;
			}
			else{
				d=4;
			}
		}
		return d;//young
	}
	
	public int old(Kind k[][],int i,int j){
		int d=0;
		int h=0;
//		boolean flag=false;
//		if(flag==true){//墙，人，出口
//			d=5;//原地不动
//		}
	    if(i>0&&i<date.m-1&&j==10){//zhong
			int a=0;
			if(k[i][j].getSpeed()<1){//speed 0
				a=a+1;//1
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<2){//speed 1
				a=a+2;//2
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<3){//speed 2
				a=a+3;
				k[i][j].setSpeed(a);
				d=5;
			}
			else{// move
				d=2;
				a=1;//1
				k[i][j].setSpeed(a);
			}
		}
		else if(i==1&&(j>0&&j<date.n/2)){//zuo wall
			int a=0;
			if(k[i][j].getSpeed()<1){//speed 0
				a=a+1;//1
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<2){//speed 1
				a=a+2;//2
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<3){//speed 2
				a=a+3;
				k[i][j].setSpeed(a);
				d=5;
			}
			else{//move
				if(i==1&&j==date.n/2-1){//door
					d=2;
					a=1;
					k[i][j].setSpeed(a);
				}
				else{
					d=6;
					a=1;//1
					k[i][j].setSpeed(a);
				}	
			}
		}
		else if((i>1&&i<date.m-1)&&(j>0&&j<date.n/2)){//zuo
			int a=0;
			if(k[i][j].getSpeed()<1){
				a=a+1;//1
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<2){
				a=a+2;//2
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<3){
				a=a+3;
				k[i][j].setSpeed(a);
				d=5;
			}
			else{
				h=(int)(Math.random()*2);//0-2random
				if(h-0.5<0){//2 move 1/3 6 move 2/3
					d=2;
				}
				else{
					d=6;
				}
				a=1;//1
				k[i][j].setSpeed(a);
			}	
		}
		else if(i==1&&(j>date.n/2&&j<date.n-1)){//you wall
			int a=0;
			if(k[i][j].getSpeed()<1){
				a=a+1;//1
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<2){
				a=a+2;//2
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<3){
				a=a+3;
				k[i][j].setSpeed(a);
				d=5;
			}
			else{
				if(i==1&&j==date.n/2+1){//door
					d=2;
					a=1;
					k[i][j].setSpeed(a);
				}
				else{
					d=4;
					a=1;//1
					k[i][j].setSpeed(a);
				}	
			}
		}
		else if((i>1&&i<date.m-1)&&(j>date.n/2&&j<date.n-1)){//you
			int a=0;
			if(k[i][j].getSpeed()<1){
				a=a+1;//1
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<2){
				a=a+2;//2
				k[i][j].setSpeed(a);
				d=5;
			}
			else if(k[i][j].getSpeed()<3){
				a=a+3;
				k[i][j].setSpeed(a);
				d=5;
			}
			else{
				h=(int)(Math.random()*2);//0-2randm
				if(h-0.5<0){//2 move 1/3 4 move 2/3
					d=2;
				}
				else{
					d=4;
				}
				a=1;//1
				k[i][j].setSpeed(a);
			}			
		}
		return d;
	}
	
	public int nextmove(Kind k[][],int i,int j,int d){
		int dd=0;
//		boolean pzjc=true;
		dd=pengzhuangjiance(k,i,j,d);
		return dd;
	}
		

	
	
	
//	public int old(Kind k[][],int i,int j){
//		int d=2;
//		int h=0;
//		boolean flag=false;
//		if(flag){//墙，人，出口
//			d=5;//原地不动
//		}
//		else if(i==1&&j==1){//四个角
//			d=6;
//		}
//		else if(i==1&&j==date.n-2){
//			d=4;
//		}
//		else if((i==date.m-2&&j==1)||(i==date.m-2&&j==date.n-2)){
//			d=2;
//		}
//		else if((i>1&&i<date.m-2)&&(j==1||j==date.n-2)){//四个墙
//			d=2;
//		}
//		else if(i==1&&(j>1&&j<date.n/2)){
//			d=6;//
//		}
//		else if(i==1&&(j>date.n/2&&j<date.n-2)){
//			d=4;
//		}
//		else if(i==date.m-2&&(j>1&&j<date.n/2)){
//			d=4;
//		}
//		else if(i==date.m-2&&(j>date.n/2&&j<date.n-2)){
//			d=6;//
//		}
//		else if(i==1&&j==date.n/2){//door 
//			d=2;
//		}
//		else{//空地
//			h=(int)(1+Math.random()*5);//1-6随机数
//			if(h==2||h==4||h==6){
//				d=h;
//			}
//			else{
//				d=2;
//			}
//		}
//		return d;
//	}
	
	
//	public void move(Kind k[][],int i,int j,int d){
//		switch (d) {
//		case 2:
//			if(k[i][j].getType()){
//				k[i-1][j]=k[i][j];
//				k[i][j]=new Kind();
//			}
//			else{
//				int a=0;
//				if(k[i][j].getSpeed()<3){
//					a=a++;
//					k[i][j].setSpeed(a);
//				}
//				else{
//					k[i-1][j]=k[i][j];
//					k[i][j]=new Kind();
//					a=0;
//					k[i][j].setSpeed(a);
//				}
//			}
//			break;
//		case 4:
//			if(k[i][j].getType()){
//				k[i][j-1]=k[i][j];
//				k[i][j]=new Kind();
//			}
//			else{
//				int a=0;
//				if(k[i][j].getSpeed()<3){
//					a=a++;
//					k[i][j].setSpeed(a);
//				}
//				else{
//					k[i][j-1]=k[i][j];
//					k[i][j]=new Kind();
//					a=0;
//					k[i][j].setSpeed(a);
//				}
//			}
//			break;
//		case 6:
//			if(k[i][j].getType()){
//				k[i][j+1]=k[i][j];
//				k[i][j]=new Kind();
//			}
//			else{
//				int a=0;
//				if(k[i][j].getSpeed()<3){
//					a=a++;
//					k[i][j].setSpeed(a);
//				}
//				else{
//					k[i][j+1]=k[i][j];
//					k[i][j]=new Kind();
//					a=0;
//					k[i][j].setSpeed(a);
//				}
//			}
//			break;
//		case 1:
//			k[i-1][j-1]=k[i][j];
//			k[i][j]=new Kind();
//			break;
//		case 3:
//			k[i-1][j+1]=k[i][j];
//			k[i][j]=new Kind();
//			break;
//		default:
//			break;
//		}
//	}
	public void move(Kind k[][],int i,int j,int dd){
      	if(k[i][j].getType()){
      		switch (dd){
			case 1:
				k[i-1][j-1]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 2:
				k[i-1][j]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 3:
				k[i-1][j+1]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 4:
				k[i][j-1]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 6:
				k[i][j+1]=k[i][j];//
				k[i][j]=new Kind();
				break;
				default:
					break;
			}     				
		}
		else{
			switch (dd){
			case 2:
				k[i-1][j]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 4:
				k[i][j-1]=k[i][j];//
				k[i][j]=new Kind();
				break;
			case 6:
				k[i][j+1]=k[i][j];//
				k[i][j]=new Kind();
				break;
				default:
					break;
			}
		} 	
	}
	public void moveArray(ArrayList<Kind> AL,int z,int i,int j,int dd){
		switch(dd) {
//		case 0:
//			AL.get(z).setX(i);
//			AL.get(z).setY(j+1);
//			break;
		case 2:
			AL.get(z).setX(i-1);
			AL.get(z).setY(j);
			break;
		case 4:
			AL.get(z).setX(i);
			AL.get(z).setY(j-1);
			break;
		case 6:
			AL.get(z).setX(i);
			AL.get(z).setY(j+1);
			break;
		case 1:
			AL.get(z).setX(i-1);
			AL.get(z).setY(j-1);
			break;
		case 3:
			AL.get(z).setX(i-1);
			AL.get(z).setY(j+1);
			break;	
		}
	}
	public boolean chukou(Kind k[][],int i,int j){
		boolean flag=false;
		if(k[i][j].getLogo()==date.Loge_exit){
			flag=true;
		}
		return flag;
	}
//	public int teshu(Kind k1[][],int i,int j){//特殊情况下
//		int d=1;
//		if(i==1&&j==1){//四个角
//			d=6;
//		}
//		else if(i==1&&j==date.n-1){
//			d=4;
//		}
//		else if((i==date.m-1&&j==1)||(i==date.m-1&&j==date.n-1)){
//			d=2;
//		}
//		else if(j==1||j==date.n-1){//四个墙
//			d=2;
//		}
//		else if(i==1&&(j>0&&j<date.n/2)){
//			d=6;
//		}
//		else if(i==1&&(j>date.n/2&&j<date.m)){
//			d=4;
//		}
//		else if(i==date.m-1&&(j>0&&j<date.n/2)){
//			d=4;
//		}
//		else if(i==date.m-1&&(j>date.n/2&&j<date.m)){
//			d=6;
//		}
//		else{//空地
//			d=(int)(Math.random()*6);
//		}
//		return d;
//	}
}
