package group3;

public class Grading {
	public static void main(String[] args) {
		int[][] answer = { 
		// 1번, answer의 값으로 2차배열을 넣었으니 2차배열형을 주어야 한다.		
				{ 1, 3, 2, 4, 3, 1, 4, 2, 2, 1 }, 
				{ 3, 2, 4, 2, 2, 1, 1, 3, 4, 1 },
				{ 2, 4, 3, 2, 1, 2, 1, 3, 3, 4 }, 
				{ 2, 3, 3, 1, 1, 3, 2, 2, 4, 4 }, 
				{ 3, 1, 1, 2, 4, 1, 2, 3, 1, 3 } };

		for (int i = 0; i < answer.length; i++) {
			// 2번, 이 클래스에서는 이중 for문으로 구성되어 있다.
			// 따라서  answer의 값을 args 배열로  받은 값과 정답비교를 하기 위해선 
			// 먼저 answer의 첫번째 행값 (답을 제출한 학생의 수) 만큼의 반복문이 필요하다. 
			
			if (args.length != answer[i].length) {
				// 3번, answer의 값을 args 배열로  받은 값과 정답비교를 하기 전에
				// 개별 학생의 답의 수와 args로 입력한 수의 개수가 일치한지 알아봐야 한다.
				// 그럴려면 answer의 두번째 열값과 args의 길이가 같은 지 판단하는 제어문이다. 
				System.out.println("정답의 개수가 맞지 않습니다.");
				return;
			}

			int score = 0;
			for (int j = 0; j < answer[i].length; j++) {
				// 4번, answer의 값을 args 배열로  받은 값과 정답비교를 하려면
				// answer의 두번째 열값 (개별 학생의 학생 답의 수)만큼의 반복문이 필요하다.  
				if (answer[i][j] == Integer.parseInt(args[j]))
					score++;
					// 5번, 위의 if문은 학생들의 답안이 args로 입력받은 값이 맞으면 어떠한 조건을 하라고 명시되어 있다.
					// 정답이면 점수가 올라가야 하므로 score를 1씩 후치증가한다.
			}

			System.out.println("학생 " + (i + 1) + "의 점수 : " + score + "점");
		}
	}
}
