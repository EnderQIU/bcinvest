package cn.enderqiu.bcinvestrebuild.util;

public class ParameterJudge {
    public static boolean judge(String str) {
        for (char c:str.toCharArray())
            if (!(((int)c >= (int)'0'
            && (int)c <= (int)'9')
            || ((int)c >= (int)'A'
            && (int)c <= (int)'Z')
            || ((int)c <= (int)'a'
            && (int)c >= (int)'z')
            || c == '-'
            || c== '_'))
                return false;
        return true;
    }
}
