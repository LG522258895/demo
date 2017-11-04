package org.cloudnote.util.system;

import java.net.InetAddress;
import java.util.Locale;
import java.util.Properties;

public class SystemUtils {
	// public static final Logger logger = Logger.getLogger(SystemUtils.class);

	public static Properties getSysProperties() {
		return System.getProperties();
	}

	public static String getClassPath() {
		String path = SystemUtils.class.getResource("/").getPath();
		if (isWindows()) {
			path = path.substring(1);
		}

		return path;
	}

	public static String getWEBINFPath() {
		String path = getClassPath();
		return path.substring(0, path.indexOf("WEB-INF") + "WEB-INF".length() + 1);
	}

	public static String getProjectPath() {
		String path = getClassPath();
		return path.substring(0, path.indexOf("WEB-INF"));
	}

	public static boolean isWindows() {
		Properties prop = getSysProperties();
		String os = prop.getProperty("os.name");
		os = StringUtils.trim(os);
		os = os.toLowerCase(Locale.getDefault());
		return os.startsWith("win");
	}

	public static String getLocalIp() {
		try {
			InetAddress e = InetAddress.getLocalHost();
			String ip = e.getHostAddress().toString();
			return ip;
		} catch (Exception arg1) {
			// logger.error("获得本地ip地址出错", arg1);
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(getLocalIp());
	}
}
