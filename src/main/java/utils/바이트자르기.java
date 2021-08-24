package utils;

import java.util.ArrayList;

public class 바이트자르기 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        String str = sb.toString();
        String newStr = getMaxByteString(str, 5);
        System.out.println(newStr + ":" + newStr.getBytes().length);
        System.out.println("-----------------------------------------");
        String[] strArr = getMaxByteStringArray(str, 5);
        for (String s : strArr) {
            System.out.println(s + ":" + s.getBytes().length);
        }
        System.out.println("-----------------------------------------");
        String[] strArr2 = getMaxByteStringArray(str, 5, 3);
        for (String s : strArr2) {
            System.out.println(s + ":" + s.getBytes().length);
        }
    }
    public static String getMaxByteString(String str, int maxLen) {
        StringBuilder sb = new StringBuilder();
        int curLen = 0;
        String curChar;
        for (int i = 0; i < str.length(); i++) {
            curChar = str.substring(i, i + 1);
            curLen += curChar.getBytes().length;
            if (curLen > maxLen) break;
            else sb.append(curChar);
        }
        return sb.toString();
    }

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
