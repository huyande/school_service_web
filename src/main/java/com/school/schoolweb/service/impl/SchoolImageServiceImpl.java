package com.school.schoolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.schoolweb.bean.SchoolImage;
import com.school.schoolweb.dao.SchoolImageMapper;
import com.school.schoolweb.service.SchoolImageService;

@Service
public class SchoolImageServiceImpl implements SchoolImageService{

	@Autowired
	private SchoolImageMapper imageMapper;
	/**
	 * 添加图片
	 */
	@Override
	public int postAdd(SchoolImage schoolImage) {
		return imageMapper.insert(schoolImage);
	}

	/**
	 * 分页查找
	 */
	@Override
	public List<SchoolImage> findschoolImage(int pageStart, int pageSize) {
		
		return imageMapper.findAllschoolImage((pageStart-1)*pageSize,pageSize);
	}

	/**
	 * 分页查找 自己发布的信息
	 */
	@Override
	public List<SchoolImage> findSchoolImageOfMyImage(Integer page, Integer pageSize,String openid) {
		return imageMapper.findSchoolImageOfMyImage((page-1)*pageSize,pageSize,openid);
	}

	/**
	 * 查询信息
	 */
	@Override
	public SchoolImage findSchoolByImageid(String confid) {
		return imageMapper.selectByPrimaryKey(confid);
	}

}
