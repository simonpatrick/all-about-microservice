package io.hedwig.petclinic.cachesamples;

public class Book {

	private final long id;
	private final String name;

	public Book(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
