package lab1;

import java.io.InputStream;
import java.util.Scanner;

public class Coin {
	int[] arr = {1,5,10,20,50};
	//int[] num = {3,2,1,1,1};
	static int[] takeout = new int[5];
	public static boolean findCoins(int sum) {
		if(sum > 93) {
			System.out.println("Cannot be found!");
			return false;
		}else {
			int x = sum % 10;//个位数
			if(x >= 5 && x<=8) {
				takeout[1] = 1;//5的个数
				takeout[0] = x-5;//1的个数
			}else if(x<=3) {
				takeout[1] = 0;
				takeout[0] = x;
			}else if(x ==4 || x==9) {
				System.out.println("Cannot be found!");
				return false;
			}
			int y = sum /10;//十位数
			if((y >=5 )&&(y<=9)) {
				takeout[4] = 1;//50的个数
				y = y-5;
				if(y == 4) {
					takeout[3] = 1;
					takeout[2] = 1;
					takeout[1] = 2;
				}else if(y==3) {
					takeout[3] = 1;
					takeout[2] = 1;
				}else if(y == 2) {
					takeout[3] = 1;
				}else if(y==1) {
					takeout[2] = 1;
				}
			}else {
				takeout[4] = 0;
				if(y == 4) {//两个5已经在十位的时候用了，只有40 41 42 43
					if( x !=0 && x !=1 && x !=2 && x !=3) {
						System.out.println("Cannot be found!");
						return false;
					}else {
						takeout[3] = 1;
						takeout[2] = 1;
						takeout[1] = 2;						
					}
				}else if(y==3) {
					takeout[3] = 1;
					takeout[2] = 1;
				}else if(y == 2) {
					takeout[3] = 1;
				}else if(y==1) {
					takeout[2] = 1;
				}
			}
			System.out.println("Use "+takeout[0] +"(1Yuan), "+ takeout[1]+"(5Yuan), " + takeout[2] + "(10Yuan), "
			+ takeout[3] + "(20Yuan), "+ takeout[4] + "(50Yuan)." );
			return true;
		}
	}
	public static void main(String[] arg) {
		System.out.print("The money you want: ");
		Scanner s = new Scanner(System.in);
		int sum = s.nextInt();
		Coin.findCoins(sum);
		//System.out.print("777");
	}
}
