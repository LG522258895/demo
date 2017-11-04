package org.cloudnote.util.system;

public class StringUtils {
	public static final String EMPTY = "";
    public static final String URL_WINDOS = "\\\\";
    public static final String URL_LINUX = "/";

    public static boolean isEmpty(String str) {
        return "".equals(trim(str));
    }

    public static String trim(String str) {
        return ObjectUtils.isNull(str) ? "" : str.trim();
    }

    public static String concatUrl(String str1, String str2) {
        str1 = isEmpty(str1) ? "" : str1.trim();
        str2 = isEmpty(str2) ? "" : str2.trim();
        str1 = formatUrl(str1);
        str2 = formatUrl(str2);
        return concat(str1, str2, "/");
    }

    public static String formatUrl(String str) {
        return isEmpty(str) ? "" : str.replaceAll("\\\\", "/");
    }

    public static String concat(String str1, String str2, String split) {
        str1 = isEmpty(str1) ? "" : str1.trim();
        str2 = isEmpty(str2) ? "" : str2.trim();
        split = isEmpty(split) ? "" : split.trim();
        StringBuilder result = new StringBuilder();
        result.append(str1);
        if (!str1.endsWith(split)) {
            result.append(split);
        }

        if (str2.startsWith(split)) {
            str2 = str2.substring(1);
        }

        result.append(str2);
        return result.toString();
    }

    public static boolean compareStr(String src, String desc) {
        return compareStr(src, desc, false);
    }

    public static boolean compareStr(String src, String desc, boolean isIgnoreWord) {
        return ObjectUtils.isNull(src) && ObjectUtils.isNull(desc)
                ? true
                : (!ObjectUtils.isNull(src) && !ObjectUtils.isNull(desc)
                ? (isEmpty(src) && isEmpty(desc)
                ? true
                : (isIgnoreWord
                ? trim(src).equalsIgnoreCase(trim(desc))
                : trim(src).equals(trim(desc))))
                : false);
    }

    public static String fillStr(Long str, int len) {
        return fillStr(String.valueOf(str), len, "0", true);
    }

    public static String fillStr(Long str, int len, boolean fillFisrt) {
        return fillStr(String.valueOf(str), len, "0", fillFisrt);
    }

    public static String fillStr(String str, int len) {
        return fillStr(str, len, "0", true);
    }

    public static String fillStr(String str, int len, String fillStr, boolean fillFisrt) {
        str = isEmpty(str) ? "" : str.trim();
        int strLen = str.length();
        if (len <= strLen) {
            return str;
        } else {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < len - strLen; ++i) {
                sb.append(fillStr);
            }

            return fillFisrt ? str.concat(sb.toString()) : sb.append(str).toString();
        }
    }

    public static String encodeHtml(String str) {
        return null != str && !"".equals(str.trim())
                ? str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;").replaceAll(" ", "&nbsp;").replaceAll("\'", "&apos;")
                : "";
    }

    public static void main(String[] args) {
        String str = "1";
        System.out.println(fillStr(str, 5, "0", true));
        System.out.println(fillStr(str, 5, "0", false));
    }
}
