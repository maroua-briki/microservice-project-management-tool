package com.bd.projManagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Project")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	@Id
	private int id ;
	private String topic;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private String startDate;
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private String endDate;

	public Project() {
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
}
