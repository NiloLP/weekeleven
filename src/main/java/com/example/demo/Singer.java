package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Singer {

	private @Id @GeneratedValue Long id;
	private String name;
	private String band;
	private String song;

	private Singer() {}

	public Singer(String name, String band, String song) {
		this.name = name;
		this.band = band;
		this.song = song;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Singer singer = (Singer) o;
		return Objects.equals(id, singer.id) &&
			Objects.equals(name, singer.name) &&
			Objects.equals(band, singer.band) &&
			Objects.equals(song, singer.song);
	}



	@Override
	public int hashCode() {

		return Objects.hash(id, name, band, song);
	}

	@Override
	public String toString() {
		return "Singer{" +
			"id=" + id +
			", name='" + name + '\'' +
			", band='" + band + '\'' +
			", song='" + song + '\'' +
			'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	
}