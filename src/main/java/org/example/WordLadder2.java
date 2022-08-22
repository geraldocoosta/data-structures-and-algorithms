package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

    public static void main(String[] args) {
        System.out.println(new WordLadder2().ladderLength("a", "c", List.of("a", "b", "c")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        int changes = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // aqui eu pego o primeiro elemento da fila
                String word = queue.poll();

                // se a palavra for igual a minha ultima palavra, eu achei o minimo de mudanças
                if (word.equals(endWord)) {
                    return changes;
                }

                for (int j = 0; j < word.length(); j++) {
                    // Pra cada letra da minha palavra que estava na fila
                    // eu vou trocar por um caractere de A a Z.
                    // exemplo
                    // hit -> ait bit cit ...
                    // hit -> hat hbt hct ...
                    // hit -> hia hib hic ...
                    for (char k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = k;

                        String str = new String(arr);
                        // Se eu tenho a palavra que troquei um caractere e ainda não visitei esse
                        // eu adiciono na fila e coloco que já visitei
                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }
}

/*\
 Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/