package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
	@NotBlank(message = "名前は必須です")
	private String name;

	@NotNull(message = "年齢を入力してください")
	private Integer age;

	@Size(min = 1, max = 300, message = "1文字以上300字以内で入力してください")
	private String comment;

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
