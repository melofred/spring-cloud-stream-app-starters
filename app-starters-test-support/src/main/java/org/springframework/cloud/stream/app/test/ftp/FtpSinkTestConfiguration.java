/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.app.test.ftp;

import java.util.Properties;

import org.springframework.cloud.stream.app.test.BinderTestPropertiesInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gary Russell
 *
 */
@Configuration
public class FtpSinkTestConfiguration {

	@Bean
	public static BinderTestPropertiesInitializer loadProps(ConfigurableApplicationContext context) {
		Properties properties = new Properties();
		properties.put("remoteDir", "ftpTarget");
		properties.put("username", "foo");
		properties.put("password", "foo");
		properties.put("filenamePattern", "*");
		properties.put("port", 21);
		properties.put("mode", "FAIL");
		properties.put("filenameExpression", "payload.name.toUpperCase()");
		return new BinderTestPropertiesInitializer(context, properties);
	}

}
