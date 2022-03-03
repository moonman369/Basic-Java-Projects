package basics;

import java.util.Scanner;

public class Chakravyuha {

	public static boolean check_div(int x) {
		if (x % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Chakravyuha: ");
		int n = sc.nextInt();
		if (n <= 100) {
			int[][] chakra = new int[n][n];
			int size = n - 1;
			int counter = 1;
			int i, j, k;
//			for(i = 0;i<n;i++) {
//				chakra[i][j] = c++
//;			}
			for (i = 0; i < n / 2; i++) {
				j = i;
				k = i;
				for (j = j; j < size + i; j++) {// right
					chakra[k][j] = counter++;
				}
				for (k = k; k < size + i; k++) {// down
					chakra[k][j] = counter++;
				}
				for (j = j; j > i; j--) {// left
					chakra[k][j] = counter++;
				}
				for (k = k; k > i; k--) {// up
					chakra[k][j] = counter++;
				}
				size -= 2;
			}
			if (n % 2 != 0) {
				chakra[i][i] = counter;
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					System.out.print(chakra[i][j]);
				}
				System.out.println();
			}
			String[] str;
			;
			boolean check;
			int pp = ((n * n) / 11) + 1;
			System.out.println("Power points: " + pp + "\n(0,0)");
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {

					check = check_div(chakra[i][j]);
					if (check == true) {
						System.out.println("(" + i + "," + j + ")");
					}
				}
			}
		}
	}
}
