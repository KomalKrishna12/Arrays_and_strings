import java.util.*;

public class Q49_kth_lexicographical_string_of_all_happy_strings_of_length_n {
    public static void main(String[] args) {
        String li[] = { "abracadabra", "geeksforgeeks",
                "abracadabra", "geeks", "geeksthrill" };

        String query[] = { "abr", "geeks", "geeksforgeeks",
                "ge", "gar" };

        System.out.println(prefixCount(li.length, query.length, li, query));
    }

    static List<Integer> prefixCount(int N, int Q, String li[], String query[]) {
        // code here
        List<Integer> ans = new ArrayList<>();

        for (String q : query) {
            int size = q.length();
            int count = 0;
            for (String s : li) {
                if (s.length() >= size) {
                    String str = s.substring(0, size);
                    System.out.print(str + " " + q + "");
                    if (str.equals(q)) {
                        count++;
                        System.out.println(count);
                    }
                    System.out.println();
                }
            }
            ans.add(count);
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 4);
        

        return ans;
    }
}
