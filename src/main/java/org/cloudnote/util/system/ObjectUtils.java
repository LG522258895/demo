package org.cloudnote.util.system;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cloudnote.util.dateFormate.DateUtils;

public class ObjectUtils {
	public static boolean isNull(Object obj) {
		return null == obj;
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static boolean isEmpty(Collection<?> coll) {
		return isNull(coll) ? true : coll.isEmpty();
	}

	public static boolean isSet(Class<?> cls) {
		return isNull(cls) ? false : cls.isAssignableFrom(Set.class);
	}

	public static boolean isMap(Class<?> cls) {
		return isNull(cls) ? false : Map.class.isAssignableFrom(cls);
	}

	public static boolean isList(Class<?> cls) {
		return isNull(cls) ? false : List.class.isAssignableFrom(cls);
	}

	public static boolean isString(Class<?> cls) {
		return isNull(cls) ? false : String.class.getName().equals(cls.getName());
	}

	public static boolean isNumber(Class<?> cls) {
		return isDouble(cls) || isFloat(cls) || isByte(cls) || isShort(cls) || isLong(cls) || isInteger(cls);
	}

	public static boolean isDouble(Class<?> cls) {
		return compareClass(Double.class, cls) || compareClass(Double.TYPE, cls);
	}

	public static boolean isFloat(Class<?> cls) {
		return compareClass(Float.class, cls) || compareClass(Float.TYPE, cls);
	}

	public static boolean isByte(Class<?> cls) {
		return compareClass(Byte.class, cls) || compareClass(Byte.TYPE, cls);
	}

	public static boolean isShort(Class<?> cls) {
		return compareClass(Short.class, cls) || compareClass(Short.TYPE, cls);
	}

	public static boolean isLong(Class<?> cls) {
		return compareClass(Long.class, cls) || compareClass(Long.TYPE, cls);
	}

	public static boolean isInteger(Class<?> cls) {
		return compareClass(Integer.class, cls) || compareClass(Integer.TYPE, cls);
	}

	public static boolean compareClass(Class<?> cls1, Class<?> cls2) {
		return cls1.getName().equals(cls2.getName());
	}

	public static boolean isSimpleObject(Class<?> cls) {
		return isNull(cls) ? false
				: (cls.isPrimitive() ? true
						: Boolean.class.getName().equals(cls.getName()) || Byte.class.getName().equals(cls.getName())
								|| Short.class.getName().equals(cls.getName())
								|| Integer.class.getName().equals(cls.getName())
								|| Long.class.getName().equals(cls.getName())
								|| Float.class.getName().equals(cls.getName())
								|| Double.class.getName().equals(cls.getName())
								|| String.class.getName().equals(cls.getName()));
	}

	public static Object convert(Class<?> cls, String str) {
		return convert(cls, str, (String) null);
	}

	public static Object convert(Class<?> cls, String str, String dateFormat) {
		return Integer.TYPE.getName() == cls.getName() ? Integer.valueOf(Integer.valueOf(str).intValue())
				: (Integer.class.getName() == cls.getName() ? Integer.valueOf(str)
						: (Byte.TYPE.getName() == cls.getName() ? Byte.valueOf(Byte.valueOf(str).byteValue())
								: (Byte.class.getName() == cls.getName() ? Byte.valueOf(str)
										: (Short.TYPE.getName() == cls.getName()
												? Short.valueOf(Short.valueOf(str).shortValue())
												: (Short.class.getName() == cls.getName() ? Short.valueOf(str)
														: (Long.TYPE.getName() == cls.getName()
																? Long.valueOf(Long.valueOf(str).longValue())
																: (Long.class.getName() == cls.getName()
																		? Long.valueOf(str)
																		: (Float.TYPE.getName() == cls.getName()
																				? Float.valueOf(
																						Float.valueOf(str).floatValue())
																				: (Float.class.getName() == cls
																						.getName()
																								? Float.valueOf(str)
																								: (Double.TYPE
																										.getName() == cls
																												.getName()
																														? Double.valueOf(
																																Double.valueOf(
																																		str)
																																		.doubleValue())
																														: (Double.class
																																.getName() == cls
																																		.getName()
																																				? Double.valueOf(
																																						str)
																																				: (isString(
																																						cls) ? str
																																								: (Date.class
																																										.getName() != cls
																																												.getName()
																																										&& java.sql.Date.class
																																												.getName() != cls
																																														.getName()
																																										&& Timestamp.class
																																												.getName() != cls
																																														.getName()
																																																? null
																																																: DateUtils
																																																		.strToDate(
																																																				str,
																																																				dateFormat))))))))))))));
	}
}
