package graph;

import java.util.*;

public class ReconstructItinerary {

    List<String> results;
    Map<String, List<String>> map;
    int numberOfEdges = 0;
    int usedEdges = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        results = new ArrayList<>();
        map = new HashMap<>();
        setupGraph(tickets);

        //go dfs for map
        String root = "JFK";
        results.add(root);
        dfs(root);
        return results;
    }

    private void dfs(String node) {
        if (usedEdges == numberOfEdges) return;
        if (!map.containsKey(node)) return;

        List<String> children = map.get(node);
        for (int i=0; i<children.size(); i++) {
            String child = children.get(i);
            results.add(child);
            children.remove(i);
            usedEdges++;
            dfs(child);
            if (usedEdges == numberOfEdges)
                return;
            else{
                results.remove(results.size() - 1);
                children.add(i, child);
                usedEdges--;
            }
        }
    }

    private void setupGraph(List<List<String>> tickets) {
        numberOfEdges = tickets.size();
        for (List<String> edge : tickets) {
            String from = edge.get(0);
            String to = edge.get(1);
            if (!map.containsKey(from)) {
                List<String> l = new ArrayList<>(List.of(to));
                map.put(from, l);
            } else {
                List<String> l = map.get(from);
                int indexToInsert = 0;
                for (String child : l) {
                    if (to.compareTo(child) < 0) {
                        break;
                    }
                    indexToInsert++;
                }
                l.add(indexToInsert, to);
            }
        }
    }

    public static void main(String[] args) {
        List<String> l1 = List.of("JFK","SFO");
        List<String> l2 = List.of("JFK","ATL");
        List<String> l3 = List.of("SFO","ATL");
        List<String> l4 = List.of("ATL","JFK");
        List<String> l5 = List.of("ATL","SFO");
        List<List<String>> tickets = List.of(l1, l2, l3, l4, l5);

        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }
}
