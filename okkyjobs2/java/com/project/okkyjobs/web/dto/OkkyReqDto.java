package com.project.okkyjobs.web.dto;

import java.time.LocalDate;

import java.time.LocalDateTime;


import com.project.okkyjobs.domain.OkkyPractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OkkyReqDto {

	private int intern_Type;
	private String project_Name;
	private String project_Introduce;
	private String work_Style;
	private int min_Career;
	private int max_Career;
	private int school_Career;
	private int min_Pay;
	private int max_Pay;
	private int working_Period;
	private LocalDate start_Day;
	private LocalDate money_Month;
	private LocalDate money_Day;
	private LocalDate incruit_End;
	private String having_Skill;
	private String incruit_Tag;
	private String incruit_Detail;
	private int incruit_View;
	private String share_Url;
	private int like_Count;
	
	
	public OkkyPractice toEntity() {
		return OkkyPractice.builder()
							
							.intern_type(0)
							.project_name(project_Name)
							.project_introduce(project_Introduce)
							.work_style(work_Style)
							.min_career(0)
							.max_career(0)
							.school_career(0)
							.min_pay(0)
							.max_pay(0)
							.working_period(0)
							.having_skill(having_Skill)
							.incruit_tag(incruit_Tag)
							.incruit_detail(incruit_Detail)
							.incruit_view(0)
							.share_url(share_Url)
							.like_count(0)
							.build();
	}
}
