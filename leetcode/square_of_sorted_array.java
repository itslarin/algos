/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

i1: [-4,-1,0,3,10]
o1: [0,1,9,16,100]

i2: [-7,-3,2,3,11]
o2: [4,9,9,49,121]
*/






class Solution {
    public int[] sortedSquares2(int[] nums) { //straight solution with o(n*log(n)) complexity
        return IntStream.of(nums)
        .map(elt -> elt * elt)
        .sorted()
        .toArray();

    }

    public int[] sortedSquares(int[] nums) { //optimised solution with 
        int[] arrNeg = IntStream.of(nums)
            .filter(elt -> elt <= 0)
            .map(elt -> elt * elt)            
            .toArray();
        reverse(arrNeg);
        int[] arrPos = IntStream.of(nums)
            .filter(elt -> elt > 0)
            .map(elt -> elt * elt)
            .toArray();


        return merge(arrNeg, arrPos);
    }


    public void reverse(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;            
        }
    }


    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i=0,j=0,k=0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            }
            else {
                result[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            k++;
            j++;
        }
        return result;
    }
}