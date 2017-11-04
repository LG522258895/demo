package org.cloudnote.util.system;

public class ConversionObject {
	public static Integer longToInteger(Long num) {
		return ObjectUtils.isNull(num) ? Integer.valueOf(0) : Integer.valueOf(num.intValue());
	}

	public static Long parseLong(String str, long defaultValue) {
		try {
			return Long.valueOf(Long.parseLong(str));
		} catch (Exception arg3) {
			return Long.valueOf(defaultValue);
		}
	}

	public static Integer parseInteger(String str, int defaultValue) {
		try {
			return Integer.valueOf(Integer.parseInt(str));
		} catch (Exception arg2) {
			return Integer.valueOf(defaultValue);
		}
	}

	public static Boolean parseBoolean(String str, boolean bool) {
		try {
			return Boolean.valueOf(Boolean.parseBoolean(str));
		} catch (Exception arg2) {
			return Boolean.valueOf(bool);
		}
	}
}
