package org.example;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(
                canFinish(5, new int[][]{
                        {0,1},
                        {0,2},
                        {2,3},
                        {2,4},
                        {3,4}
                })
        );

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        var graph = new HashMap<Integer, List<Integer>>();

        var visited = new boolean[numCourses];
        var visitedDfs = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i]) continue;
            if (hasCycle(graph, visited, visitedDfs, i)) {
                return false;
            }
        }
        return true;

    }

    private static boolean hasCycle(Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] visitedDfs, int course) {
        if (visitedDfs[course]) {
            return true;
        }

        visitedDfs[course] = true;

        for (int nextCourse : graph.get(course)) {
            if (hasCycle(graph, visited, visitedDfs, nextCourse)) {
                return true;
            }
        }

        visitedDfs[course] = false;
        visited[course] = true;

        return false;
    }

}
