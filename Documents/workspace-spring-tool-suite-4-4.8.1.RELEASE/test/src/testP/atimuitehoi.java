package testP;

import java.util.Random;
import java.util.Scanner;

public class atimuitehoi {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		//Uさん課題
	
		String[] jyanken = {"グー","チョキ","パー"};
		int mypoint=0;//獲得　得点
		int compoint=0;

		Random ran =new Random();
		Scanner ss = new Scanner(System.in);
	for(int i=1;i<=5;i++) {	
		boolean reJanken= true;	//あいこの時だけじゃんけん繰り返すための判定用
		boolean jankenWin=true;	//じゃんけんの勝ち負けによって、あっち向いてホイで勝った時のボーナスポイントをつける用
		
		System.out.println(i +"回目の勝負！！");
			while(true){
				System.out.println("出す手を決める。0:グー　1:チョキ　 2:パー");
				int myhand = ss.nextInt(3); //自分の手打ち込む
				int computer =ran.nextInt(3); //コンピュータの手
				int judge =myhand - computer; //勝利判定
				System.out.println("相手は" +jyanken[computer]+"です。");
			
				if((judge==-1)||(judge==2)) {
					System.out.println("あなたの勝ち");
					reJanken=false;
					mypoint++;	//じゃんけんで勝った時点で自分にポイント＋１
					break;
				}
				else if((judge==-2)||(judge==1)){
					System.out.println("あなたの負け");
					reJanken=false;
					jankenWin=false;
					compoint++;
					break;
				}
				else if(judge==0) {
					System.out.println("あいこです");
				}
			}
			String[] hoi = {"上","右","下","左"};
			int randmhoi=ran.nextInt(4);
			System.out.println("あっちむいてー"+"ー入力してくださいー　上：0　右：1　下：2　左：3");
			int myhoi=ss.nextInt(4);
			
			if(randmhoi==myhoi && jankenWin) {
				System.out.println("相手は"+hoi[randmhoi]+"! やったね！ボーナスポイントゲット！");
				mypoint++;		//じゃんけん勝利＆あっち向いてホイ勝利でボーナスポイント＋２
			}else if(!(randmhoi==myhoi) && jankenWin) {
				System.out.println("相手は"+hoi[randmhoi]+"。残念！ポイントボーナスなし！");	//じゃんけん勝ちだがあっち向いてホイ負け.変動なし
			}else if(randmhoi==myhoi && !jankenWin){
				System.out.println("相手は"+hoi[randmhoi]+"。相手はボーナスポイントゲット");		//両方ともゲームに負けているので０ポイント
				compoint++;
			}else {
				System.out.println("相手は"+hoi[randmhoi]+"!セーフ！相手はボーナスポイントなし");//じゃんけん負けだがあっち向いてホイはセーフ
			}
			System.out.println("あなたのポイント："+ mypoint + " 相手のポイント"+ compoint);
		}
	
	System.out.println("結果発表！あなたのポイントは…" + mypoint + "点でした！！");
	if(mypoint>compoint) {
		System.out.println("あなたの勝ち！！");
	}else if(mypoint<compoint) {
		System.out.println("あなたの負け・・・");
	}else {
		System.out.println("引き分けです");
	}
	
	}
}