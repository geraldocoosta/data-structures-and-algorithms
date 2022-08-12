package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    // Time Complexity O(M N logN)
    //    First of all, the time complexity of the Arrays.sort() is O(N⋅logN), as stated in the API specification, which is to say that the compare() function would be invoked O(N⋅logN) times.
    //    For each invocation of the compare() function, it could take up to O(M) time, since we compare the contents of the logs.
    //
    //Space Complexity: O(M logN)
    //    For each invocation of the compare() function, we would need up  up to O(M) space to hold the parsed logs
    //    Arrays.sort is based on quicksort and uses O(logN) space in average case and O(N) in worst case.
    public static String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs, (log1, log2) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            if (!isDigit1 && isDigit2)
                return -1;
            else if (isDigit1 && !isDigit2)
                return 1;
            else
                return 0;
        });
        return logs;
    }
}


/*
* Reorder Data in Log Files
*
* You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


Constraints:

1 <= logs.length <= 100
3 <= logs[i].length <= 100
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier.
* */