package testP;

import java.util.Random;
import java.util.Scanner;

public class num_color_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Hさん課題

		Scanner scan =new Scanner(System.in);
		Random ran1 =new Random();	//色用ランダム
		Random ran2 =new Random();	//番号用ランダム
		
		int points=1000;	//持ち点
		String[] color= {"赤","白","黒"};		
		
		
		while(!(points<=0 || points>=5000)) {
			System.out.println("色の予想は、赤：０　白：１　黒：２　で入力してね");
			int mycolor=scan.nextInt(3); //自分の色予想（赤or白or黒）
			System.out.println("番号の予想は１〜１０で入力してね");
			int mynum=scan.nextInt(); //自分の番号予想（１〜１０）
			int rancol=ran1.nextInt(3);	//色（ランダム）
			int rannum=ran2.nextInt(10)+1; //番号１〜１０（ランダム）
			
			System.out.println("ランダム結果！"+color[rancol]+"色の"+ rannum+"番です");
			
			if(mycolor==rancol && mynum==rannum) {
				System.out.println("両方当たり！＋５０００pt");
				points += 5000;		
			}else if(mynum==rannum) {
				System.out.println("数字的中！＋１００pt");
				System.out.println("色はハズレ。−５０pt");
				points += 50;	
			}else if(mycolor==rancol) {
				System.out.println("色的中！＋５０pt");
				System.out.println("数字はハズレ。ー１００pt");
				points -= 50;
			}else {
				System.out.println("両方ハズレ。。。−１５０pt");
				points -= 150;
			}
			
			System.out.println("あなたのポイントは"+points+"ptです！");
		}
		System.out.println("ゲームを終了します");
 }
}