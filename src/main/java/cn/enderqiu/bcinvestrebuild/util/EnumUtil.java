package cn.enderqiu.bcinvestrebuild.util;

public abstract class EnumUtil {

    public static String statusToString(int status) {
        switch (status){
            case 0:
                return "unapplied";
            case 1:
                return "checking";
            case 2:
                return "unpassed";
            case 3:
                return "passed";
        }
        return "process_failed";
    }

}
