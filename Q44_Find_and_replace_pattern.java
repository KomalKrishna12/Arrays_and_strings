import java.util.*;
// given an array of words and a string a pattern, we have to map each char of pattern with words
// and add all words who is correctly mapped with each char of pattern into ans list
// words[] = {"mno","rst","rss","bll","lml","aaa"}, pattern = "epp"
// we can see "rss" and "bll" are correctly map with "epp"
// so we can use a hashmap to check every word of words array if it mapped correctly
// then add into ans list 
// now we are checking each character of pattern but there is chance that in word their is
// any char who is already mapped with some char in pattern like
// pattern = "abbcdde", word = "pqqrzzz"
// here a -> p, b -> q, c -> r, d -> z and e mapped with z but z is already mapped with d
// so we use hashset to store all mapped char of word and if any char is already mapped while
// mapping char of pattern with char of word then we return false else we mapped pattern char
// with word char and add word char into set so that from next time the word char will not
// mapped with any char of pattern 
public class Q44_Find_and_replace_pattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (isMatching(word, pattern)) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static boolean isMatching(String word, String pattern) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char wch = word.charAt(i);
            char pch = pattern.charAt(i);
            if (map.containsKey(pch)) {
                // already mapped with some char
                if (map.get(pch) != wch)
                    return false;
            } else {
                // not mapped yet also check that the char of word
                // is mapped with some other char of pattern or not
                if (set.contains(wch))
                    return false;
                map.put(pch, wch);
                set.add(wch);
            }
        }
        return true;
    }

    // ~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String pattern = scn.nextLine();
        int n = scn.nextInt();
        scn.nextLine(); // to consume enter after number
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scn.nextLine();
        }
        scn.close();
        List<String> res = findAndReplacePattern(words, pattern);
        if (res.size() == 0) {
            System.out.println("Empty");
            return;
        }
        Collections.sort(res);
        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
