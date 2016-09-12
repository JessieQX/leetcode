public class Solution {
    private Map<String, PriorityQueue<String>> flights = new HashMap<>();
    //private List<String> res = new ArrayList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] : tickets) {
            flights.putIfAbsent(String[0], new PriorityQueue<>());
            flights.get(String[0]).add(String[1]);
        }
        helper("JFK", new ArrayList<>());
        return res;
    }
    private void helper(String departure, List<String> res) {
        PriorityQueue<String> queue = flights.get(departure);
        while (!queue.isEmpty()) {
            String destination = queue.poll();
            helper(destination);
        }
        res.add(0, departure);
    }
}