package org.example.sortexamples;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0,0,2,1,0,1,2,0,2,1,0};
        sort(arr);
        System.out.println(
                Arrays.toString(arr)
        );
    }


    public static void sort(int[] nums) {

        var length = nums.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public static void heapify(int[] nums, int finalIndex, int index) {
        var largest = index;
        var l = largest * 2 + 1;
        var r = largest * 2 + 2;

        if (l < finalIndex && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < finalIndex && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != index){
            swap(nums, index, largest);
            heapify(nums, finalIndex, largest);
        }
    }

    public static void swap(int[] nums, int index1 , int index2) {
        var aux = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = aux;
    }
}
