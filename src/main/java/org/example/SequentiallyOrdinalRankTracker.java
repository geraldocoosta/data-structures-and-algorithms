package org.example;

import java.util.PriorityQueue;

public class SequentiallyOrdinalRankTracker {

    public static void main(String[] args) {
        SORTracker sorTracker = new SORTracker();
        sorTracker.add("bradford", 2);
        sorTracker.add("bradford", 3);
        System.out.println(sorTracker.get());
        sorTracker.add("alps", 2);
        System.out.println(sorTracker.get());
        sorTracker.add("orland", 2);
        System.out.println(sorTracker.get());
        sorTracker.add("orland", 3);
        System.out.println(sorTracker.get());
        sorTracker.add("alpine", 2);
        System.out.println(sorTracker.get());
    }

    static class SORTracker {
        PriorityQueue<Loc> pq1;
        PriorityQueue<Loc> pq2;
        int count;

        public SORTracker() {
            pq1 = new PriorityQueue<>((a, b) -> a.score == b.score ? a.name.compareTo(b.name) : b.score - a.score);
            pq2 = new PriorityQueue<>((a, b) -> a.score == b.score ? b.name.compareTo(a.name) : a.score - b.score);
            count = 0;
        }

        public void add(String name, int score) {
            pq2.add(new Loc(score, name));
            if (pq2.size() > count) {
                pq1.add(pq2.poll());
            }
        }

        public String get() {
            pq2.add(pq1.poll());
            count++;
            return pq2.peek().name;
        }

        class Loc {
            int score;
            String name;

            Loc(int score, String name) {
                this.score = score;
                this.name = name;
            }
        }
    }
}
