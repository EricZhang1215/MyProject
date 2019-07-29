package com.security.sso.baseUtils.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

//读取所有配置文件中以'zqs.security'开头的配置项
@ConfigurationProperties(prefix = "zqs.security")
public class SecurityProperties {

	BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

}
