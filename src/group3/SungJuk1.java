package group3;

class SungJuk1 {

	private int[] mCalcu(int[][]score, int koreanTotal, int englishTotal, int mathTotal, String[] names){
		//모든 외부 클래서에서 접근 불가한 Private(접근제한자)를 이용한 mCalcu() 평균/총합 구하는 메소드
		//리턴값을 int[]로 받고, 5가지 매개변수를(int[][]score, int koreanTotal, int englishTotal, int mathTotal, String[] names) 이용.
		
		for (int i = 0; i < score.length; i++) {
			int sum = 0;
			//int로 sum값을 0으로 초기화
			koreanTotal += score[i][0];
			//국어-score[][] 다중배열을 for문으로 i=0값부터 score.length 길이까지의 합
			englishTotal += score[i][1];
			//영어-score[][] 다중배열을 for문으로 i=0값부터 score.length 길이까지의 합
			mathTotal += score[i][2];
			//수학-score[][] 다중배열을 for문으로 i=0값부터 score.length 길이까지의 합

			System.out.print(names[i] + "\t");
			//names[]의 배열을 for문의 score.length 순으로 출력
			for (int j = 0; j < score[i].length; j++) {
				//[i]값과 [j]값의 이중 for문으로 총합(sum) 구하는 for문
				sum += score[i][j];
				//다중배열을 이용한 sum(총합) 계산 및 sum 재정의
				System.out.print(score[i][j] + "\t");
				//구해진 score[i][j]값 출력
			}

			int avg = (sum / score[i].length);
			//int 평균값 avg로 생성 - 총합(sum)을 과목수(score[i].length)로 나눔
			System.out.print(sum + "\t" + avg + "\t");
			//총합과 평균 출력
			
			mCredit(avg);
			//매개변수를 avg를 이용한 mCredit 메소드 실행문
		}
		//---------------------------------------------------for문 끝---------------------------------------------------
		int[] totalNum = {koreanTotal, englishTotal, mathTotal};
		//mCalcu()메소드의 리턴값을 위한 int[] totalNum 생성
		return totalNum;
		//선언된 totalNum을 반환
	}
	//---------------------------------------------------mCalcu() 끝---------------------------------------------------

	private void mCredit(int avg) {
		// 접근제한자가 private인 리턴타입이 없는 mCredit함수
		// 매개변수가 int형인 avg
		String credit = null;
		// String형태의 credit이라는 형태에 null값을 넣음
		if (avg >= 95 && avg <= 100) {
			// 평균 avg가 100보다 작거나 같거나 95보다 크거나 같을 경우
			credit = "A";
			System.out.print(credit);
			// credit은 A값을 출력
		} else if (avg >= 90 && avg <= 94) {
			// 평균 avg가 94보다 작거나 같거나 90보다 크거나 같을 경우
			credit = "B";
			System.out.print(credit);
			// credit은 B값을 출력
		} else if (avg >= 85 && avg <= 89) {
			// 평균 avg가 89보다 작거나 같거나 85보다 크거나 같을 경우
			credit = "C";
			System.out.print(credit);
			// credit은 C값을 출력
		} else if (avg >= 80 && avg <= 84) {
			// 평균 avg가 84보다 작거나 같거나 80보다 크거나 같을 경우
			credit = "D";
			System.out.print(credit);
			// credit은 D값을 출력
		} else {
			// 평균 avg가 위의 값들에 속하지 않을경우
			credit = "E";
			System.out.print(credit);
			// credit은 E값을 출력
		}
		System.out.println();
	}

	public void play() {
		// 접근제한자가  public인 play라는 함수이다.
		int[][] score = { 
				{ 99, 98, 88 }, 
				{ 65, 85, 94 }, 
				{ 87, 67, 94 }, 
				{ 94, 84, 84 }, 
				{ 67, 74, 82 } };
		// score 

		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0; // 국어, 영어, 수학 총점
		int lineNum = 50; // 구분선 줄길이

		String[] names = { "길동", "삿갓", "둘리", "뚜치", "보라" };

		System.out.println("성명\t국어\t영어\t수학\t총점\t평균 \t학점");
		for (int i = 0; i < lineNum; i++) {
			System.out.print("=");
		}
		System.out.println();

		int[] totalNum = mCalcu(score, koreanTotal, englishTotal, mathTotal, names);

		for (int i = 0; i < lineNum; i++) {
			System.out.print("=");
		}
		System.out.println();

		for (int i = 0; i < totalNum.length; i++) {
			koreanTotal = totalNum[0];
			englishTotal = totalNum[1];
			mathTotal = totalNum[2];
			// 국어, 영어, 수학 총점
		}

		System.out.println("총점:" + "\t" + koreanTotal + "\t" + englishTotal + "\t" + mathTotal);
		System.out.println("평균:" + "\t" + koreanTotal / (float) score.length + "\t"
				+ englishTotal / (float) score.length + "\t" + mathTotal / (float) score.length);

		for (int i = 0; i < lineNum; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SungJuk1 sj = new SungJuk1();
		sj.play();
	}
}
