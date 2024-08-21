package Karat;

//You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
//        Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.


//Sample Input:
//
//        student_course_pairs_1 = [
//        ["58", "Software Design"],
//        ["58", "Linear Algebra"],
//        ["94", "Art History"],
//        ["94", "Operating Systems"],
//        ["17", "Software Design"],
//        ["58", "Mechanics"],
//        ["58", "Economics"],
//        ["17", "Linear Algebra"],
//        ["17", "Political Science"],
//        ["94", "Economics"],
//        ["25", "Economics"],
//        ]
//
//        Sample Output (pseudocode, in any order):
//
//        find_pairs(student_course_pairs_1) =>
//        {
//        [58, 17]: ["Software Design", "Linear Algebra"]
//        [58, 94]: ["Economics"]
//        [58, 25]: ["Economics"]
//        [94, 25]: ["Economics"]
//        [17, 94]: []
//        [17, 25]: []
//        }
//
//        Additional test cases:
//
//        Sample Input:
//
//        student_course_pairs_2 = [
//        ["42", "Software Design"],
//        ["0", "Advanced Mechanics"],
//        ["9", "Art History"],
//        ]
//
//        Sample output:
//
//        find_pairs(student_course_pairs_2) =>
//        {
//        [0, 42]: []
//        [0, 9]: []
//        [9, 42]: []
//        }
import java.util.*;

public class CourseOverlaps {

    public static void main(String[] args) {
        List<List<String>> studentCoursePairs1 = Arrays.asList(
                Arrays.asList("58", "Software Design"),
                Arrays.asList("58", "Linear Algebra"),
                Arrays.asList("94", "Art History"),
                Arrays.asList("94", "Operating Systems"),
                Arrays.asList("17", "Software Design"),
                Arrays.asList("58", "Mechanics"),
                Arrays.asList("58", "Economics"),
                Arrays.asList("17", "Linear Algebra"),
                Arrays.asList("17", "Political Science"),
                Arrays.asList("94", "Economics"),
                Arrays.asList("25", "Economics")
        );

        System.out.println("find_pairs(studentCoursePairs1) =>");
        System.out.println(findPairs(studentCoursePairs1));
    }

    public static Map<String, List<String>> findPairs(List<List<String>> studentCoursePairs) {
        Map<String, Set<String>> studentCourses = new HashMap<>();

        // Organize courses by student
        for (List<String> pair : studentCoursePairs) {
            String studentId = pair.get(0);
            String course = pair.get(1);
            studentCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(course);
        }

        List<String> students = new ArrayList<>(studentCourses.keySet());
        Map<String, List<String>> result = new HashMap<>();

        // Compare courses between each pair of students
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                String student1 = students.get(i);
                String student2 = students.get(j);
                List<String> overlaps = findCommonCourses(studentCourses.get(student1), studentCourses.get(student2));
                result.put("[" + student1 + ", " + student2 + "]", overlaps);
            }
        }

        return result;
    }

    private static List<String> findCommonCourses(Set<String> courses1, Set<String> courses2) {
        List<String> common = new ArrayList<>();
        for (String course : courses1) {
            if (courses2.contains(course)) {
                common.add(course);
            }
        }
        return common;
    }
}

