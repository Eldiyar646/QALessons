package codingBat;

import java.util.Arrays;

public class Arrays_2 {
    public static void main(String[] args) {
        System.out.println(countEvens(new int[]{1, 3, 5}));
        System.out.println(sum13(new int[]{13, 1, 2, 13, 2, 1, 13}));
        System.out.println(sum67(new int[]{1, 1, 6, 7, 2}));
        System.out.println(has22(new int[]{1, 2, 2}));
        System.out.println(sum28(new int[]{1, 2, 3, 4}));
        System.out.println(only14(new int[]{1, 4, 1, 4}));
        System.out.println(lucky13(new int[]{1, 2, 4}));
        System.out.println(Arrays.toString(fizzArray2(4)));
        System.out.println((Arrays.toString(fizzArray(10))));
        System.out.println(more14(new int[]{1, 1}));
        System.out.println(no14(new int[]{1, 2, 3}));
        System.out.println(has12(new int[]{3, 1, 4, 5, 2}));
        System.out.println(has77(new int[]{1, 7, 1, 1, 7}));
        System.out.println(either24(new int[]{4, 4, 1, 2, 2}));
        System.out.println(twoTwo(new int[]{2, 2, 2}));
        System.out.println(withoutTen(new int[]{1, 10, 10, 2}));


    }
//    Given an array of ints, return true if every 2 that
//    appears in the array is next to another 2.
//    twoTwo([4, 2, 2, 3]) → true
//    twoTwo([2, 2, 4]) → true
//    twoTwo([2, 2, 4, 2]) → false

    public static boolean twoTwo(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                if (i + 1 < nums.length && nums[i + 1] == 2) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


//    Return a version of the given array where all the 10's have been removed.
//    The remaining elements should shift left towards the start of the array as
//    needed, and the empty spaces a the end of the array should be 0. So {1, 10, 10, 2}
//    yields {1, 2, 0, 0}. You may modify and return the given array or make a new array.
//    withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
//    withoutTen([10, 2, 10]) → [2, 0, 0]
//    withoutTen([1, 99, 10]) → [1, 99, 0]

    public static int[] withoutTen(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 10) {
                result[index] = nums[i];
                index++;
            }
        }
        return result;
    }


//    This is slightly more difficult version of the famous FizzBuzz problem which is sometimes given
//    as a first problem for job interviews. (See also: FizzBuzz Code.) Consider the series of numbers
//    beginning at start and running up to but not including end, so for example start=1 and end=5 gives
//    the series 1, 2, 3, 4. Return a new String[] array containing the string form of these numbers, except
//    for multiples of 3, use "Fizz" instead of the number, for multiples of 5 use "Buzz", and for multiples
//    of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx) will make the String form of an int or other type.
//    This version is a little more complicated than the usual version since you have to allocate and index into
//    an array instead of just printing, and we vary the start/end instead of just always doing 1..100.
//    fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
//    fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
//    fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]

    public static String[] fizzBuzz(int start, int end) {
        String[] result = new String[end - start];
        for (int i = start; i < end - 1; i++) {
            String value;
            if (i % 3 == 0 && i % 5 == 0) {
                value = "FizzBuzz";
            } else if (i % 3 == 0) {
                value = "Fizz";
            } else if (i % 5 == 0) {
                value = "Buzz";
            } else {
                value = String.valueOf(i);
            }
            result[i - start] = value;
        }
        return result;
    }


//    Given an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
//    either24([1, 2, 2]) → true
//    either24([4, 4, 1]) → true
//    either24([4, 4, 1, 2, 2]) → false

    public static boolean either24(int[] nums) {
        boolean has22 = false;
        boolean has44 = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) has22 = true;
            if (nums[i] == 4 && nums[i + 1] == 4) has44 = true;
        }
        return (has22 && !has44) || (!has22 && has44);
    }


//    Given an array of ints, return true if the array contains two 7's next to each other,
//    or there are two 7's separated by one element, such as with {7, 1, 7}.
//    has77([1, 7, 7]) → true
//    has77([1, 7, 1, 7]) → true
//    has77([1, 7, 1, 1, 7]) → false

    public static boolean has77(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == 7 && nums[i + 1] == 7) {
                return true;
            }
            if (i + 2 < nums.length && nums[i] == 7 && nums[i + 2] == 7) {
                return true;
            }
        }
        return false;
    }

//    Given an array of ints, return true if there is a 1 in the array with a 2 somewhere later in the array.
//    has12([1, 3, 2]) → true
//    has12([3, 1, 2]) → true
//    has12([3, 1, 4, 5, 2]) → true

    public static boolean has12(int[] nums) {

        boolean has1 = false;

        for (int num : nums) {
            if (num == 1) {
                has1 = true;
            } else if (has1 && num == 2) {
                return true;
            }
        }
        return false;
    }

//    Given an array of ints, return true if it contains no 1's or it contains no 4's.
//    no14([1, 2, 3]) → true
//    no14([1, 2, 3, 4]) → false
//    no14([2, 3, 4]) → true

    public static boolean no14(int[] nums) {
        boolean has1 = false;
        boolean has4 = false;

        for (int num : nums) {
            if (num == 1) {
                has1 = true;
            }
            if (num == 4) {
                has4 = true;
            }
        }
        return !(has1 && has4);
    }


//    Given an array of ints, return true if the number of 1's is greater than the number of 4's
//    more14([1, 4, 1]) → true
//    more14([1, 4, 1, 4]) → false
//    more14([1, 1]) → true

    public static boolean more14(int[] nums) {
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                countA++;
            }
            if (nums[i] == 4) {
                countB++;
            }
        }
        if (countA > countB) {
            return true;
        }
        return false;
    }

//    Given a number n, create and return a new int array of length n, containing the numbers 0, 1, 2, ... n-1.
//    The given n may be 0, in which case just return a length 0 array. You do not need a separate if-statement
//    for the length-0 case; the for-loop should naturally execute 0 times in that case, so it just works.
//    The syntax to make a new int array is: new int[desired_length]   (See also: FizzBuzz Code)
//    fizzArray(4) → [0, 1, 2, 3]
//    fizzArray(1) → [0]
//    fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    public static int[] fizzArray(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        return res;
    }


//    Given a number n, create and return a new string array of length n, containing the
//    strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a length
//    0 array. Note: String.valueOf(xxx) will make the String form of most types.
//    The syntax to make a new string array is: new String[desired_length]  (See also: FizzBuzz Code)
//    fizzArray2(4) → ["0", "1", "2", "3"]
//    fizzArray2(10) → ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
//    fizzArray2(2) → ["0", "1"]

    public static String[] fizzArray2(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = String.valueOf(i);
        }
        return res;
    }


//    Given an array of ints, return true if the array contains no 1's and no 3's.
//    lucky13([0, 2, 4]) → true
//    lucky13([1, 2, 3]) → false
//    lucky13([1, 2, 4]) → false

    public static boolean lucky13(int[] nums) {
        for (int num : nums) {
            if (num == 1 || num == 3) {
                return false;
            }
        }
        return true;
    }


//    Given an array of ints, return true if every element is a 1 or a 4.
//    only14([1, 4, 1, 4]) → true
//    only14([1, 4, 2, 4]) → false
//    only14([1, 1]) → true

    public static boolean only14(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1 && nums[i] != 4) {
                return false;
            }
        }
        return true;
    }


//    Given an array of ints, return true if the sum of all the 2's in the array is exactly 8.
//    sum28([2, 3, 2, 2, 4, 2]) → true
//    sum28([2, 3, 2, 2, 4, 2, 2]) → false
//    sum28([1, 2, 3, 4]) → false

    public static boolean sum28(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                sum += nums[i];
            }
        }
        if (sum == 8) {
            return true;
        }
        return false;
    }


//    Given an array of ints, return true if the array contains a 2 next to a 2 somewhere.
//    has22([1, 2, 2]) → true
//    has22([1, 2, 1, 2]) → false
//    has22([2, 1, 2]) → false

    public static boolean has22(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 2 && nums[i + 1] == 2) {
                return true;
            }
        }
        return false;
    }


//    Return the sum of the numbers in the array, except ignore sections of numbers
//    starting with a 6 and extending to the next 7 (every 6 will
//    be followed by at least one 7). Return 0 for no numbers.
//    sum67([1, 2, 2]) → 5
//    sum67([1, 2, 2, 6, 99, 99, 7]) → 5
//    sum67([1, 1, 6, 7, 2]) → 4

    public static int sum67(int[] nums) {
        int sum = 0;
        boolean inBlock = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 6) {
                inBlock = true;
            } else if (nums[i] == 7 && inBlock) {
                inBlock = false;
            } else if (!inBlock) {
                sum += nums[i];
            }
        }
        return sum;
    }

//    Return the number of even ints in the given array. Note: the % "mod" operator
//    computes the remainder, e.g. 5 % 2 is 1.
//    countEvens([2, 1, 2, 3, 4]) → 3
//    countEvens([2, 2, 0]) → 3
//    countEvens([1, 3, 5]) → 0

    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }


//    Return the sum of the numbers in the array, returning
//    0 for an empty array. Except the number 13 is very unlucky, so it does
//    not count and numbers that come immediately after a 13 also do not count.
//    sum13([1, 2, 2, 1]) → 6
//    sum13([1, 1]) → 2
//    sum13([1, 2, 2, 1, 13]) → 6

    public static int sum13(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                i++;
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }
}
