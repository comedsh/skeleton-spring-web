/**
 * 
 */
package com.fenghua.auto.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.dao.BaseDao;
import com.fenghua.auto.sku.dao.CatalogDao;
import com.fenghua.auto.sku.domain.Catalog;
import com.fenghua.auto.backend.service.impl.BaseServiceImpl;
import com.fenghua.auto.sku.service.CatalogService;

/**
 * Service实现类
 *
 * @author lijie
 * @createTime 2015-11-27 11:44:10
 *
 */
@Service
public class CatalogServiceImpl extends BaseServiceImpl<Catalog> implements CatalogService {

	@Autowired
	private CatalogDao dao;
	
	@Override
	protected BaseDao<Catalog> getBaseDao() {
		return dao;
	}

}
