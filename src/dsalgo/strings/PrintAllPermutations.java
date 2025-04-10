package dsalgo.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllPermutations {
    public static void main(String[] args) {
        String s = "YHQM";

        List<String> list = uniquePermutations(s);

        System.out.println("Total Permutations: " + list.size());
        for (String s2 : list) {
            System.out.println(s2);
        }
    }

    public static List<String> uniquePermutations(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        boolean isAllSame = true;
        char ch = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                isAllSame = false;
                break;
            }
        }

        if (isAllSame) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }

        Set<String> set = new HashSet<>();
        permutations(s, "", set);

        ArrayList<String> list = new ArrayList<>();
        for (String s2 : set) {
            list.add(s2);
        }

        return list;
    }

    public static void permutations(String ques, String rem, Set<String> set) {
        if (ques.length() == 0) {
            set.add(rem);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String left = ques.substring(0, i);
            String right = ques.substring(i + 1);
            permutations(left + right, rem + ch, set);
        }
    }

}
