package leet1_100;

import java.util.HashMap;

public class leet4 {
    //两正序数组中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //时间复杂度过高
        int m = nums1.length, n = nums2.length;
        int count = 0,i = 0,j = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (i < m && j < n){
            if (nums1[i] <= nums2[j]){
                map.put(count,nums1[i]);
                i++;
            }
            else {
                map.put(count,nums2[j]);
                j++;
            }
            if (count == (m + n)/2 && (m + n)%2 == 1)return map.get(count);
            else if (count == (m + n)/2 && (m + n)%2 == 0)
                return ((double)map.get(count - 1) + (double)map.get(count))/2;
            count++;
        }
        while (i < m){
            map.put(count,nums1[i]);
            if (count == (m + n)/2 && (m + n)%2 == 1)return map.get(count);
            else if (count == (m + n)/2 && (m + n)%2 == 0)
                return ((double)map.get(count - 1) + (double)map.get(count))/2;
            i++;
            count++;
        }
        while (j < n){
            map.put(count,nums2[j]);
            if (count == (m + n)/2 && (m + n)%2 == 1)return map.get(count);
            else if (count == (m + n)/2 && (m + n)%2 == 0)
                return ((double)map.get(count - 1) + (double)map.get(count))/2;
            j++;
            count++;
        }
        return -1;
    }

    public static double findMedianSortedArrays_plus(int[] nums1, int[] nums2) {
        //采用二分法降低时间复杂度
        int length1 = nums1.length,length2 = nums2.length;
        if ((length1 + length2)%2 == 1){
            int midindex = (length1 + length2)/2;
            return findans(nums1,nums2,midindex + 1);
        }else {
            int midindex1 = (length1 + length2)/2,midindex2 = (length1 + length2)/2 - 1;
            return ((double) findans(nums1,nums2,midindex1 + 1) + (double) findans(nums1,nums2,midindex2 + 1))/2;
        }
    }

    public static int findans(int[] nums1, int[] nums2, int k){
        //找第k个元素值
        int length1 = nums1.length,length2 = nums2.length;
        int index1 = 0,index2 = 0;
        while (true){
            //处理边界
            if (index1 == length1)return nums2[index2 + k - 1];
            else if(index2 == length2)return nums1[index1 + k - 1];
            else if(k == 1)return Math.min(nums1[index1],nums2[index2]);

            int half = k/2;
            int newindex1 = Math.min(index1 + half,length1) - 1;
            int newindex2 = Math.min(index2 + half,length2) - 1;
            if(nums1[newindex1] <= nums2[newindex2]){
                k -= newindex1 - index1 + 1;
                index1 = newindex1 + 1;
            }else {
                k -= newindex2 - index2 + 1;
                index2 = newindex2 + 1;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays_plus(a,b));
    }
}
