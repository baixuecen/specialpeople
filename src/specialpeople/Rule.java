package specialpeople;

import java.util.Arrays;

public class Rule {
	Date date=new Date();
	public int calRange(int i,int j,int m,int n,int R){
		//�жϷ���ķ���
		//�����㡾i����j��������ǽ�ľ��� �������� ʹ��sort������������
		//�����жϾ�����ڳ���
		//��ν�������Сֵ�ֱ���4��ֵ�Ƚ� �õ�����
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
		//����ǽ��ʱ �ж������սǵķ���
		int f=0;{//�������
			if (i==1){//���������������
				if(j==1){//����������
					f=6;//��������
				}
			}else if(j==date.n-2){//��������ұ�
				f=4;
			}
			else{
				if(j>date.n/2){//������Ұ벿
					f=4;
				}
				else{//����
					f=6;
				}
			}
		}
		if(i==date.m-2){//������
			if(j==1){//�����
				f=2;
			}
			else if(j==date.n-2){//���ұ�
				f=2;
			}
			else{
				if(j>date.m/2){//�Ұ벿��
					f=6;
				}
				else {//��߲���
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
		//�ж�ǽ
		int fr=0;
		if(i==1||j==1||i==date.m-2||j==date.n-2){
			fr=2;
		}
		return fr;
	}
	public boolean exitDose(int a[][],int i,int j){
		//�ж��Ƿ񵽴���� ����ǳ��ڣ�flag ��Ϊture
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
