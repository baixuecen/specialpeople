package specialpeople;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw {
	//閿熸枻鎷峰浘
	int m=20;
	int n=20;
	int t=0;
	int u=0;
	JFrame jf;// 閿熸枻鎷峰閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	JPanel[][] jp;
	Date date=new Date();
	public Draw(){
		//閿熸枻鎷烽敓鏂ゆ嫹 閿熸枻鎷烽敓鏂ゆ嫹
		jf=new JFrame("specialpeople");
		jp=new JPanel[m][n];
		jf.setLayout(new GridLayout(m,n,0,0));//m n 5 5 閿熸枻鎷� m閿熸枻鎷� m閿熷彨纭锋嫹閿燂拷5閿熷彨纭锋嫹閿燂拷
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				jp[i][j]=new JPanel();
				jp[i][j].setBackground(Color.black);//閿熸枻鎷烽敓鐭唻鎷烽敓鏂ゆ嫹鑹�
				jf.add(jp[i][j]);//閿熸枻鎷穓p閿熸枻鎷锋嫢閿熺怠f
				
			}
		}
		jf.setSize(500,500); //閿熸枻鎷烽敓鑺傝揪鎷峰皬
		jf.setVisible(true);//閿熸枻鎷风ず閿熸枻鎷烽敓鏂ゆ嫹
		jf.addWindowListener(new WindowAdapter() {//閿熸埅闂府鎷烽挳閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void onColor(Kind k[][]){
		//閿熸枻鎷峰浘閿熸枻鎷烽敓鏂ゆ嫹
		for (int i=0;i<date.m;i++){
			for (int j=0;j<date.n;j++){
				switch(k [i][j].logo){//shezhi
				case 0: //kong  0
					jp[i][j].setBackground(Color.white);
					break;
				case 1: //people 1 
					if(k[i][j].getType()){
						jp[i][j].setBackground(Color.red);//young
					}
					else{
						jp[i][j].setBackground(Color.green);//old 
					}
					break;
				case 100: //wall  100
					jp[i][j].setBackground(Color.black);
					break;
				case 1000: //door  1000
					jp[i][j].setBackground(Color.white);
					break;
				default: //other  
					jp[i][j].setBackground(Color.black);				
				}
			}
		}
	}
	public Kind[][] creatPeople(){
		Kind k[][]=new Kind[date.m][date.n];//all
		for(int i=0;i<date.m;i++){
			for(int j=0;j<date.n;j++){
				k[i][j]=new Kind();
			}
		}
		for(int i=0;i<date.m;i++){
			for(int j=0;j<date.n;j++){
				k[0][j].logo=100;//0to19 wall
				k[i][0].logo=100;
				k[i][n-1].logo=100;
				k[m-1][j].logo=100;
			}
		}
		k[date.CX][date.CY].logo=1000;//door
		k[date.CX][date.CY1].logo=1000;
		k[date.CX][date.CY2].logo=1000;
		
		
		while(u<date.g){//old
			int a=4;
			int b=4;
			int dx=0;
			int dy=0;
			for(dx=a;dx<16;dx++){
				for(dy=b;dy<16;dy++){
					k[dx][dy]=new Kind();
					k[dx][dy].setX(dx);
					k[dx][dy].setY(dy);
					k[dx][dy].setLogo(1);
					k[dx][dy].setType(false);
					u++;
					if(u>date.g){
						break;
					}
				}
				if(u>date.g){
					break;
				}
			}
		}
		
		while(t<date.f){
			int dx=(int)(1+Math.random()*18);//1-18
			int dy=(int)(1+Math.random()*18);
//			k[dx][dy]=new Kind();
			k[dx][dy].setX(dx);
			k[dx][dy].setY(dy);
//			k[dx][dy].setLogo(1);
//			k[dx][dy].setType(true);//young
			if(k[dx][dy].logo==0){//if null
				k[dx][dy].setLogo(1);
				k[dx][dy].setType(true);//young
				t++;
			}
		}
		
//		while(u<date.g){
//			int dx=(int)(1+Math.random()*18);//1-18
//			int dy=(int)(1+Math.random()*18);
////			k[dx][dy]=new Kind();
//			k[dx][dy].setX(dx);
//			k[dx][dy].setY(dy);
////			k[dx][dy].setLogo(1);
////			k[dx][dy].setType(false);//old
//			if(k[dx][dy].logo==0){
//				k[dx][dy].setLogo(1);
//				k[dx][dy].setType(false);//old
//				u++;
//			}
//		}
		
		
		
		
		
		
//		k[18][18]=new Kind();
//		k[18][18].setX(18);
//		k[18][18].setY(18);
//		k[18][18].setLogo(1);
//		k[18][18].setType(true);
////		
//		k[8][7]=new Kind();
//		k[8][7].setX(8);
//		k[8][7].setY(7);
//		k[8][7].setLogo(1);
//		k[8][7].setType(false);
//////		
//		k[7][8]=new Kind();
//		k[7][8].setX(7);
//		k[7][8].setY(8);
//		k[7][8].setLogo(1);
//		k[7][8].setType(false);
////		
//		k[7][7]=new Kind();
//		k[7][7].setX(7);
//		k[7][7].setY(7);
//		k[7][7].setLogo(1);
//		k[7][7].setType(false);
////		
//		k[2][10]=new Kind();
//		k[2][10].setX(2);
//		k[2][10].setY(10);
//		k[2][10].setLogo(1);
//		k[2][10].setType(true);
		
//		k[1][18]=new Kind();
//		k[1][18].setX(1);
//		k[1][18].setY(18);
//		k[1][18].setLogo(1);
//		k[1][18].setType(false);
//		
//		k[18][1]=new Kind();
//		k[18][1].setX(18);
//		k[18][1].setY(1);
//		k[18][1].setLogo(1);
//		k[18][1].setType(false);
		
//		k[18][2]=new Kind();
//		k[18][2].setX(18);
//		k[18][2].setY(2);
//		k[18][2].setLogo(1);
//		k[18][2].setType(true);
		
//		k[8][10]=new Kind();
//		k[8][10].setX(8);
//		k[8][10].setY(10);
//		k[8][10].setLogo(1);
//		k[8][10].setType(true);
		return k;
	}
}
