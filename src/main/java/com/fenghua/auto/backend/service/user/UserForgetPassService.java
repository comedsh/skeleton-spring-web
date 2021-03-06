package com.fenghua.auto.backend.service.user;

import java.util.List;

import com.fenghua.auto.backend.domain.user.ResetPassRequest;

public interface UserForgetPassService {
	/**
	 * 保存
	 * @param resetPassRequest
	 */
	public void insert(String email);
	/**
	 * 根据code查询忘记密码信息
	 * @param certificateCode
	 * @return
	 */
	public List<ResetPassRequest> selectByCodeAndUser(String certificateCode); 
	/**
	 * 根据用户删除找回密码信息
	 * @param UserId
	 */
	public void deleteByUserId(Long UserId,String token);
}
