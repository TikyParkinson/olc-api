package com.ramonmr95.tiky.olc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ramonmr95.tiky.olc.dtos.ExamDto;

@Entity
@Table(name = "user_exams")
public class UserExam implements Serializable {

	private static final long serialVersionUID = 3706876187186768150L;
	private static final String dateFormat = "yyyy-MM-dd";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@NotNull(message = "The exam date is required")
	@Column(nullable = false,name = "date_success")
	@JsonFormat(pattern = dateFormat)
	private Date date;

	@Column(nullable = true)
	private Double mark;

	@ManyToOne(optional = true)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamDto convertToDto() {
		return new ModelMapper().map(this, ExamDto.class);
	}

}