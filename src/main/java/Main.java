import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static utils.바이트자르기.getMaxByteStringArray;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyz");
        }
        String string = sb.toString();
        String[] strArr = getMaxByteStringArray(string, 5);

        String test = Arrays.stream(strArr).map(str -> {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("to_clob('");
            sb2.append(str);
            sb2.append("')");
            return sb2.toString();
        }).collect(Collectors.joining(" || "));

        System.out.println(test);
    }

}