package group3;

public class ExArray {
	public static void main(String[] args) {
		int[][] a = { 
		// 1번, a의 값으로 2차배열을 넣었으니 2차배열형을 주어야 한다.
				{ 90, 85, 95 }, // 0번째 행에 대한 초기화
				{ 95, 75, 95 }, // 1번째 행에 대한 초기화
				{ 90, 80, 70 }, // 2번째 행에 대한 초기화
				{ 80, 90, 60 }, // 3번째 행에 대한 초기화
				{ 95, 65, 80 }  // 4번째 행에 대한 초기화
		};
		int r, c;

		for (r = 0; r < a.length; r++) {
			// 2번, 행에 대한 반복문이므로 a의 첫번째의 길이만큼 반복조건을 준다.
			for (c = 0; c < a[r].length; c++)
				// 3번, 열에 대한 반복문이므로  a의 [r]번째의 길이만큼 반복조건을 준다.
				System.out.print(" \t" + (a[r][c]));
				// 4번, 배열의 값을 출력하는 기능이며 배열 변수를 넣어준다.
			System.out.println();
		}
	}
}
