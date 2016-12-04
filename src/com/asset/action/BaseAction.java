package com.asset.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.asset.pojo.User;
import com.asset.service.AssetService;
import com.asset.service.StatusService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport{
	protected static String webRoot;
	protected static final String UserKEY = "user";
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	protected String tip;
	@Resource
	protected AssetService assetService;
	@Resource
	protected StatusService statusService;
	protected HttpSession getSession() {
		return getRequest().getSession();
	}
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	protected static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	protected ActionContext getContext() {
		return ServletActionContext.getContext();
	}
	/**
	 * 得到当前的userid
	 */
	protected long getUserIdBybase() {
		User user = (User)getSession().getAttribute(UserKEY);
		return user.getUserId();
	}
	/**
	 * 得到当前的user对象
	 * 
	 * @return
	 */
	protected User getUserBybase() {
		return (User) getSession().getAttribute(UserKEY);
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getWebRoot() {
		if (webRoot == null || webRoot.equals("")) {
			webRoot = getRequest().getContextPath();
		}
		return webRoot;
	}
	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}
}
