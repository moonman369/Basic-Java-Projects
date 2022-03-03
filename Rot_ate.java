package basics;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rot_ate {

	public static String rotate(String s, char d, int r) {
		int l = s.length();
		String copy = s;
		if (r <= l) {
			if (d == 'a' || d == 'A') {
				copy = copy.substring(r) + copy.substring(0, r);
			} else if (d == 'c' || d == 'C') {
				copy = copy.substring(l - r) + copy.substring(0, l - r);
			}
		}
		return copy;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string");
		String s = sc.nextLine();
		int len = s.length();
		int i, j;
		if (len >= 1 && len <= 30) {
			System.out.print("Enter the number rotaions to be performed: ");
			int q = sc.nextInt();
			sc.nextLine();
			if (q >= 1 && q <= 10) {
				char[] d = new char[q];
				int[] r = new int[q];
				System.out.println(
						"Enter the direction(C: Clockwise && A: Anticlockwise) and magnitude(lesser than the length of the string)  of rotations separated by one space: ");
				for (i = 0; i < q; i++) {
					String dm = sc.nextLine();
					String[] dma = dm.split(" ");
					d[i] = dma[0].charAt(0);
					r[i] = Integer.parseInt(dma[1]);
				}
				String copy = s;
				String acc = "";
				for (i = 0; i < q; i++) {
					copy = rotate(copy, d[i], r[i]);
					acc += copy.charAt(0);
				}
				char[] total = copy.toCharArray();
				char[] first = acc.toCharArray();
				Arrays.sort(total);
				Arrays.sort(first);
				copy = Arrays.toString(total);
				acc = Arrays.toString(first);
				boolean anagram = copy.contains(acc);
				if (anagram == true) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				System.out.println("The number of rotations should be in the range 1 to 10");
			}
		} else {
			System.out.println("The string should be of length in the range 1 to 30");
		}
	}
}
