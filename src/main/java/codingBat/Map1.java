package codingBat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Map1 {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "candy");
        map1.put("b", "dirt");
        System.out.println("Example 1: " + mapBully(map1));

        Map<String, String> map2 = new HashMap<>();
        map2.put("a", "aaa");
        map2.put("c", "meh");
        map2.put("d", "hi");
        System.out.println("Example 2: " + mapShare(map2));

        Map<String, String> map3 = new HashMap<>();
        map3.put("a", "Hi");
        map3.put("b", "There");
        System.out.println("Example 3: " + mapAB(map3));

        Map<String, String> map4 = new HashMap<>();
        map4.put("ice cream", "peanuts");
        map4.put("bread", "butter");
        map4.put("pancake", "syrup");
        System.out.println("Example 4: " + topping1(map4));

        Map<String, String> map5 = new HashMap<>();
        map5.put("ice cream", "cherry");
        map5.put("spinach", "dirt");
        map5.put("yogurt", "salt");
        System.out.println("Example 5: " + topping2(map5));

        Map<String, String> map6 = new HashMap<>();
        map6.put("potato", "butter");
        map6.put("potato", "ketchup");
        map6.put("salad", "oil");
        System.out.println("Example 6: " + topping3(map6));

        Map<String, String> map7 = new HashMap<>();
        map7.put("a", "aaa");
        map7.put("b", "aaa");
        map7.put("c", "cake");
        System.out.println("Example 7: " + mapAB2(map7));

        Map<String, String> map8 = new HashMap<>();
        map8.put("a", "aaa");
        map8.put("c", "cake");
        System.out.println("Example 8: " + mapAB3(map8));

        Map<String, String> map9 = new HashMap<>();
        map9.put("a", "aa");
        map9.put("b", "bbb");
        map9.put("c", "cake");
        System.out.println("Example 9: " + mapAB4(map9));


    }

    /* Modify and return the given map as follows: if the key "a" has a value, set the key "b"
    to have that value, and set the key "a" to have the value "". Basically "b" is a bully,
    taking the value and replacing it with the empty string.
    mapBully({"a": "candy", "b": "dirt"}) → {"a": "", "b": "candy"}
    mapBully({"a": "candy"}) → {"a": "", "b": "candy"}
    mapBully({"a": "candy", "b": "carrot", "c": "meh"}) → {"a": "", "b": "candy", "c": "meh"}
    */
    public static Map<String, String> mapBully(Map<String, String> map) {
        String aValue = map.get("a");
        if (aValue != null) {
            map.put("b", aValue);
            map.put("a", "");
        }
        return map;
    }

    /* Modify and return the given map as follows: if the key "a" has a value, set the key
    "b" to have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.
    mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
    mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
    mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
    */
    public static Map<String, String> mapShare(Map<String, String> map) {
        String aVal = map.get("a");
        if (aVal != null) {
            map.put("b", aVal);
        }
        map.remove("c");
        return map;
    }

    /*Modify and return the given map as follows: for this problem the
    map may or may not contain the "a" and "b" keys. If both keys are present,
    append their 2 string values together and store the result under the key "ab".
    mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
    mapAB({"a": "Hi"}) → {"a": "Hi"}
    mapAB({"b": "There"}) → {"b": "There"}
    */
    public static Map<String, String> mapAB(Map<String, String> map) {
        if (map.containsKey("a") && map.containsKey("b")) {
            String join = map.get("a") + map.get("b");
            map.put("ab", join);
        }
        return map;
    }
    
    /*Given a map of food keys and topping values, modify and return the
    map as follows: if the key "ice cream" is present, set its value to "cherry".
    In all cases, set the key "bread" to have the value "butter".
    topping1({"ice cream": "peanuts"}) → {"bread": "butter", "ice cream": "cherry"}
    topping1({}) → {"bread": "butter"}
    topping1({"pancake": "syrup"}) → {"bread": "butter", "pancake": "syrup"}
    */
    public static Map<String, String> topping1(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }
        map.put("bread", "butter");
        return map;
    }

    /*Given a map of food keys and their topping values, modify and return the map as follows:
    if the key "ice cream" has a value, set that as the value for the key "yogurt" also.
    If the key "spinach" has a value, change that value to "nuts".
    topping2({"ice cream": "cherry"}) → {"yogurt": "cherry", "ice cream": "cherry"}
    topping2({"spinach": "dirt", "ice cream": "cherry"}) → {"yogurt": "cherry", "spinach": "nuts", "ice cream": "cherry"}
    topping2({"yogurt": "salt"}) → {"yogurt": "salt"}
    */
    public static Map<String, String> topping2(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("yogurt", map.get("ice cream"));
        }
        if (map.containsKey("spinach")) {
            map.put("spinach", "nuts");
        }
        return map;
    }

    /*Given a map of food keys and topping values, modify and return the map as follows:
    if the key "potato" has a value, set that as the value for the key "fries".
    If the key "salad" has a value, set that as the value for the key "spinach".
    topping3({"potato": "ketchup"}) → {"potato": "ketchup", "fries": "ketchup"}
    topping3({"potato": "butter"}) → {"potato": "butter", "fries": "butter"}
    topping3({"salad": "oil", "potato": "ketchup"}) → {"spinach": "oil", "salad": "oil", "potato": "ketchup", "fries": "ketchup"}
    */
    public static Map<String, String> topping3(Map<String, String> map) {
        if (map.containsKey("potato")) {
            map.put("fries", map.get("potato"));
        }
        if (map.containsKey("salad")) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }

    /*Modify and return the given map as follows: if the keys "a" and "b" are both
    in the map and have equal values, remove them both.
    mapAB2({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
    mapAB2({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
    mapAB2({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
    */
    public static Map<String, String> mapAB2(Map<String, String> map) {
        if (Objects.equals(map.get("a"), map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }

    /*Modify and return the given map as follows: if exactly one of the keys "a" or "b"
    has a value in the map (but not both), set the other to have that same value in the map.
    mapAB3({"a": "aaa", "c": "cake"}) → {"a": "aaa", "b": "aaa", "c": "cake"}
    mapAB3({"b": "bbb", "c": "cake"}) → {"a": "bbb", "b": "bbb", "c": "cake"}
    mapAB3({"a": "aaa", "b": "bbb", "c": "cake"}) → {"a": "aaa", "b": "bbb", "c": "cake"}
    */
    public static Map<String, String> mapAB3(Map<String, String> map) {
        String aVal = map.get("a");
        String bVal = map.get("b");

        if (map.containsKey("a") && !map.containsKey("b")) {
            map.put("b", aVal);
        }
        if (!map.containsKey("a") && map.containsKey("b")) {
            map.put("a", bVal);
        }
        return map;
    }

    /*Modify and return the given map as follows: if the keys "a" and "b" have values
    that have different lengths, then set "c" to have the longer value. If the values
    exist and have the same length, change them both to the empty string in the map.
    mapAB4({"a": "aaa", "b": "bb", "c": "cake"}) → {"a": "aaa", "b": "bb", "c": "aaa"}
    mapAB4({"a": "aa", "b": "bbb", "c": "cake"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
    mapAB4({"a": "aa", "b": "bbb"}) → {"a": "aa", "b": "bbb", "c": "bbb"}
    */
    public static Map<String, String> mapAB4(Map<String, String> map) {
        String aVal = map.get("a");
        String bVal = map.get("b");

        if (map.containsKey("a") && map.containsKey("b")) {
            if (aVal.length() == bVal.length()) {
                map.put("a", "");
                map.put("b", "");
            } else if (aVal.length() > bVal.length()) {
                map.put("c", aVal);
            } else {
                map.put("c", bVal);
            }
        }
        return map;
    }
}