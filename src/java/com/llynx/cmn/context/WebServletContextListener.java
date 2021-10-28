/*
 * Copyright 2019 LLYNX TECH All right reserved.
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
package com.llynx.cmn.context;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.util.EgovResourceCloseHelper;


public class WebServletContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(WebServletContextListener.class);
    public static String LOAD_SERVER_IP = "127.0.0.1"; // 로드된 서버의 IP
	public static String PROFILE = "local"; //

    public WebServletContextListener() {}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(System.getProperty("llynx.profiles.active"));
		if (System.getProperty("llynx.profiles.active")==null) {
			setSystemConfig();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO something
		java.lang.System.gc();
	}

	private void setSystemConfig() {
		FileInputStream fis = null;
		FileInputStream fisLog = null;

		Properties props = new Properties();
		Properties logProps = new Properties();

		String ipHost = "";
		String logAppPath = "/home/cust/data/logs";
		String profiles = "";
		String[] server = new String[3];
		String propPath = "";
		URL path = null;
		try {
			path = this.getClass().getResource("/properties/llynx.properties");
			if (path != null) {
				propPath = EgovWebUtil.filePathBlackList(path.getPath());

				if (propPath != null) {
					fis = new FileInputStream(propPath);

					if (fis != null) {
						props.load(new BufferedInputStream(fis));
						if (props != null) {

							Enumeration<NetworkInterface> network = NetworkInterface.getNetworkInterfaces();
							while(network.hasMoreElements()) {
								NetworkInterface ni = network.nextElement();
								Enumeration<InetAddress> inets = ni.getInetAddresses();
								while(inets.hasMoreElements()) {
									InetAddress iNet = inets.nextElement();
									if (ni.getName().equals(props.getProperty("read.nic.id"))) {
										if ("HOSTNAME".equals(props.getProperty("profiles.find.type"))) { // hostname
											ipHost = iNet.getHostName();
										} else { // ip
											ipHost = iNet.getHostAddress();
										}

										if (logger.isDebugEnabled()) {
											logger.debug("Name : {}", ni.getName());
											logger.debug("iNet : {}", iNet.isSiteLocalAddress());
											logger.debug("getHostAddress : {}", iNet.getHostAddress());
											logger.debug("getHostName : {}", iNet.getHostName());
											logger.debug("set load server : {}", ipHost);
										}
									}
								}
							}

							server[0] = props.getProperty("prod.server");
							server[1] = props.getProperty("dev.server");
							server[2] = props.getProperty("local.server");

							String[] serverList = null;
							for (int i=0; i<server.length; i++ ) {
								profiles = "";
								serverList = null;

								serverList = server[i].split(";");
								if (serverList != null && serverList.length>0) {
									for (int j=0; j<serverList.length; j++) {
										if (serverList[j].trim().equals(ipHost)) {
											profiles = (i==0?"prod":(i==1?"dev":"local"));
								            System.setProperty("ftp.info", server[i]);
								            LOAD_SERVER_IP = ipHost;
								            PROFILE = profiles;
											break;
										}
									}
								}
								if (!profiles.isEmpty()) {
									break;
								}
							}
						}
					}
				}
			}

			if (profiles.isEmpty()) {
				profiles = "local";
				System.setProperty("ftp.info", "");
			}

			propPath = "";
			path = this.getClass().getResource("/properties/application-"+profiles+".properties");
			if (path != null) {
				propPath = EgovWebUtil.filePathBlackList(path.getPath());

				if (propPath != null) {
					fisLog = new FileInputStream(propPath);

					if (fisLog != null) {
						logProps.load(new BufferedInputStream(fisLog));

						if (logProps != null) {
							logAppPath = logProps.getProperty("log.app.path");
						}
					}
				}
			}
		} catch (FileNotFoundException fne) {
			logger.error("Property file not found.", fne);
			throw new RuntimeException("Property file not found", fne);
		} catch (IOException ioe) {
			logger.error("Property file IO exception", ioe);
			throw new RuntimeException("Property file IO exception", ioe);
		} finally {
			System.setProperty("llynx.profiles.active", profiles);
			System.setProperty("log.app.path", logAppPath);

			props = null;
			logProps = null;
			EgovResourceCloseHelper.close(fis);
			EgovResourceCloseHelper.close(fisLog);

		}

		LoggerContext logCtx = (LoggerContext)LogManager.getContext(false);
		              logCtx.reconfigure();

		logger.info("SERVER TYPE : {}", System.getProperty("llynx.profiles.active"));
		logger.info("Log path: {}", System.getProperty("log.app.path"));
	}


}
