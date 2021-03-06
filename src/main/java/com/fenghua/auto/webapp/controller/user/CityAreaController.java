package com.fenghua.auto.webapp.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenghua.auto.backend.domain.user.CityArea;
import com.fenghua.auto.backend.service.user.CityAreaService;
/**
 * 城市
 * @author chengbin
 *
 */
@Controller
@RequestMapping("/cityArea")
public class CityAreaController {
	
	@Autowired
	private CityAreaService cityAreaService;
	/**
	 * 获取省份
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/selectProvince", method = RequestMethod.GET)
	public @ResponseBody List<CityArea> selectProvince(HttpServletRequest req, HttpServletResponse res) {
		return cityAreaService.selectProvince();
	}
	/**
	 * 通过省份获取市级城市
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/selectCity", method = RequestMethod.GET)
	public @ResponseBody List<CityArea> selectCity(@RequestParam Long parentId, HttpServletRequest req, HttpServletResponse res) {
		return cityAreaService.selectCity(parentId);
	}
	/**
	 * 通过市级获取县级城市
	 * @param req
	 * @param res
	 */
	@RequestMapping(value = "/selectArea", method = RequestMethod.GET)
	public @ResponseBody List<CityArea> selectArea(@RequestParam Long parentId, HttpServletRequest req, HttpServletResponse res) {
		return cityAreaService.selectArea(parentId);
	}
}
