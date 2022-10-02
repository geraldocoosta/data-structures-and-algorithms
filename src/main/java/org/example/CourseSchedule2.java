package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule2 {

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

    public static boolean canFinish(int numberCourses, int[][] prerequisites) {
        var graph = new HashMap<Integer, List<Integer>>();
        var topologicSort = new ArrayList<Integer>();
        var dependenciesCount = new int[numberCourses];

        for (int i = 0; i < numberCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (var preReq: prerequisites) {
            graph.get(preReq[1]).add(preReq[0]);
            dependenciesCount[preReq[0]]++;
        }

        for (int i = 0; i < numberCourses; i++) {
            if (dependenciesCount[i] == 0) {
                topologicSort.add(i);
            }
        }

        for (int i = 0; i < topologicSort.size(); i++) {
            Integer courseWithoutDependence = topologicSort.get(i);
            var dependenceCourses= graph.get(courseWithoutDependence);

            for (int j = 0; j < dependenceCourses.size(); j++) {
                Integer dependeceCourse = dependenceCourses.get(j);
                dependenciesCount[dependeceCourse]--;
                if (dependenciesCount[dependeceCourse] == 0) {
                    topologicSort.add(dependeceCourse);
                }
            }
        }

        return topologicSort.size() == numberCourses;
    }

}
