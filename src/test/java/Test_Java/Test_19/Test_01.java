package Test_Java.Test_19;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Test_01 {

    Map<String, String> mapOneOrAnother(Map<String, String> inputMap) {

        if (inputMap.containsKey("a") && inputMap.containsKey("b")) {
            return inputMap;
        } else if (inputMap.containsKey("a")) {
            inputMap.put("b", inputMap.get("a"));
        } else if (inputMap.containsKey("b")) {
            inputMap.put("a", inputMap.get("b"));
        }
        return inputMap;
    }

    @Test
    void test01() {

        Map<String, String> targetMap = new HashMap<>();

        targetMap.put("b", "bbb");
        targetMap.put("c", "cake");

        System.out.println(mapOneOrAnother(targetMap));
    }
    public Map<String,String> longestMap (Map<String,String> inputMap){

if (inputMap.containsKey("a")&&inputMap.containsKey("b")){

    if(inputMap.get("a").length()>inputMap.get("b").length()){
        inputMap.replace("b",inputMap.get("a"));
    }else if (inputMap.get("b").length()>inputMap.get("a").length()){
        inputMap.replace("a",inputMap.get("b"));
    }
}
     return inputMap;
    }
}
