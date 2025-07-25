package codingBat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Map2 {
    public static void main(String[] args) {

        System.out.println("Example 1: " + word0(new String[]{"a", "b", "a", "b"}));
        System.out.println("Example 2: " + wordLen(new String[]{"this", "and", "that", "and"}));
        System.out.println("Example 3: " + pairs(new String[]{"man", "moon", "good", "night"}));
        System.out.println("Example 4: " + wordCount(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println("Example 5: " + firstChar(new String[]{"salt", "tea", "soda", "toast"}));
        System.out.println("Example 6: " + wordAppend(new String[]{"a", "b", "a"}));
        System.out.println("Example 7: " + wordMultiple(new String[]{"a", "b", "a", "c", "b"}));
        System.out.println("Example 8: " + Arrays.toString(allSwap(new String[]{"ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"})));
        System.out.println("Example 9: " + Arrays.toString(allSwap(new String[]{"ax", "bx", "ay", "by", "ai", "aj", "bx", "by"})));


    }


    /* Given an array of strings, return a Map<String, Integer> containing a key for every
    different string in the array, always with the value 0. For example the string "hello"
    makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
    word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
    word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
    word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
    */
    public static Map<String, Integer> word0(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, 0);
        }
        return map;
    }

    /* Given an array of strings, return a Map<String, Integer> containing a key for every
    different string in the array, and the value is that string's length.
    wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
    wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
    wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
    */
    public static Map<String, Integer> wordLen(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, str.length());
        }
        return map;
    }

    /* Given an array of non-empty strings, create and return a Map<String, String> as follows:
    for each string add its first character as a key with its last character as the value.
    pairs(["code", "bug"]) → {"b": "g", "c": "e"}
    pairs(["man", "moon", "main"]) → {"m": "n"}
    pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
    */
    public static Map<String, String> pairs(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String str : strings) {
            map.put(String.valueOf(str.charAt(0)), String.valueOf(str.charAt(str.length() - 1)));
        }
        return map;
    }

    /*The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
    with a key for each different string, with the value the number of times that string appears in the array.
    wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
    wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
    wordCount(["c", "c", "c", "c"]) → {"c": 4}
    */
    public static Map<String, Integer> wordCount(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }

    /*Given an array of non-empty strings, return a Map<String, String> with a key for
    every different first character seen, with the value of all the strings starting
    with that character appended together in the order they appear in the array.
    firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
    firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
    firstChar([]) → {}
    */
    public static Map<String, String> firstChar(String[] strings) {
        Map<String, String> map = new HashMap<>();
        for (String s : strings) {
            String firstChar = String.valueOf(s.charAt(0));
            String allWord = map.getOrDefault(firstChar, "");
            map.put(firstChar, allWord + s);
        }
        return map;
    }


    /*Loop over the given array of strings to build a result string like this: when a string appears
    the 2nd, 4th, 6th, etc. time in the array, append the string to the result.
    Return the empty string if no string appears a 2nd time.
    wordAppend(["a", "b", "a"]) → "a"
    wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
    wordAppend(["a", "", "a"]) → "a"
    */
    public static String wordAppend(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            int count = map.getOrDefault(s, 0) + 1;
            map.put(s, count);

            if (count % 2 == 0) {
                result.append(s);
            }
        }
        return result.toString();
    }

    /*Given an array of strings, return a Map<String, Boolean> where each different string
    is a key and its value is true if that string appears 2 or more times in the array.
    wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
    wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
    wordMultiple(["c", "c", "c", "c"]) → {"c": true}
    */
    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, Boolean> result = new HashMap<>();

        for (String s : strings) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        for (String key : count.keySet()) {
            result.put(key, count.get(key) >= 2);
        }
        return result;
    }


    /*We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string matches
    an earlier string in the array, swap the 2 strings in the array. When a position in the
    array has been swapped, it no longer matches anything. Using a map, this can be solved
    making just one pass over the array. More difficult than it looks.
    allSwap(["ab", "ac"]) → ["ac", "ab"]
    allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
    allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
    */
    public static String[] allSwap(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char firstChar = strings[i].charAt(0);

            if (map.containsKey(firstChar)) {
                int firstIndex = map.get(firstChar);
                String temp = strings[i];
                strings[i] = strings[firstIndex];
                strings[firstIndex] = temp;

                map.remove(firstChar);
            } else {
                map.put(firstChar, i);
            }
        }
        return strings;
    }


    /*We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
    Loop over and then return the given array of non-empty strings as follows: if a string matches
    an earlier string in the array, swap the 2 strings in the array. A particular first char can only
    cause 1 swap, so once a char has caused a swap, its later swaps are disabled. Using a map, this can
    be solved making just one pass over the array. More difficult than it looks.
    firstSwap(["ab", "ac"]) → ["ac", "ab"]
    firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
    firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
    */
    public static String[] firstSwap(String[] strings) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Boolean> swapped = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char ch = strings[i].charAt(0);

            if (swapped.getOrDefault(ch, false)) {
                continue;
            }

            if (map.containsKey(ch)) {
                int ch2 = map.get(ch);
                String temp = strings[i];
                strings[i] = strings[ch2];
                strings[ch2] = temp;

                swapped.put(ch, true);
                map.remove(ch);
            } else {
                map.put(ch, i);
            }
        }
        return strings;
    }


}