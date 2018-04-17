package specialpeople;


import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class yunxing {
	
	public static void main(String[] args) {
		//创建文件
		File file = new File("d:/jxl_test.xls");
		ArrayList<Integer> time=new ArrayList<>();//创建数组
		ArrayList<Integer> peoplenum=new ArrayList<>();
		Draw draw=new Draw();
		Date date=new Date();
		Run run=new Run();
		int peonum=(int)(date.f+date.g);//all peonum
		int sum=0;//cishu 
		int dx=(int)(Math.random()*date.m);
		int dy=(int)(Math.random()*date.n);
		Kind k[][]=draw.creatPeople();
		ArrayList <Kind>AL=new ArrayList();
		for (int i=0;i<date.m;i++){
			for(int j=0;j<date.m;j++){
				AL.add(k[i][j]);
			}
		}
		draw.onColor(k);

		int d=2;
		int dd=2;
		boolean flag=true;
		while(flag){
			for(int z=0;z<AL.size();z++){
				int i=AL.get(z).getX();
				int j=AL.get(z).getY();
				if(k[i][j].getLogo()==date.Loge_people){
					if(k[i][j].getType()){
						d=run.young(k, i, j);
//						run.pengzhuangjiance(k, i, j, d);//jiancha
						dd=run.nextmove(k, i, j, d);
					}
					else{
						d=run.old(k, i, j);
//						run.pengzhuangjiance(k, i, j, d);//jiancha
						dd=run.nextmove(k, i, j, d);
					}
   					run.move(k, i, j, dd);//移动
					run.moveArray(AL, z, i, j, dd);
				}
			}

			for(int i=0;i<date.m;i++){//to door
				for(int j=0;j<date.n;j++){
					if(i==date.CX&j==date.CY){
						if(k[i][j].logo==date.Loge_people){
							k[i][j]=new Kind();//qingkong
							k[date.CX][date.CY].logo=date.Loge_exit;//again draw door
							peonum--;// peonum-1
						}
					}
					if(i==date.CX&j==date.CY1){
						if(k[i][j].logo==date.Loge_people){
							k[i][j]=new Kind();//qingkong
							k[date.CX][date.CY1].logo=date.Loge_exit;//again draw door
							peonum--;// peonum-1
						}
					}
					if(i==date.CX&j==date.CY2){
						if(k[i][j].logo==date.Loge_people){
							k[i][j]=new Kind();//qingkong
							k[date.CX][date.CY2].logo=date.Loge_exit;//again draw door
							peonum--;// peonum-1
						}
					}
				}
			}
		
			draw.onColor(k);
			sum++;// cishu +1
			time.add(sum);//放入 time num 数组
			peoplenum.add(peonum);
			
//			
			String[] title={"time","peonum"};

			try {
				file.createNewFile();
				//创建工作簿
				WritableWorkbook workbook = Workbook.createWorkbook(file);
				//sheet
				WritableSheet sheet = workbook.createSheet("sheet1", 0);
				Label label = null;
//				//列名
				for (int i = 0; i < title.length; i++){
					label = new Label(i,0,title[i]);//1列1行 2列1行
					sheet.addCell(label);
				}
				//追加数据
				for(int i=1;i<time.size();i++){
					sheet.addCell(new Label(0,i,Integer.toString(time.get(i))));//1列 2-1001 行 time
					sheet.addCell(new Label(1,i,Integer.toString(peoplenum.get(i))));//2列 2-1001 行  peonum
				}
				workbook.write();
				workbook.close();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			

			
//			try {
//
//	             Thread.sleep(1000);
//
//	         } catch (Exception e) {
//
//	             e.printStackTrace();
//	         }
			System.out.println("第"+sum+"次"+"剩余人数"+peonum);
			if(peonum==0){
				flag=false;
			}
		}
		System.exit(0);
	}
}
