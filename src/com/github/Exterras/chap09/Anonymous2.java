package com.github.Exterras.chap09;

public class Anonymous2 {
	private int field;
	
	public void method(final int arg1, int arg2){
		final int var1 = 0;
		int var2 = 0;
		
		field = 10;
		
		// arg1 = 20;
		// arg2 = 20;
		
		// var1 = 30;
		// var2 = 30;
		
		Calculatable calc = new Calculatable() {
			
			@Override
			public int sum() {
				// TODO Auto-generated method stub
				int result = field+arg1+arg2+var1+var2;
				return result;
			}
		};
		
		System.out.println(calc.sum());
		
	}
}
