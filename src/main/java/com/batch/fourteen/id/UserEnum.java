package com.batch.fourteen.id;

/**
 * Dont Change the ID, it is referenced to several xml files.
 * 
 * @author jangolluan
 * @since 02/12/2017
 *
 */
public enum UserEnum {
	JOHNREY("1"),
	KRIS("2"),
	RASSEL("3"),
	MENISA("4"),
	NICK("5"),
	JO("6"),
	RONALENE("7"),
	CHIARRA("8"),
	BLENDA("9"),
	ONAT("10"),
	DOROTHY("11"),
	ALEX("12"),
	ADMIN1("99"),
	ADMIN2("98");
	
	private String id;
	
	UserEnum(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
