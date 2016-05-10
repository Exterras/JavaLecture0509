package com.github.Exterras.chap08;

public class OracleDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("Oracle DB Search");
	}

	@Override
	public void insert() {
		System.out.println("Oracle DB Insert");
	}

	@Override
	public void update() {
		System.out.println("Oracle DB Update");
	}

	@Override
	public void delete() {
		System.out.println("Oracle DB Delete");
	}

}
