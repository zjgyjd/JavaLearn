import java.util.*;

public class DateBase {
    private DateBase() {
        stringMap = new HashMap<>();
        hashes = new HashMap<>();
        lists = new HashMap<>();
        sets = new HashMap<>();
        zsets = new HashMap<>();
    }

    private static DateBase instance = new DateBase();

    public static DateBase getInstance() {
        return instance;
    }

    //String类型
    private Map<String, String> stringMap;

    //hash类型
    private Map<String, Map<String, String>> hashes;

    //list类型
    private Map<String, List<String>> lists;

    //set类型
    private Map<String, Set<String>> sets;

    //zset类型
    private Map<String, LinkedHashSet<String>> zsets;

    public List<String> getList(String key) {
        List<String> list = lists.get(key);
        if (list == null) {
            list = new ArrayList<>();
            lists.put(key, list);
        }
        return list;
    }
}
