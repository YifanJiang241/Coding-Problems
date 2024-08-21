package Whatnot;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] names) {
        if (names == null || names.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String name : names) {
            char[] characters = name.toCharArray();
            Arrays.sort(characters);
            String sortedName = new String(characters);

            if (!map.containsKey(sortedName)) {
                map.put(sortedName, new ArrayList<>());
            }
            map.get(sortedName).add(name);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] names = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(names);

        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}
