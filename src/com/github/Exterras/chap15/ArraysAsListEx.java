package com.github.Exterras.chap15;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListEx {
	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Hong", "Sin", "Kim");
		for (String name : list1) {
			System.out.println(name);
		}
		System.out.println("size()-1 Confirm : "+list1.get((list1.size())-1));
		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for (int value : list2) {
			System.out.println(value);
		}
	}
}
