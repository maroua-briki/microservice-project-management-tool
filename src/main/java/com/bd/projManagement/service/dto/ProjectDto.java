package com.bd.projManagement.service.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class ProjectDto {
	private int id;
	private String topic;
	private String startDate;
	private String endDate ;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	/*
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate startDate;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
*/
	public ProjectDto() {
	}

	public ProjectDto(int id, String topic) {
		this.id = id;
		this.topic = topic;
	}


	public ProjectDto(int id, String topic, String startDate, String endDate) {
		this.id = id;
		this.topic = topic;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

//redefinition of equals, hashcode, toString


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProjectDto that = (ProjectDto) o;
		return id == that.id &&
				Objects.equals(topic, that.topic) &&
				Objects.equals(startDate, that.startDate) &&
				Objects.equals(endDate, that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, topic, startDate, endDate);
	}

	@Override
	public String toString() {
		return "ProjectDto{" +
				"id=" + id +
				", topic='" + topic + '\'' +
				", startDate=" + startDate +
				", endDate=" + endDate +
				'}';
	}
}
