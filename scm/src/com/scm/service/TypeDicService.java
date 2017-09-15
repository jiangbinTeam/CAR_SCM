package com.scm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.TypeDicMapper;
import com.scm.pojo.TypeDictionary;


@Service("typeDicService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class TypeDicService {

	@Resource(name = "typeDicMapper")
	private TypeDicMapper typeDicMapper;

	// 增添车系信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(TypeDictionary scmTypeDictionary) {
		return typeDicMapper.add(scmTypeDictionary);
	}

	// 修改车型信息
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int update(TypeDictionary scmTypeDictionary) {
		return typeDicMapper.update(scmTypeDictionary);
	}

	// 使用车型编码查询车型信息
	public TypeDictionary findByTypecode(String typeCode) {
		return typeDicMapper.findByTypecode(typeCode);
	}

	// 查询所有的车型信息
	public List<TypeDictionary> list() {
		return typeDicMapper.list();
	}

	// 汽车编码分页
	public List<TypeDictionary> findByPageTdy(Integer pageMin, Integer pageMax) {
		return typeDicMapper.findByPageTdy(pageMin, pageMax);
	}

	// 统计汽车编码
	public int countTdy() {

		return typeDicMapper.countTypeDictionary();
	}
}
