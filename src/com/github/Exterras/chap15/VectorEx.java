package com.github.Exterras.chap15;

import java.util.List;
import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("Title1","Content1","Name1"));
		list.add(new Board("Title2","Content2","Name2"));
		list.add(new Board("Title3","Content3","Name3"));
		list.add(new Board("Title4","Content4","Name4"));
		list.add(new Board("Title5","Content5","Name5"));
		
		list.remove(2);
		list.remove(3);
		
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject+"\t"+board.content+"\t"+board.writer+"\t");
		}
	}
}
