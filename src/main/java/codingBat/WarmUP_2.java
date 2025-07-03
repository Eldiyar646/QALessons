package codingBat;

public class WarmUP_2 {
    public static void main(String[] args) {

        System.out.println(stringSplosion("Code"));
        System.out.println(stringBits("Hello"));


    }


        //    Given a string, return a new string made of every other char
        //    starting with the first, so "Hello" yields "Hlo".

        public static String stringBits (String str){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i += 2) {
                sb.append(str.charAt(i));
            }
            return sb.toString();

        }

        //    Given a non-empty string like "Code" return a string like "CCoCodCode".
        public static String stringSplosion (String str){
            StringBuilder sb1 = new StringBuilder();

            for (int i = 1; i <= str.length(); i++) {
                sb1.append(str.substring(0, i));
            }
            return sb1.toString();
        }

        //    Given a string, return the count of the number of
        //    times that a substring length 2 appears in the string and also
        //    as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
        public static int last2 (String str){
            if (str.length() < 2) {
                return 0;
            }
            String last2 = str.substring(str.length() - 2);
            int count = 0;
            for (int i = 0; i < str.length() - 2; i++) {
                String sub = str.substring(i, i + 2);
                if (sub.equals(last2)) {
                    count++;
                }
            }
            return count;
        }

        //    Given an array of ints, return the number of 9's in the array.
        public static int arrayCount9 ( int[] nums){
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 9) {
                    count++;
                }
            }
            return count;
        }


//    Given an array of ints, return true if one of the first 4
//    elements in the array is a 9. The array length may be less than 4.
//    arrayFront9([1, 2, 9, 3, 4]) → true
//    arrayFront9([1, 2, 3, 4, 9]) → false
//    arrayFront9([1, 2, 3, 4, 5]) → false

        public static boolean arrayFront9 ( int[] nums){
            int limit = 4;
            if (nums.length < 4) {
                limit = nums.length;
            }

            for (int i = 0; i < limit; i++) {
                if (nums[i] == 9) return true;
            }
            return false;
        }


//    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
//    array123([1, 1, 2, 3, 1]) → true
//    array123([1, 1, 2, 4, 1]) → false
//    array123([1, 1, 2, 1, 2, 3]) → true

        public static boolean array123 ( int[] nums){
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) return true;
            }
            return false;
        }

//    Given 2 strings, a and b, return the number of the positions where they
//    contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
//    since the "xx", "aa", and "az" substrings appear in the same place in both strings.
//    stringMatch("xxcaazz", "xxbaaz") → 3
//    stringMatch("abc", "abc") → 2
//    stringMatch("abc", "axc") → 0

        public static int stringMatch (String a, String b){
            int count = 0;
            int minlength = Math.min(a.length(), b.length());

            for (int i = 0; i < minlength - 1; i++) {
                if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                    count++;
                }
            }
            return count;
        }

//    Given a string, return a version where all the "x" have been removed.
//    Except an "x" at the very start or end should not be removed.
//    stringX("xxHxix") → "xHix"
//    stringX("abxxxcd") → "abcd"
//    stringX("xabxxxcdx") → "xabcdx"

        public static String stringX (String str){
            if (str.length() <= 2) {
                return str;
            }
            String start = str.substring(0, 1);
            String middle = str.substring(1, str.length() - 1).replace("x", "");
            String end = str.substring(str.length() - 1);

            return start + middle + end;
        }


//    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
//    altPairs("kitten") → "kien"
//    altPairs("Chocolate") → "Chole"
//    altPairs("CodingHorror") → "Congrr"

        public static String altPairs (String str){
            String result = "";
            for (int i = 0; i < str.length(); i += 4) {
                result += str.charAt(i);
                if (i + 1 < str.length()) {
                    result += str.charAt(i + 1);
                }
            }
            return result;
        }


//    Suppose the string "yak" is unlucky. Given a string, return a version where all
//    the "yak" are removed, but the "a" can be any char. The "yak" strings will not overlap.
//    stringYak("yakpak") → "pak"
//    stringYak("pakyak") → "pak"
//    stringYak("yak123ya") → "123ya"

        public static String stringYak (String str){
            String result1 = "";
            for (int i = 0; i < str.length(); ) {
                if (i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
                    i += 3;
                } else {
                    result1 += str.charAt(i);
                    i++;
                }
            }
            return result1;
        }


//    Given an array of ints, return the number of times that
//    two 6's are next to each other in the array.
//    Also count instances where the second "6" is actually a 7.
//    array667([6, 6, 2]) → 1
//    array667([6, 6, 2, 6]) → 1
//    array667([6, 7, 2, 6]) → 1

        public static int array667 ( int[] nums){
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 6 && nums[i + 1] == 6 || nums[i + 1] == 7) {
                    count++;
                }
            }
            return count;
        }


//    Given an array of ints, we'll say that a triple is a value appearing
//    3 times in a row in the array. Return true if the array does not contain any triples.
//    noTriples([1, 1, 2, 2, 1]) → true
//    noTriples([1, 1, 2, 2, 2, 1]) → false
//    noTriples([1, 1, 1, 2, 2, 2, 1]) → false


        public static boolean noTriples ( int[] nums){
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
                    return false;
                }
            }
            return true;
        }


}