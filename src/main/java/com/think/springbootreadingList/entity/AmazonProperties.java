/**
 * @author StarryNight
 * @date 2018年5月9日 
 */
package com.think.springbootreadingList.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author StarryNight
 * @data 2018年5月9日 上午11:42:03
 */
@Component
@ConfigurationProperties("amazon") // 注入带amazon前缀的属性
public class AmazonProperties {

	private String associateId;

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {// associateId 的setter方法
		this.associateId = associateId;
	}

}
