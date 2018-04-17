package specialpeople;

public class Date {
	//数据类

	int m=20; //房间长
	int n=20; //房间宽
	double p=0.7; //随机产生行人数量概率
	int all=(int)(19*19*p);
	
	double q=0.5;//老年人与年轻人比例
	int f=(int)(all*q);//young
	int g=(int)(all*(1-q));//old
	
//	int f=20;
//	int g=20;
		
	int h=100; //循环次数
	
	int Loge_people=1;//ren
	int Loge_wall=100;
	int Loge_exit=1000;

	int a[][]=new int [m][n]; //存储矩阵

	int b[][];

	int c[][];
	int k[][];

	int CX=0;//出口i坐标

	int CY=n/2;//出口j坐标
	
	int CY1=n/2+1;
	
	int CY2=n/2-1;

}
