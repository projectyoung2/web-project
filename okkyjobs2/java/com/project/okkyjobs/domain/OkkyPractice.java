package com.project.okkyjobs.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OkkyPractice {

	
	private int intern_type;
	private String project_name;
	private String project_introduce;
	private String work_style;
	private int min_career;
	private int max_career;
	private int school_career;
	private int min_pay;
	private int max_pay;
	private int working_period;
	private LocalDate start_day;
	private LocalDate money_month;
	private LocalDate money_day;
	private LocalDate incruit_end;
	private String having_skill;
	private String incruit_tag;
	private String incruit_detail;
	private int incruit_view;
	private String share_url;
	private int like_count;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
