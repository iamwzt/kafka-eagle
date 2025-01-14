/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartloli.kafka.eagle.common.util;

import java.util.HashMap;
import java.util.Map;

import org.smartloli.kafka.eagle.common.util.KConstants.IM;

import com.alibaba.fastjson.JSONObject;

/**
 * Send alert util.
 * 
 * @author smartloli.
 *
 *         Created by Oct 6, 2019
 */
public class AlertUtils {

	/** Send Json msg by dingding. */
	public static String sendTestMsgByDingDing(String uri, String data) {
		Map<String, Object> dingDingMarkdownMessage = getDingDingMarkdownMessage(IM.TITLE, data, true);
		return HttpClientUtils.doPostJson(uri, JSONObject.toJSONString(dingDingMarkdownMessage));
	}

	/**
	 * create markdown format map, do not point @user, option @all.
	 * 
	 * @param title
	 * @param text
	 * @param isAtAll
	 */
	private static Map<String, Object> getDingDingMarkdownMessage(String title, String text, boolean isAtAll) {
		Map<String, Object> map = new HashMap<>();
		map.put("msgtype", "markdown");

		Map<String, Object> markdown = new HashMap<>();
		markdown.put("title", title);
		markdown.put("text", text);
		map.put("markdown", markdown);

		Map<String, Object> at = new HashMap<>();
		at.put("isAtAll", false);
		map.put("at", at);

		return map;
	}

}
