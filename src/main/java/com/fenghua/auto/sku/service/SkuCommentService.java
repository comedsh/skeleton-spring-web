package com.fenghua.auto.sku.service;

import java.util.Map;

import com.fenghua.auto.backend.service.BaseService;
import com.fenghua.auto.sku.domain.SkuComment;

/** 
  *<des>
  *</des>
  * @author  lijie
  * @date 2015年11月24日
  * @version 
  */
public interface SkuCommentService  extends BaseService<SkuComment>{

	public long countBySkuId(Long skuId);
	
	/**
	 * 统计好评度 = 获取的好评数/评论总数
	 * @return
	 */
	public Map<String,Object> countComentBySkuId(Long skuId);
}
