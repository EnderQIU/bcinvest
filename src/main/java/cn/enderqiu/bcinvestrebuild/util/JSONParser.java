package cn.enderqiu.bcinvestrebuild.util;

import java.util.List;
import java.util.Map;

public final class JSONParser {
    public static String parse(Map<String, Object> map) {
        StringBuilder r = new StringBuilder("{");
        for (String s:map.keySet()) {
            //能用连续append就别用+，后者开销太昂贵
            r.append("\"").append(s).append("\":");
            r.append("\"").append(map.get(s)).append("\"");
        }
        r.append("}");
        return r.toString();
    }

    public static String parse(List<Map<String, Object>> list) {
        StringBuilder r = new StringBuilder("{[");

        for (int i = 0; i < list.size(); ++i) {
            Map<String, Object> m = list.get(i);
            r.append(parse(m)).append((i + 1 == list.size() ? "" : "],["));
        }

        r.append("}");
        return r.toString();
    }
}
