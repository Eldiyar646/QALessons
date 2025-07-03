package codingBat;

import java.util.Arrays;

public class Arrays_1 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(swapEnds(new int[]{8, 6, 7, 9, 5})));
        System.out.println(maxTriple(new int[]{5, 2, 3}));
        System.out.println(Arrays.toString(make2(new int[]{}, new int[]{1, 2, 3})));


    }

    //swapEnds
    public static int[] swapEnds(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[nums.length - 1];
        nums[nums.length - 1] = temp;
        return nums;
    }


//    Given an array of ints of odd length, look at the first, last,
//    and middle values in the array and return the largest. The array length will be a least 1.
//    maxTriple([1, 2, 3]) → 3
//    maxTriple([1, 5, 3]) → 5
//    maxTriple([5, 2, 3]) → 5

    public static int maxTriple(int[] nums) {
        int firstArr = nums[0];
        int middleArr = nums[nums.length / 2];
        int lastArr = nums[nums.length - 1];

        return Math.max(firstArr, Math.max(lastArr, middleArr));
    }


//    Given an int array of any length, return a new array of its first 2 elements.
//    If the array is smaller than length 2, use whatever elements are present.
//    frontPiece([1, 2, 3]) → [1, 2]
//    frontPiece([1, 2]) → [1, 2]
//    frontPiece([1]) → [1]

    public int[] frontPiece(int[] nums) {

        if (nums.length >= 2) {
            return new int[]{nums[0], nums[1]};
        }
        if (nums.length == 1) {
            return new int[]{nums[0]};
        } else {
            return new int[]{};
        }
    }

//        Given 2 int arrays, a and b, return a new array length 2 containing,
//        as much as will fit, the elements from a followed by the elements from b.
//        The arrays may be any length, including 0, but there will be 2 or more
//        elements available between the 2 arrays.
//        make2([4, 5], [1, 2, 3]) → [4, 5]
//        make2([4], [1, 2, 3]) → [4, 1]
//        make2([], [1, 2]) → [1, 2]

    public static int[] make2(int[] a, int[] b) {

        int res[] = new int[2];
        int count = 0;

        for (int i = 0; i < a.length && count < 2; i++) {
            res[count] = a[i];
            count++;
        }

        for (int i = 0; i < b.length && count < 2; i++) {
            res[count] = b[i];
            count++;
        }
        return res;
    }

//    Given an int array, return a new array with double the length where its last element
//    is the same as the original array, and all the other elements are 0. The original
//    array will be length 1 or more. Note: by default, a new int array contains all 0's.
//    makeLast([4, 5, 6]) → [0, 0, 0, 0, 0, 6]
//    makeLast([1, 2]) → [0, 0, 0, 2]
//    makeLast([3]) → [0, 3]

    public int[] makeLast(int[] nums) {
        int res[] = new int[nums.length * 2];
        res[res.length - 1] = nums[nums.length - 1];
        return res;
    }
//    Given 2 int arrays, a and b, of any length, return a new array with the first element
//    of each array. If either array is length 0, ignore that array.
//    front11([1, 2, 3], [7, 9, 8]) → [1, 7]
//    front11([1], [2]) → [1, 2]
//    front11([1, 7], []) → [1]

    public int[] front11(int[] a, int[] b) {
        if (a.length >= 1 && b.length >= 1) {
            return new int[]{a[0], b[0]};
        } else if (a.length >= 1) {
            return new int[]{a[0]};
        } else if (b.length >= 1) {
            return new int[]{b[0]};
        } else {
            return new int[]{};
        }
    }
}