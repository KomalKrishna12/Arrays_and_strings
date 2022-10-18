import java.util.*;

public class Q50_Top_k_freq_element {
    static class Pair implements Comparable<Pair> {
        int val;
        int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }

        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }

    public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int val : map.keySet()) {
            pq.add(new Pair(val, map.get(val)));
        }

        for (int i = 0; i < k; i++) {
            int value = pq.remove().val;
            ans.add(value);
        }

        return ans;

    }

    // Don't make any changes here.
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int k = s.nextInt();
        s.close();
        ArrayList<Integer> res = topKFrequent(n, ar, k);
        Collections.sort(res);
        System.out.println(res);
    }
}
