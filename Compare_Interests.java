package basics;

import java.util.Scanner;

public class Compare_Interests {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter principal amount: ");
		int p = sc.nextInt();
		if (p <= 1000000 && p >= 1) {
			System.out.println("Enter tenure in years: ");
			int t = sc.nextInt();
			if (t >= 1 && t <= 50) {
				// BANK A
				double int1 = 0.0;
				System.out.println("Enter number of slabs offered by Bank A:");
				int i;
				int n1 = sc.nextInt();
				sc.nextLine();
				int[] t1 = new int[n1];
				double[] r1 = new double[n1];
				if (n1 >= 1 && n1 <= 30) {
					System.out.println("Enter the tenures and interest rates separated by one space for each slab:");
					String[] slab = new String[n1];
					for (i = 0; i < n1; i++) {
						slab[i] = sc.nextLine();
						String[] slb = slab[i].split(" ");
						t1[i] = Integer.parseInt(slb[0]);
						r1[i] = Double.parseDouble(slb[1]);
					}

					double EMI = 0.0;
					for (i = 0; i < n1; i++) {// bank a
						double mr = r1[i] / 12.0;
						int mt = t1[i] * 12;
						double emi = p * (r1[i] / 12.0) / (1 - 1 / Math.pow((1 + mr), mt));
						EMI += emi;
					}
					int1 = EMI - p;

				} else {
					System.out.println("Number of slabs should be in the range 1 to 30");
				}

				// BANK B
				double int2 = 0.0;
				System.out.println("Enter number of slabs offered by Bank B:");
				int n2 = sc.nextInt();
				sc.nextLine();
				int[] t2 = new int[n2];
				double[] r2 = new double[n2];
				if (n2 >= 1 && n2 <= 30) {
					String[] slab = new String[n1];
					System.out.println("Enter the tenures and interest rates separated by one space for each slab:");
					for (i = 0; i < n2; i++) {
						slab[i] = sc.nextLine();
						String[] slb = slab[i].split(" ");
						t2[i] = Integer.parseInt(slb[0]);
						r2[i] = Double.parseDouble(slb[1]);
					}

					double EMI = 0.0;
					for (i = 0; i < n1; i++) {// bank a
						double mr = r1[i] / 12.0;
						int mt = t1[i] * 12;
						double emi = p * (r1[i] / 12.0) / (1 - 1 / Math.pow((1 + mr), mt));
						EMI += emi;
					}
					int2 = EMI - p;

				} else {
					System.out.println("Number of slabs should be in the range 1 to 30");
				}

				if (int1 < int2) {
					System.out.println("BANK A.");
				} else {
					System.out.println("BANK B.");
				}

			} else {
				System.out.println("Total tenure should be in the range 1 to 50 years");
			}
		} else {
			System.out.println("Principal amount should be in the range 1 to 1000000");
		}
	}
}
