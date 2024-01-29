package ir.sk.algorithm.intervals;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.BruteForce;

import java.util.*;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 2/5/2021.
 */
public class MergeIntervalsByGraph {
    private Map<Interval, List<Interval>> graph;
    private Map<Integer, List<Interval>> nodesInComp;
    private Set<Interval> visited;

    /**
     * return whether two intervals overlap (inclusive)
     *
     * @param a
     * @param b
     * @return
     */
    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && b.start <= a.end;
    }

    /**
     * build a graph where an undirected edge between intervals u and v exists if u and v overlap.
     *
     * @param intervals
     */
    @TimeComplexity("O(|V| + |E|) = O(|V|) + O(|E|) = O(n) + O(n^2) = O(n^2)")
    private void buildGraph(Interval[] intervals) {
        graph = new HashMap<>();
        for (Interval interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }

        for (Interval interval1 : intervals) {
            for (Interval interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    /**
     * merges all of the nodes in this connected component into one interval.
     *
     * @param nodes
     * @return
     */
    private Interval mergeNodes(List<Interval> nodes) {
        int minStart = nodes.get(0).start;
        for (Interval node : nodes) {
            minStart = Math.min(minStart, node.start);
        }

        int maxEnd = nodes.get(0).end;
        for (Interval node : nodes) {
            maxEnd = Math.max(maxEnd, node.end);
        }

        return new Interval(minStart, maxEnd);
    }

    /**
     * use depth-first search to mark all nodes in the same connected component with the same integer.
     *
     * @param start
     * @param compNumber
     */
    private void markComponentDFS(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);

                for (Interval child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    /**
     * gets the connected components of the interval overlap graph.
     *
     * @param intervals
     */
    private void buildComponents(Interval[] intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;

        for (Interval interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }


    /**
     * If we draw a graph (with intervals as nodes) that contains undirected edges between all pairs of intervals that overlap,
     * then all intervals in each connected component of the graph can be merged into a single interval.
     * <p>
     * With the above intuition in mind, we can represent the graph as an adjacency list, inserting directed edges in both directions to simulate undirected edges.
     * Then, to determine which connected component each node is it,
     * we perform graph traversals from arbitrary unvisited nodes until all nodes have been visited.
     * To do this efficiently, we store visited nodes in a Set, allowing for constant time containment checks and insertion. Finally,
     * we consider each connected component, merging all of its intervals by constructing a new Interval with start equal to the minimum start among them and end equal to the maximum end.
     * <p>
     * This algorithm is correct simply because it is basically the brute force solution. We compare every interval to every other interval,
     * so we know exactly which intervals overlap. The reason for the connected component search is that two intervals may not directly overlap,
     * but might overlap indirectly via a third interval.
     * <p>
     * Time complexity : O(n^2)
     * <p>
     * Building the graph costs O(V + E) = O(V) + O(E) = O(n) + O(n^2) = O(n^2) time, as in the worst case all intervals are mutually overlapping.
     * Traversing the graph has the same cost (although it might appear higher at first) because our visited set guarantees that each node will be visited exactly once.
     * Finally, because each node is part of exactly one component,
     * the merge step costs O(V) = O(n) time. This all adds up as follows:
     * <p>
     * O(n^2) + O(n^2) + O(n) = O(n^2)
     * <p>
     * Space complexity : O(n^2)
     *
     * @param intervals
     * @return
     */
    @TimeComplexity("O(n ^ 2)")
    @SpaceComplexity("O(n ^ 2)")
    @BruteForce
    @Difficulty(type = DifficultyType.MEDIUM)
    public Interval[] merge(Interval[] intervals) {
        buildGraph(intervals);
        buildComponents(intervals);

        // for each component, merge all intervals into one interval.
        List<Interval> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }

        return merged.toArray(new Interval[merged.size()]);
    }
}
