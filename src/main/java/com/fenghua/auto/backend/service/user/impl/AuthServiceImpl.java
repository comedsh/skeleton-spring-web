 package com.fenghua.auto.backend.service.user.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenghua.auto.backend.core.security.UserInfo;
import com.fenghua.auto.backend.core.utills.UserSecurityUtils;
import com.fenghua.auto.backend.dao.user.UserDao;
import com.fenghua.auto.backend.domain.user.User;
import com.fenghua.auto.backend.service.user.AuthService;
import com.fenghua.auto.backend.service.user.UserService;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.oauth.Oauth;

/**
 * qq登陆验证实现
 * 
 * @author zhangfr
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService userService;

	@Override
	public User isUser(HttpServletRequest request) throws QQConnectException {
		logger.debug("判断是否为qq绑定用户----start");
		AccessToken accessTokenObj = (new Oauth())
				.getAccessTokenByRequest(request);
		String accessToken = null, openID = null;
		long tokenExpireIn = 0L;
		if (accessTokenObj.getAccessToken().equals("")) {
			logger.debug("判断是否为qq绑定用户----qq账号异常");
			throw new QQConnectException("qq登陆异常异常！");
		} else {
			accessToken = accessTokenObj.getAccessToken();
			request.getSession().setAttribute("qqOpenID", accessToken);
			OpenID openIDObj = new OpenID(accessToken);
			openID = openIDObj.getUserOpenID();
			User user = userService.getUserByQQ(openID);
			if(user==null){
				logger.debug("判断是否为qq绑定用户----账户未绑定--end");
			}
			return user;
		}
	}
	@Override
	public void binding(UserInfo userInfo) {
		HttpSession session = UserSecurityUtils.getSession();
		String qqOpenID = (String) session.getAttribute("qqOpenID");
		logger.debug("+++++++++++++++++当前qqOpenID为:"+qqOpenID);
		if (qqOpenID != null) {
			logger.debug("开始绑定qq账户----start");
			binding(qqOpenID,userInfo);
			logger.debug("成功绑定qq账户----end");
		}
	}
	public void binding(String qqOpenID,UserInfo userInfo) {
		User user = userService.getUserById(userInfo.getUserId());
		user.setQqNumber(qqOpenID);
		userService.update(user);
		logger.debug("当前账户绑定的qq号为----"+user.getQqNumber());
	}
}