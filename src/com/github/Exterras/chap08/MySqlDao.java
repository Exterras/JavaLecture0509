package com.github.Exterras.chap08;

public class MySqlDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("MySQL DB Search");
	}

	@Override
	public void insert() {
		System.out.println("MySQL DB Insert");
	}

	@Override
	public void update() {
		System.out.println("MySQL DB Update");
	}

	@Override
	public void delete() {
		System.out.println("MySQL DB Delete");
	}

}
