package com.ramonmr95.tiky.olc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Course implements Serializable {

	private static final String dateFormat = "yyyy-MM-dd";
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Course name can't be null")
	@Column(nullable = false, name = "course_name")
	private String courseName;

	@NotNull(message = "Start year can't be null")
	@Column(nullable = false, name = "year_start")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = dateFormat)
	private Date yearStart;

	@NotNull(message = "End year name can't be null")
	@Column(nullable = false, name = "year_end")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = dateFormat)
	private Date yearEnd;

	@NotNull(message = "Schedule can't be null")
	@Column(nullable = false)
	private String schedule;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourse_name() {
		return courseName;
	}

	public void setCourse_name(String courseName) {
		this.courseName = courseName;
	}

	public Date getYearStart() {
		return yearStart;
	}

	public void setYearStart(Date yearStart) {
		this.yearStart = yearStart;
	}

	public Date getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(Date yearEnd) {
		this.yearEnd = yearEnd;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}