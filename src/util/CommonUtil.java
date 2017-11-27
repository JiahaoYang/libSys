package util;

public class CommonUtil {
	public static String getReaderType(String type) {
		if ("1".equals(type))
			return "教师";
		else if ("2".equals(type))
			return "研究生";
		else if ("3".equals(type))
			return "本科生";
		return "";
	}
	
	public static int getAvailableCnt(String type) {
		if ("1".equals(type))
			return 10;
		else if ("2".equals(type))
			return 8;
		else if ("3".equals(type))
			return 6;
		return 0;
	}
}
