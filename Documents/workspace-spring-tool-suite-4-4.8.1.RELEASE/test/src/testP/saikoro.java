package testP;

import java.util.Random;
import java.util.Scanner;

public class saikoro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//iさん課題
		
		Scanner scan=new Scanner(System.in);
		String name=scan.nextLine();
		
		System.out.println(name+"さんようこそ。ゲームを始めます");
		Random ran=new Random();
		int mytotal=0;
		int comtotal=0;
		
		while(mytotal!=20 && comtotal!=20) {
				int sai1=ran.nextInt(6)+1;
				int sai2=ran.nextInt(6)+1;
				int mysai=sai1+sai2;
				System.out.println("あなたの一つ目のサイコロ："+sai1+"二つ目のサイコロ："+sai2);
				mytotal += mysai;
				System.out.println("あなたの合計値："+mytotal);
				
				int sai3=ran.nextInt(6)+1;
				int sai4=ran.nextInt(6)+1;
				int comsai=sai3+sai4;
				System.out.println("相手の一つ目のサイコロ："+sai3+"二つ目のサイコロ："+sai4);
				comtotal+=comsai;
				System.out.println("相手の合計値："+comtotal);
				
				if(mytotal==20 && comtotal!=20) {
					System.out.println(name+"の勝ちです！");
					break;
				}else if(comtotal==20 && mytotal!=20){
					System.out.println("あなたの負けです");
					break;
				}else if(mytotal<20){
					System.out.println("もう一度サイコロを振れます");
					
						if(comtotal<20){
							System.out.println("相手はもう一度振ります");
						}else if(comtotal>20) {
							System.out.println("相手は振り出しです");
							comtotal=0;
						}
				}else if(mytotal>20) {
					System.out.println("振り出しです。");
					mytotal=0;
					
						if(comtotal<20){
							System.out.println("相手はもう一度振ります");
						}else if(comtotal>20) {
							System.out.println("相手は振り出しです");
							comtotal=0;
						}
			
				}
		}
	}
	}

