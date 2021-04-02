package nickname.basic.day14;

import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public static void main(String[] args) {
        // hashmap
        // map인터페이스를 구현한 자료구조
        // 키와 값으로 구성된 Entry객체를 저장하는 구조
        // 값은 중복될 수 있지만, 키는 중복될 수 없음
        // 키는 hashing을 이용해서 저장하기 때문에
        // 많은 양의 데이터를 검색할때 뛰어난 성능을 보임

        // 해시값 : 복사된 디지털 증거의 동일성을 입증하기 위해
        // 파일 특성을 축약한 암호같은 수치를 의미
        // 이것을 통해 파일의 변조나 무결성을 알 수 있음
        // 주로 사용되는 해시 알고리즘은 CRC32, MD5, SHA-1
        // fileformat.info/tool/hash.htm

        Map<String, String> names = new HashMap<>();
        names.put("H", "혜교");  // 객체추가시 put(키, 값)
        names.put("S", "수지");
        names.put("J", "지현");

        // 값 출력 : get(키)
        System.out.println(names.get("S"));
        System.out.println(names.get("J"));
        System.out.println(names);

        // 전체 값 출력 : keySet() 활용
        // 많은 양의 데이터 출력시 많은 시간 소요
        for(String k : names.keySet()){
            System.out.print(names.get(k) + " ");
        }
        System.out.println("");

        // 전체 값 출력 : entrySet() 활용  (추천!)
        // getValue(), getKey()를 이용해서 키와 값 출력 가능
        for(Map.Entry<String, String> e : names.entrySet()) {
            System.out.print( e.getValue()  + " ");
        }
        System.out.println("");

        // 특정 데이타 찾기 : containsKey, containsValue
        System.out.println( names.containsKey("H") );
        System.out.println( names.containsValue("혜교") );

        // 값 수정하기 : set 없음
        // 키를 기준으로 remove한 뒤 새로 put하면 됨
        names.remove("H");
        names.put("h", "혜교");

        // 또는 replace를 이용해도 됨
        // 단, 키가 값이 변경됨
        System.out.println(names.get("h"));
        names.replace("h", "HeKyo");
        System.out.println(names.get("h"));

    }
}
