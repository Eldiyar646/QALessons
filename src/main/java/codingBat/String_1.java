package codingBat;

public class String_1 {
    public static void main(String[] args) {

        System.out.println(theEnd("Hello", true));
        System.out.println(twoChar("java", 3));
        System.out.println(nTwice("Chocolate", 3));
        System.out.println(hasBad("xxbadxx"));
        System.out.println(minCat("Hello", "Hi"));
        System.out.println(extraFront("ab"));
        System.out.println(without2("HelloHe"));
        System.out.println(deFront("away"));

    }

    //    Given a string, return a string length 1 from its front,
//    unless front is false, in which case return a string length
//    1 from its back. The string will be non-empty.
//    theEnd("Hello", true) → "H";   theEnd("Hello", false) → "o";     theEnd("oh", true) → "o"
    public static String theEnd(String str, boolean front) {
        if (front) {
            return str.substring(0, 1);
        } else {
            return str.substring(str.length() - 1);
        }
    }

//    Given a string and an index, return a string length 2 starting at the given index.
//    If the index is too big or too small to define a string length 2,
//    use the first 2 chars. The string length will be at least 2.
//    twoChar("java", 0) → "ja";  twoChar("java", 2) → "va";  twoChar("java", 3) → "ja"

    public static String twoChar(String str, int index) {
        if (index < 0 || index > str.length() - 2) {
            return str.substring(0, 2);
        } else {
            return str.substring(index, index + 2);
        }
    }


//    Given a string and an int n, return a string made of the
//    first and last n chars from the string. The string length will be at least n.
//    nTwice("Hello", 2) → "Helo"
//    nTwice("Chocolate", 3) → "Choate"
//    nTwice("Chocolate", 1) → "Ce"

    public static String nTwice(String str, int n) {
        String result = "";
        String str1 = str.substring(0, n);
        String str2 = str.substring(str.length() - n);
        return result = str1 + str2;
    }


//    Given a string, return true if "bad" appears starting at index 0 or 1
//    in the string, such as with "badxxx" or "xbadxx" but not "xxbadxx".
//    The string may be any length, including 0. Note: use .equals() to compare 2 strings.
//    hasBad("badxx") → true;   hasBad("xbadxx") → true;    hasBad("xxbadxx") → false

    public static boolean hasBad(String str) {
        if (str.length() >= 3) {
            if (str.substring(0, 3).equals("bad")) {
                return true;
            }
            if (str.length() >= 4 && str.substring(1, 4).equals("bad"))
                return true;
        }
        return false;
    }

//    Given two strings, append them together (known as "concatenation") and
//    return the result. However, if the concatenation creates a double-char,
//    then omit one of the chars, so "abc" and "cat" yields "abcat".
//    conCat("abc", "cat") → "abcat";  conCat("dog", "cat") → "dogcat";   conCat("abc", "") → "abc"

    public String conCat(String a, String b) {
        if (a.length() > 0 && b.length() > 0 && a.charAt(a.length() - 1) == b.charAt(0)) {
            return a + b.substring(1);
        } else {
            return a + b;
        }
    }

//    Given a string of any length, return a new string where the last
//    2 chars, if present, are swapped, so "coding" yields "codign".
//    lastTwo("coding") → "codign";   lastTwo("cat") → "cta";    lastTwo("ab") → "ba"

    public String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        String one = str.substring(0, str.length() - 2);
        char two = str.charAt(str.length() - 1);
        char three = str.charAt(str.length() - 2);
        return one + two + three;
    }

//    Given a string, return true if the first 2 chars in the
//    string also appear at the end of the string, such as with "edited".
//    frontAgain("edited") → true;   frontAgain("edit") → false;    frontAgain("ed") → true

    public boolean frontAgain(String str) {
        if (str.length() < 2) {
            return false;
        }
        String s = str.substring(0, 2);
        String ss = str.substring(str.length() - 2);
        return s.equals(ss);
    }


//    Given two strings, append them together (known as "concatenation")
//    and return the result. However, if the strings are different lengths,
//    omit chars from the longer string so it is the same length as the shorter string.
//    So "Hello" and "Hi" yield "loHi". The strings may be any length.
//    minCat("Hello", "Hi") → "loHi"
//    minCat("Hello", "java") → "ellojava"
//    minCat("java", "Hello") → "javaello"


    public static String minCat(String a, String b) {
        int minLength = Math.min(a.length(), b.length());

        String str1 = a.substring(a.length() - minLength);
        String str2 = b.substring(b.length() - minLength);

        return str1 + str2;
    }


//    Given a string, return a new string made of 3 copies of the first
//    2 chars of the original string. The string may be any length.
//    If there are fewer than 2 chars, use whatever is there.
//    extraFront("Hello") → "HeHeHe";    extraFront("ab") → "ababab"
//    extraFront("H") → "HHH"

    public static String extraFront(String str) {
        if (str.length() <= 2) {
            return str + str + str;
        }
        String str1 = str.substring(0, 2);
        return str1 + str1 + str1;
    }


//    Given a string, if a length 2 substring appears at both its beginning and end,
//    return a string without the substring at the beginning, so "HelloHe" yields "lloHe".
//    The substring may overlap with itself, so "Hi" yields "". Otherwise, return the original string unchanged.
//    without2("HelloHe") → "lloHe";   without2("HelloHi") → "HelloHi"
//    without2("Hi") → ""

//    1. Проверим, что строка длиной хотя бы **2 символа** (иначе нельзя взять подстроку длины 2).
//            2. Возьмём:
//            - `start = str.substring(0, 2)`
//            - `end = str.substring(str.length() - 2)`
//            3. Если `start.equals(end)` — возвращаем `str.substring(2)`
//            4. Иначе — возвращаем `str` без изменений

    public static String without2(String str) {
        if (str.length() >= 2) {
            String start = str.substring(0, 2);
            String end = str.substring(str.length() - 2);
            if (start.equals(end)) {
                return str.substring(2);
            }
        }
        return str;
    }


//    Given a string, return a version without the first 2 chars.
//    Except keep the first char if it is 'a' and keep the second
//    char if it is 'b'. The string may be any length. Harder than it looks.
//    deFront("Hello") → "llo";    deFront("java") → "va";    deFront("away") → "aay"

    //    1. Начнём с пустой строки `result`.
//    2. Если **первый символ = 'a'**, добавим его в `result`.
//    3. Если **второй символ = 'b'**, добавим его в `result`.
//    4. К `result` добавим **всё, начиная с позиции 2** (т.е. `str.substring(2)`).
//    5. Вернём `result`.
    public static String deFront(String str) {

        String result = "";

        if (str.length() > 1 && str.charAt(0) == ('a')) {
            result += "a";
        }
        if (str.length() > 2 && str.charAt(1) == ('b')) {
            result += "b";
        }
        if (str.length() > 2) {
            result += str.substring(2);
        }
        return result;
    }


//    Given a string, if the first or last chars are 'x',
//    return the string without those 'x' chars, and otherwise return the string unchanged.
//    withoutX("xHix") → "Hi";    withoutX("xHi") → "Hi";    withoutX("Hxix") → "Hxi"

    public String withoutX(String str) {
        if (str.length() >= 1 && str.charAt(0) == 'x') {
            str = str.substring(1);
        }
        if (str.length() >= 1 && str.charAt(str.length() - 1) == 'x') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }


//    Given a string and a second "word" string, we'll say that the word matches
//    the string if it appears at the front of the string, except its first char
//    does not need to match exactly. On a match, return the front of the string,
//    or otherwise return the empty string. So, so with the string "hippo" the word
//    "hi" returns "hi" and "xip" returns "hip". The word will be at least length 1.
//    startWord("hippo", "hi") → "hi"
//    startWord("hippo", "xip") → "hip"
//    startWord("hippo", "i") → "h"

    public String startWord(String str, String word) {
        int len = word.length();

        if (str.length() < len) {
            return "";
        }

        String s = str.substring(1, len);
        String ss = word.substring(1);

        if (s.equals(ss)) {
            return str.substring(0, len);
        }
        return "";
    }


}