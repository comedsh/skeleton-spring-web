package com.fenghua.auto.backend.core.utills;

import java.util.Collection;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fenghua.auto.backend.core.security.UserInfo;

/**
 * <des> 
 *   用户信息辅助类
 * </des>
 * 
 * @author lijie
 * @date 2015年11月26日
 * @version
 */
public final class UserSecurityUtils {
	
	/**
	 * 获取session
	 * @return
	 */
	public static HttpSession getSession() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		 HttpSession session = requestAttributes.getRequest().getSession();
		return session;
	}

	/**
	 * 取得当前用户
	 */
	public static UserInfo getCurrentUser() throws AuthenticationException{
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			 throw new AuthenticationException("user not athentication!");
		}

		Object principal = authentication.getPrincipal();
		if (!(principal instanceof UserInfo)) {
			 throw new AuthenticationException("user not athentication!");
		}

		return (UserInfo) principal;
	}

	/**
	 * 取得当前用户的登录名, 如果当前用户未登录则返回空字符串.
	 */
	public static String getCurrentUserName() {
		Authentication authentication = getAuthentication();

		if (authentication == null || authentication.getPrincipal() == null) {
			return "";
		}

		return authentication.getName();
	}

	/**
	 * 取得当前用户的真实姓名, 如果当前用户未登录则返回空字符串.
	 * @throws AuthenticationException 
	 */
	public static Long getCurrentUserId() throws AuthenticationException {
		return getCurrentUser().getUserId();
	}

	/**
	 * 取得当前用户登录IP, 如果当前用户未登录则返回空字符串.
	 */
	public static String getCurrentUserIp() {
		Authentication authentication = getAuthentication();

		if (authentication == null) {
			return "";
		}

		Object details = authentication.getDetails();
		if (!(details instanceof WebAuthenticationDetails)) {
			return "";
		}

		WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
		return webDetails.getRemoteAddress();
	}

	/**
	 * 判断用户是否拥有角色, 如果用户拥有参数中的任意一个角色则返回true.
	 */
	public static boolean hasAnyRole(String... roles) {
		Authentication authentication = getAuthentication();
		if (authentication == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> grantedAuthorityList = authentication.getAuthorities();
		for (String role : roles) {
			for (GrantedAuthority authority : grantedAuthorityList) {
				if (role.equals(authority.getAuthority())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 取得Authentication, 如当前SecurityContext为空时返回null.
	 */
	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return null;
		}

		return context.getAuthentication();
	}
}
