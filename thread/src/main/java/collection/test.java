package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/14
 */
public class test {


    public static void main(String args[]){
        ConcurrentHashMap<String,Object>hashMap = new ConcurrentHashMap<>();
        hashMap.put("aaa","bbb");
        hashMap.put("aaa","ccc");
        System.out.println(hashMap);

    }
}
