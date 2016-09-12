public class Solution {
    private Map<String, PriorityQueue<String>> flights = new HashMap<>();
    //private List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] s : tickets) {
            flights.putIfAbsent(s[0], new PriorityQueue<>());
            flights.get(s[0]).add(s[1]);
        }
        List<String> res = new ArrayList<>();
        helper("JFK", res);
        return res;
    }
    private void helper(String departure, List<String> res) {
        PriorityQueue<String> queue = flights.get(departure);
        while (queue != null && !queue.isEmpty()) {
            String destination = queue.poll();
            helper(destination, res);
        }
        res.add(0, departure);
    }
}