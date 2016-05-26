package com.github.Exterras.chap11;

public class NewInstanceExample {
	public static void main(String[] args) {
		try {
			Class send = Class.forName("com.github.Exterras.chap11.SendAction");
			Class receive = Class.forName("com.github.Exterras.chap11.ReceiveAction");
			Action actionSend = (Action) send.newInstance();
			Action actionReceive = (Action) receive.newInstance();
			actionSend.execute();
			actionReceive.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}


