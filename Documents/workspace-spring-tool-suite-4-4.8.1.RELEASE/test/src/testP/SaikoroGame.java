package testP;

import java.util.Random;
import java.util.Scanner;

public class SaikoroGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Hさん課題
		Scanner scan=new Scanner(System.in);
		Random ran =new Random();
		int mytotal=0;//自分のサイコロの目
		int comtotal=0;//相手のサイコロの目
		int mypoints=0;
		int compoints=0;
		int rensho=0;//連勝判定
	
	while(mypoints<5 && compoints<5) {
		System.out.println("自分の目が大きいと予想：０　　相手の目が大きいと予想：１");
		int yoso=scan.nextInt(2);//予想入力
		for(int i=0;i<2;i++) {
			int sai1=ran.nextInt(6)+1;
			int sai2=ran.nextInt(6)+1;
			System.out.println("私"+sai1+"　相手"+sai2);
			mytotal +=sai1;
			comtotal +=sai2;
			}
		System.out.println("私の合計"+mytotal+"　相手の合計"+comtotal);
		
		if((yoso==0 && mytotal>comtotal) || (yoso==1 && mytotal<comtotal)) {
			compoints--;//私勝ち＝CPU負け−１pt(この設定なくてもいい）
				if(rensho==1) {
					System.out.println("2回連続当たり！ポイント＋２！");
					rensho=0;
					mypoints+=2;
				}else {
					System.out.println("当たり");
					rensho=1;
					mypoints++;
				}
			mytotal=0;	//サイコロリセット
			comtotal=0;
		}else if(mytotal==comtotal) {
			System.out.println("ドローゲーム");
			mytotal=0;	//サイコロリセット
			comtotal=0;
			rensho=0;		//連勝記録リセット
		}
		else{
			System.out.println("ハズレ");
			compoints++;
			
				if(rensho==-1) {
					System.out.println("2回連続ハズレ・・・。−２ポイント");
					rensho=0;
					mypoints-=2;
				}else{
					rensho=-1;
					mypoints--;
				}
			mytotal=0;
			comtotal=0;
			}
		
		System.out.println("あなた："+mypoints+"ポイント"+"　　相手："+compoints+"ポイント");
	}
	if(mypoints>compoints) {
		System.out.println("あなたの勝ちです！");
	}else if(mypoints<compoints) {
		System.out.println("あなたの負けです…");
	}else {
		System.out.println("引き分けです");
	}
	
	}
}
