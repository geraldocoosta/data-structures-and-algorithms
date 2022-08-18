package org.example;

import java.util.Arrays;

public class MaximumUnitsOnTruck {

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(maximumUnits(boxTypes, 10));
    }


    // Time Complexity : O(nlogn), where n is the number of elements in array boxTypes.
    // Sorting the array boxTypes of size n takes (nlogn) time.
    // Post that, we iterate over each element in array boxTypes and in worst case,
    // we might end up iterating over all the elements in the array.
    // This gives us time complexity as O(nlogn)+O(n)=O(nlogn).
    //
    //Space Complexity: O(1), as we use constant extra space.
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // Pensando nesse problema, nós gostaríamos do maior número de unidades dentro do caminhão,
        // porém com um número de caixas 'boxTypes[][0]' que fique o mais proximo possível do truckSize

        // Sort do array
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int unitCount = 0;


        for (int i = 0; i < boxTypes.length; i++) {
            // Pego o maximo de caixas que consigo colocar no caminhão
            int boxCount = Math.min(truckSize, boxTypes[i][0]);
            // Adiciono a unitCount o total de unidade que consigo colocar no caminhão
            unitCount += boxCount * boxTypes[i][1];
            // Subtraio o total de caixas que coloquei no caminhão da capacidade total
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }
        return unitCount;
    }
}

/*
* Maximum Units on a Truck
*
* You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.



Example 1:

Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Explanation: There are:
- 1 box of the first type that contains 3 units.
- 2 boxes of the second type that contain 2 units each.
- 3 boxes of the third type that contain 1 unit each.
You can take all the boxes of the first and second types, and one box of the third type.
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
Example 2:

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91


Constraints:

1 <= boxTypes.length <= 1000
1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
1 <= truckSize <= 106
*
* */