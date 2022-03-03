package basics;

import java.util.Arrays;
import java.util.Scanner;

public class ObstacleGame {
	
//	static boolean isArenaValid(String[][]s) {
//		int l = s.length,count = 0;
//		boolean validity = true;
//		outer: for(int i=1; i<l-1;i++) {
//			for(int j=1;j<l-1;j++) {
//				if(s[i][j].equalsIgnoreCase("w") || s[i][j].equalsIgnoreCase("a") || s[i][j].equalsIgnoreCase("s") || s[i][j].equalsIgnoreCase("r") || s[i][j].equalsIgnoreCase("t") || s[i][j].equalsIgnoreCase("m") || s[i][j].equalsIgnoreCase("d") || s[i][j].equalsIgnoreCase("l")) {
////					if(s[i][j].equalsIgnoreCase("a")) {
////						count++;
////					}
//				}
//				else {
//					validity = false;
//					break outer;
//				}
//			}
//		}
////		if(count>1) {
////			validity = false;
////		}
//		return validity;
//	}
	
	static String arrangeObstacles(String s) {
		char[] srt = s.toCharArray();
		Arrays.sort(srt);
		String fin = new String(srt);
		return fin;
	}
	
	static String findObstacles(String[][] s, int x,int y) {
		String obs = "";
		for(int i=x-1;i<=x+1;i++) {
			for(int j=y-1;j<=y+1;j++) {
				if(!s[i][j].equalsIgnoreCase("r") && !s[i][j].equalsIgnoreCase("m") && !s[i][j].equalsIgnoreCase("a") && !s[i][j].equalsIgnoreCase(" ")) {
					obs += s[i][j];
				}
			}
		}
		return obs;
	}
	
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the arena: ");
		int n = sc.nextInt();
		if(n>=2 && n<=10) {
			sc.nextLine();
			int i,j;
			String[][] ar = new String[n+2][n+2];
			for(i=0;i<n+2;i++) {
				for(j=0;j<n+2;j++) {
					ar[i][j] = " ";
				}
			}
			System.out.println("Enter the elements in the arena in a row by row fashion each element being separated by a single space: ");
			for(i=1;i<=n;i++) {
				String s = sc.nextLine();
				String sa[] = s.split(" ");
				for(j=0;j<n;j++) {
					ar[i][j+1] = sa[j];
				}
			}
			System.out.println(ar.length);
				for(i=1;i<=n;i++) {
					String obs = "";
					for(j=1;j<=n;j++) {
						if(ar[i][j].equalsIgnoreCase("r")) {
							obs = findObstacles(ar,i,j);
							obs = arrangeObstacles(obs);
							System.out.println(obs);
						}
					}
				}
				
		}
		else {
			System.out.println("The size of the arena must be in the range 2 to 10.");
		}
	}
}
