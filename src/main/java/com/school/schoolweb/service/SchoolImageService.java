package com.school.schoolweb.service;

import java.util.List;

import com.school.schoolweb.bean.SchoolImage;

public interface SchoolImageService {

	int postAdd(SchoolImage schoolImage);

	List<SchoolImage> findschoolImage(int page, int size);

	List<SchoolImage> findSchoolImageOfMyImage(Integer page, Integer pageSize, String openid);

	SchoolImage findSchoolByImageid(String confid);

	
}
