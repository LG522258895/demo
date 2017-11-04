package org.cloudnote.util.system;

public class NumberUtils {
	public static boolean isEmptyPk(Long id) {
		return ObjectUtils.isNull(id) || id.longValue() <= 0L;
	}

	public static boolean compare(Long src, Long desc) {
		return ObjectUtils.isNull(src) && ObjectUtils.isNull(desc) ? true
				: (ObjectUtils.isNull(src) && !ObjectUtils.isNull(desc)
						|| !ObjectUtils.isNull(src) && ObjectUtils.isNull(desc) ? false
								: src.longValue() == desc.longValue());
	}
}
