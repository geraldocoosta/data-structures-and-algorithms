package org.example;

import java.util.HashMap;

public class MostCommonWord {

    public static void main(String[] args) {
        System.out.println(new MostCommonWord().mostCommonWord("teste teste rato rato teste rato meleca", new String[]{"teste"}));
    }


    public String mostCommonWord(String paragraph, String[] banned) {

        var words = new HashMap<String, Integer>();
        var bannedWords = new HashMap<String, Boolean>();
        String[] strings = paragraph.toLowerCase().split("\\W+");

        for (var bannedWord:banned) {
            bannedWords.put(bannedWord.toLowerCase(), true);
        }


        for (String string : strings) {
            words.merge(string, 1, Integer::sum);
        }


        var result = "";
        int qtdMax = 0;
        for (var entry : words.entrySet()) {

            var word = entry.getKey();
            var value = entry.getValue();

            if (value > qtdMax && bannedWords.get(word) == null) {
                qtdMax = value;
                result = word;
            }

        }

        return result;
    }
}



/*
Most Common Word
*
* Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.



Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"


Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.
*
* */