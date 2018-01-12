package com.anybbo;

/**
 * @author: Huopengbo
 * @data: 2018/1/12
 * @time: 14:12
 * @description: .
 */
public enum ExerciseEnum {

	ENVIRONMENT(""), TRAFFIC(""), PHONE("");

	private String name;

	private ExerciseEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
