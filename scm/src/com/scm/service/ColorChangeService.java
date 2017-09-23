package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.ColorChangeMapper;
import com.scm.pojo.ColorChange;

@Service("colorChangeService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ColorChangeService {

	@Resource(name = "colorChangeMapper")
	private ColorChangeMapper colorChangeMapper;

	// 增添颜色转换信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(ColorChange colorChange) {
		System.out.println(colorChange);
		return colorChangeMapper.add(colorChange);
	}

	// 修改颜色转换信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int update(ColorChange colorChange) {
		return colorChangeMapper.update(colorChange);
	}

	// 列出所有颜色转换信息
	/*
	 * public List<ColorChange> list(){ return colorChangeMapper.list(); }
	 */
	// 列出所有颜色转换信息分页
	public List<ColorChange> list(Integer pageMin, Integer pageMax) {
		return colorChangeMapper.list(pageMin, pageMax);
	}

	// 统计记录条数
	public int count() {
		return colorChangeMapper.count();
	}

	// 通过颜色代码来获取颜色转换信息
	public ColorChange findBycolorCode(String colorCode) {
		return colorChangeMapper.findByColorCode(colorCode);
	}

}
