package Karat;

import java.util.*;

public class CourseSchedule {
    public static String findMidCourse(List<List<String>> prereqs) {
        // Step 1: Build the graph and the indegree map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for (List<String> pair : prereqs) {
            String src = pair.get(0);
            String dest = pair.get(1);

            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(dest);

            indegree.putIfAbsent(src, 0);
            indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
        }

        // Step 2: Topological sorting using Kahn's algorithm
        LinkedList<String> order = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();

        // Find all courses with zero indegree
        for (String node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            // Process all adjacent nodes
            for (String neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 3: Find the middle course
        if (order.size() == 0) {
            return null;  // No valid course order
        }
        return order.get((order.size() - 1) / 2);
    }

    public static void main(String[] args) {
        List<List<String>> prereqs_courses1 = Arrays.asList(
                Arrays.asList("Foundations of Computer Science", "Operating Systems"),
                Arrays.asList("Data Structures", "Algorithms"),
                Arrays.asList("Computer Networks", "Computer Architecture"),
                Arrays.asList("Algorithms", "Foundations of Computer Science"),
                Arrays.asList("Computer Architecture", "Data Structures"),
                Arrays.asList("Software Design", "Computer Networks")
        );

        System.out.println("Mid course: " + findMidCourse(prereqs_courses1));
    }
}
