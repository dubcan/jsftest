package com.dubcan.jsftest.user;

public class CountryDto {
	
	private final String id;
	private final String title;
	
	public CountryDto(String id, String title) {
		if (id == null) {
			throw new NullPointerException("id");
		}
		if (id.isEmpty()) {
			throw new IllegalArgumentException("id is empty");
		}
		if (title == null) {
			throw new NullPointerException("title");
		}
		if (title.isEmpty()) {
			throw new IllegalArgumentException("title is empty");
		}
		this.id = id;
		this.title = title;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", title=" + title + "]";
	}
}