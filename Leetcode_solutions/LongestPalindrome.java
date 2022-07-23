import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        HashMap<ArrayList<Integer>, Boolean> characterOccurences = new HashMap<ArrayList<Integer>, Boolean>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                checkPalindrome(s, i, j, characterOccurences);
                if (i == 0 & j == 12) {
                    System.out.println(s.substring(i, j + 1));
                    System.out.println(checkPalindrome(s, i, j, characterOccurences));
                }
            }
        }
        ArrayList<Integer> max = new ArrayList<>(Arrays.asList(0, 0));
        for (ArrayList<Integer> key : characterOccurences.keySet()) {
            if (key.get(1) - key.get(0) > max.get(1) - max.get(0) && characterOccurences.get(key)) {
                max = key;
            }
        }
        return s.substring(max.get(0), max.get(1) + 1);
    }

    public Boolean checkPalindrome(String s, Integer start, Integer end) {
        return checkPalindrome(s, start, end, new HashMap<ArrayList<Integer>, Boolean>());
    }

    public Boolean checkPalindrome(String s, Integer start, Integer end, HashMap<ArrayList<Integer>, Boolean> mem) {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(start, end));
        if (end == start) {
            mem.put(x, true);
            return mem.get(x);
        }
        if (end < start) {
            return true;
        }

        if (mem.containsKey(x)) {
            return mem.get(x);
        }

        if (s.charAt(start) == s.charAt(end)) {
            mem.put(x, checkPalindrome(s, x.get(0) + 1, x.get(1) - 1, mem));
            return mem.get(x);

        } else {
            mem.put(x, false);
            return mem.get(x);
        }

    }

    public static void main(String[] args) {
        LongestPalindrome x = new LongestPalindrome();
        System.out.println(x.longestPalindrome("xaabacxcabaaxcabaax"));
    }
}
