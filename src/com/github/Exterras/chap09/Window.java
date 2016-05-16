package com.github.Exterras.chap09;

public class Window {
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			System.out.println("Call");
		}
	};
	
	public Window() {
		// TODO Auto-generated constructor stub
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Send Message");
			}
		});
	}
	
}
