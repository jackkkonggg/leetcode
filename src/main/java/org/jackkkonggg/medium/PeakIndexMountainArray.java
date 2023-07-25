package org.jackkkonggg.medium;

public class PeakIndexMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length, left = 0, right = length - 1, boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == length - 1 || arr[mid] > arr[mid + 1]) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }
}
