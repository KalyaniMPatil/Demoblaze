package com.demotest.config;
import com.demotest.utilities.FileUtil;

public class Configuration {
	
	public String getAppUrl(String env) {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "app."+env+".url");
	}

	public String getBrowserName() {
		FileUtil file = new FileUtil();
		return file.getConfiguration("browser_name");
	}

	public String getExecutionMode() {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/main/resources/config.properties", "execution_mode");
	}

}
