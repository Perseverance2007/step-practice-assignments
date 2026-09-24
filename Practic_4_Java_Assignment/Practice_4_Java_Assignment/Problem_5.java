// L5: Rotate Array
import java.util.Arrays;

public class Problem_5 {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotateArray(nums1, 3)));

        int[] nums2 = {1, 2};
        System.out.println(Arrays.toString(rotateArray(nums2, 3)));
    }
}
