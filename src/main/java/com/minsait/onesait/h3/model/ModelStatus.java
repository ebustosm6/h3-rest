package com.minsait.onesait.h3.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("ModelStatus")
public class ModelStatus {

	private String _id;
	private boolean is_training;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date timestamp;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date last_trained;
	private String last_training_time;
	private float training_score;
	
}
