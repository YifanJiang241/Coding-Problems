package Karat;
//Given a list of people who enter and exit, find the people who entered without
//        their badge and who exited without their badge.

// badge_records = [
//   ["Martha",   "exit"],
//   ["Paul",     "enter"],
//   ["Martha",   "enter"],
//   ["Martha",   "exit"],
//   ["Jennifer", "enter"],
//   ["Paul",     "enter"],
//   ["Curtis",   "enter"],
//   ["Paul",     "exit"],
//   ["Martha",   "enter"],
//   ["Martha",   "exit"],
//   ["Jennifer", "exit"],
// ]

// Expected output: ["Paul", "Curtis"], ["Martha"]
import java.util.*;

public class BadgeCheck {
    public static List<List<String>> invalidBadgeRecords(String[][] records) {
        if (records == null || records.length == 0) {
            return Arrays.asList(new ArrayList<>(), new ArrayList<>());
        }

        Map<String, Integer> state = new HashMap<>();
        Set<String> invalidEnter = new HashSet<>();
        Set<String> invalidExit = new HashSet<>();

        for (String[] record : records) {
            String name = record[0];
            String action = record[1];
            state.putIfAbsent(name, 0); // Assume 0 is out, 1 is in

            if ("enter".equals(action)) {
                if (state.get(name) == 1) {
                    // Already inside but tries to enter again
                    invalidEnter.add(name);
                }
                state.put(name, 1); // Mark as inside
            } else if ("exit".equals(action)) {
                if (state.get(name) == 0) {
                    // Already outside but tries to exit
                    invalidExit.add(name);
                }
                state.put(name, 0); // Mark as outside
            }
        }

        // Check for those who did not exit
        for (Map.Entry<String, Integer> entry : state.entrySet()) {
            if (entry.getValue() == 1) {
                invalidEnter.add(entry.getKey());
            }
        }

        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>(invalidEnter)); // First list for invalid entries
        result.add(new ArrayList<>(invalidExit));  // Second list for invalid exits

        return result;
    }

    public static void main(String[] args) {
        String[][] badgeRecords = {
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "enter"},
                {"Paul",     "enter"},
                {"Curtis",   "enter"},
                {"Paul",     "exit"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "exit"},
        };

        List<List<String>> output = invalidBadgeRecords(badgeRecords);
        System.out.println("Entered without badge: " + output.get(0));
        System.out.println("Exited without badge: " + output.get(1));
    }
}
