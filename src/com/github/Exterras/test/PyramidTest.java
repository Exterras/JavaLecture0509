package com.github.Exterras.test;

public class PyramidTest {
	public static void main(String[] args) {
		  
	  int linenbr = (Integer.parseInt(args[0])) % 12 ;
	  // args[0] 를 int 타입으로 변환한 후 그것을 12를 나누어 나머지 값을 int linenbr에 넣기

	  for ( int row = 1;  row <= linenbr; row++) {
	  // 행의 숫자를 만들어주는 for문, linenbr 만큼 돈다.
		  
	    for ( int col = 1; col < (linenbr-row)+1; col++){
	      System.out.print("    ");
	      // 매 행마다 공백칸을 만드는 for문, 다음 행이 될 때, 해당 행만큼 뻴셈하여 피라미드의 형태를 맞춰줌
	    }
	     
	    for ( int num = row ; num >= 1 ; num--){
	      System.out.print((num >= 10) ? "  " + num : "   " + num);
	    } // 가운데 1 전의 숫자(왼쪽)
	    
	    for ( int num = 2 ; num <= row ; num++){
	      System.out.print((num >= 10) ? "  " + num : "   " + num);
	    } // 가운데 1 후의 숫자(오른쪽)
	      
	    System.out.println();
	   }
	 }
}