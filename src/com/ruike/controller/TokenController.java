package com.ruike.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ruike.wechat.WeChatCore;

@Scope("prototype")
@Controller("tokenController")
public class TokenController extends BaseController {
	
	@Resource(name="weChatService")
	private WeChatCore wechat;
	
	public String token() {
		output(WeChatCore.getToken());
		return null;
	}
	
	public String flush() {
		wechat.flush_access_token();
		output("刷新完成");
		return null;
	}
	
	public String Ips() {
		output(WeChatCore.getWxIps());
		return null;
	}
	
	public String createMenu() {
		String menu = "{\"button\":[{\"name\":\"阿米商城\",\"sub_button\":[{\"type\":\"scancode_waitmsg\",\"name\":\"商城首页\",\"key\":\"rselfmenu_0_0\"},{\"type\":\"scancode_push\",\"name\":\"品牌文化\",\"key\":\"rselfmenu_0_1\"}]},{\"name\":\"阿米动态\",\"type\":\"view\",\"url\":\"http://www.ws-am-rj.com/T882016006/WeChatPages/notice.html?close=1\"},{\"name\":\"发送位置\",\"type\":\"location_select\",\"key\":\"rselfmenu_2_0\"}]}";
		output(WeChatCore.createMenu(menu));
		return null;
	}
	
	public String getMenu() {
		output(WeChatCore.getMenu());
		return null;
	}
	
	
	public static void main(String[] args) {
		int amount = 10000;
		int start = 1; 
		int every = 42;
		int nextam = 42;
		int next = 1;
		while(amount > 0) {
			nextam = every * next;
			amount = amount - nextam;
			System.out.println("第" + start + "局,本局倍数：" + next + ",投注：" + nextam + ",剩余：" + amount);
			next = next * 2;
			start++;
		}
	}
}
