package utils;

import java.util.ArrayList;

public class TO_CLOB {
    public static String[] getMaxByteStringArray(String str, int maxLen, int maxArrays) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> strList = new ArrayList<>();
        int curLen = 0;
        String curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.substring(i, i + 1);
            curLen += curChar.getBytes().length;
            if (curLen > maxLen) {
                if (maxArrays == -1 || strList.size() <= maxArrays - 2) {
                    strList.add(sb.toString());
                    sb = new StringBuilder();
                    curLen = 0;
                    i--;
                } else break;
            } else sb.append(curChar);
        }
        strList.add(sb.toString());
        String[] strArr = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            strArr[i] = strList.get(i);
        }
        return strArr;
    }

    public static String[] getMaxByteStringArray(String str, int maxLen) {
        return getMaxByteStringArray(str, maxLen, -1);
    }
}
