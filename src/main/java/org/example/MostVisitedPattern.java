package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostVisitedPattern {

    public static void main(String[] args) {
        System.out.println(new MostVisitedPattern().mostVisitedPattern(
                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
                new int[]{436363475, 710406388, 386655081, 797150921},
                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"}));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = timestamp.length;

        // Sort sessions list by time, can not use map ,because web will be duplicated
        List<Visit> sessions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sessions.add(new Visit(username[i], timestamp[i], website[i]));
        }
        sessions.sort((a, b) -> a.time - b.time);

        // add each person visited list;
        Map<String, List<String>> visited = new HashMap<>();//(name, list<web>)
        for (int i = 0; i < n; i++) {
            visited.putIfAbsent(sessions.get(i).user, new ArrayList<>());
            visited.get(sessions.get(i).user).add(sessions.get(i).site);
        }

        // find each user list and build all 3-subsequences and count by map, and get maxCount;
        Map<String, Integer> sequence = new HashMap<>();//(sequence, count)

        int maxCount = 0;
        String maxseq = "";

        for (Map.Entry<String, List<String>> item : visited.entrySet()) {
            List<String> list = visited.get(item.getKey());
            if (list.size() < 3) continue;
            Set<String> subseqences = subseqence(list);
            for (String seq : subseqences) {
                sequence.merge(seq, 1, Integer::sum);

                if (sequence.get(seq) > maxCount) {
                    maxCount = sequence.get(seq);
                    maxseq = seq;
                } else if (sequence.get(seq) == maxCount && seq.compareTo(maxseq) < 0) {
                    maxseq = seq;
                }
            }
        }

        return Arrays.asList(maxseq.split(" "));
    }

    public Set<String> subseqence(List<String> list){
        int n = list.size();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n-1; j++){
                for (int k = j+1; k < n; k++){
                    res.add(list.get(i)+" "+list.get(j)+" "+list.get(k));
                }
            }
        }
        return res;
    }

    class Visit {
        String user;
        String site;
        int time;

        Visit(String user, int time, String site) {
            this.user = user;
            this.time = time;
            this.site = site;
        }
    }
}

/*
* Analyze User Website Visit Pattern
*
*You are given two string arrays username and website and an integer array timestamp. All the given arrays are of the same length and the tuple [username[i], website[i], timestamp[i]] indicates that the user username[i] visited the website website[i] at time timestamp[i].

A pattern is a list of three websites (not necessarily distinct).

For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.
The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared in the pattern.

For example, if the pattern is ["home", "away", "love"], the score is the number of users x such that x visited "home" then visited "away" and visited "love" after that.
Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is the number of users x such that x visited "leetcode" then visited "love" and visited "leetcode" one more time after that.
Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number of users x such that x visited "luffy" three different times at different timestamps.
Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the lexicographically smallest such pattern.



Example 1:

Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation: The tuples in this example are:
["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],["james","maps",6],["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
The pattern ("home", "about", "career") has score 2 (joe and mary).
The pattern ("home", "cart", "maps") has score 1 (james).
The pattern ("home", "cart", "home") has score 1 (james).
The pattern ("home", "maps", "home") has score 1 (james).
The pattern ("cart", "maps", "home") has score 1 (james).
The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).
Example 2:

Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
Output: ["a","b","a"]


Constraints:

3 <= username.length <= 50
1 <= username[i].length <= 10
timestamp.length == username.length
1 <= timestamp[i] <= 109
website.length == username.length
1 <= website[i].length <= 10
username[i] and website[i] consist of lowercase English letters.
It is guaranteed that there is at least one user who visited at least three websites.
All the tuples [username[i], timestamp[i], website[i]] are unique.
*
* */