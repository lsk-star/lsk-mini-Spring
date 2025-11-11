package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Shuokang
 * @date 2025/11/11
 */
public class UserDao {
    private static Map<String, String> MAP= new HashMap<>();

    static {
        MAP.put("10001", "张三");
        MAP.put("10002", "李四");
        MAP.put("10003", "王五");
    }

    public String queryUserName(String uId) {
        return MAP.get(uId);
    }
}
