package ir.sk.algorithm.graph;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.*;

/**
 * You are given a hash table where the key is a course code, and the value is a list of all the course codes that are prerequisites for the key.
 * Return a valid ordering in which we can complete the courses.
 * If no such ordering exists, return NULL.
 *
 * Created by sad.kayvanfar on 7/25/2021.
 */
@TimeComplexity("O(|V|+|E|)")
@Difficulty(type = DifficultyType.MEDIUM)
public class CoursePrerequisites {

    Set<String> visited = new HashSet<>();
    Stack<String> resultStack = new Stack<>();

    Map<String, List<String>> map;

    public CoursePrerequisites(Map<String, List<String>> map) {
        this.map = map;

        for (String course : map.keySet()) {
            if (!visited.contains(course))
                dfsPostOrder(course);
        }
    }

    public Iterable<String>  coursePrerequisites() {
        return resultStack;
    }

    private void dfsPostOrder(String course) {
        visited.add(course);
        for (String curCourse : map.get(course)) {
            if (!visited.contains(curCourse)) {
                dfsPostOrder(curCourse);
            }
        }
        resultStack.add(course);
    }
}
