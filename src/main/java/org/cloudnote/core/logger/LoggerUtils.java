package org.cloudnote.core.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {
	public static Logger logger = null;

	public static LoggerUtils getLogger(Class<?> cls) {
		logger = LoggerFactory.getLogger(cls);
		return new LoggerUtils();
	}

	public static LoggerUtils getLogger(String name) {
		logger = LoggerFactory.getLogger(name);
		return new LoggerUtils();
	}

	public void info(Integer code) {
		this.info(code, "");
	}

	public void info(String message) {
		this.info(Integer.valueOf(-1), message);
	}

	public void info(String message, Throwable e) {
		this.info(Integer.valueOf(-1), message, e);
	}

	public void info(Integer code, String message) {
		this.info(code, message, (Throwable) null);
	}

	public void info(Integer code, Throwable e) {
		this.info(code, "", (Throwable) null);
	}

	public void info(Integer code, String message, Throwable e) {
		logger.info(message, e);
	}

	public void debug(String message) {
		this.debug(Integer.valueOf(-1), message);
	}

	public void debug(Integer code, String message) {
		this.debug(code, message, (Throwable) null);
	}

	public void debug(Integer code, Throwable e) {
		this.debug(code, "", (Throwable) null);
	}

	public void debug(Integer code, String message, Throwable e) {
		logger.debug(message, e);
	}

	public void error(Throwable e) {
		this.error(Integer.valueOf(-1), (String) null, e);
	}

	public void error(String message) {
		this.error(Integer.valueOf(-1), message);
	}

	public void error(String message, Throwable e) {
		this.error(Integer.valueOf(-1), message, e);
	}

	public void error(Integer code, String message) {
		this.error(code, message, (Throwable) null);
	}

	public void error(Integer code, Throwable e) {
		this.error(code, "", (Throwable) null);
	}

	public void error(Integer code, String message, Throwable e) {
		logger.error(message, e);
	}
}
