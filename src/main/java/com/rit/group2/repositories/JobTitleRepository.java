package com.rit.group2.repositories;

import java.util.ArrayList;

public class JobTitleRepository {

	private ArrayList<String> jobTitles;

	private static JobTitleRepository jobTitleRepository;

	public JobTitleRepository(){
		jobTitles = new ArrayList<String>();
		jobTitles.add(new String("title1"));
		jobTitles.add(new String("title2"));
		jobTitles.add(new String("title3"));
		jobTitles.add(new String("title4"));

		// TODO: Remove for R2
		int id = 0;
		for (String jobTitle : jobTitles) {
			// jobTitle.setId(id);
			// jobTitle.setName("Education Teachers")

			id++;
		}
	}

	public static JobTitleRepository getInstance(){
		if(jobTitleRepository == null){
			jobTitleRepository = new JobTitleRepository();
		}
		return jobTitleRepository;
	}

	public void add(String jobTitle) {
		jobTitles.add(jobTitle);
	}

	public ArrayList<String> getAll() {
		return jobTitles;
	}
}
