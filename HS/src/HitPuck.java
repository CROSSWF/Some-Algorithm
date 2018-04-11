import java.util.Scanner;

public class HitPuck {
	private static Scanner scanner;

	public static void main(String arg[]) {
		scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		System.out.println(HitPuck.hit(new double[31][8][8], M, N, 0));
	}

	public static double hit(double a[][][], int M, int N, int K) {

		double m = 1 + N + K;
		if (N == 0 && K == 0) {
			return 1;
		} else if (M == 0) {
			return 0;
		} else if (N == 0) {
			if (a[M][N][K] != 0)
				return a[M][N][K];
			a[M][N][K] = (double) K / m * hit(a, M - 1, N, K - 1) + 1 / m * hit(a, M - 1, N, K);
			return a[M][N][K];
		} else if (K == 0) {
			if (a[M][N][K] != 0)
				return a[M][N][K];

			a[M][N][K] = (double) N / m * hit(a, M - 1, N - 1, K + 1) + 1 / m * hit(a, M - 1, N, K);
			return a[M][N][K];
		}
		if (a[M][N][K] != 0)
			return a[M][N][K];
		a[M][N][K] = (double) N / m * hit(a, M - 1, N - 1, K + 1) + (double) K / m * hit(a, M - 1, N, K - 1)
				+ 1 / m * hit(a, M - 1, N, K);
		return a[M][N][K];
	}
}
