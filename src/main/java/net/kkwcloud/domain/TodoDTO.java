package net.kkwcloud.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {

	private String title;	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date due_date; 
	private boolean check;
	
}//class end
