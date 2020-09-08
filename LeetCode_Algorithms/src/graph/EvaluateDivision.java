package graph;

import java.util.*;

public class EvaluateDivision {

    Map<String, Node> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        graph = new HashMap<>();
        //init map
        for(int i=0; i<n; i++) {
            String parent = equations.get(i).get(0);
            String child = equations.get(i).get(1);
            if(!graph.containsKey(child)) {
                Node node = new Node(child);
                graph.put(child, node);
            }
            if(!graph.containsKey(parent)) {
                Node node = new Node(parent);
                graph.put(parent, node);
            }
            graph.get(child).buildParent(parent, values[i]);
            graph.get(parent).buildParent(child, 1.0 / values[i]);
        }

        double[] results = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            if(graph.containsKey(query.get(1)) && graph.containsKey(query.get(0))) {
                double temp = calc(query.get(1), query.get(0), new HashSet<>());
                results[i] = temp == 0 ? -1.0 : temp;
            } else {
                results[i] = -1.0;
            }
        }
        return results;
    }

    private double calc(String node, String target, Set<String> visited) {
        if(visited.contains(node))
            return 0;
        if(!graph.containsKey(node))
            return 0;
        if(node.equals(target))
            return 1.0;

        Node cur = graph.get(node);
        visited.add(node);
        for(String parentNode : cur.parents.keySet()) {
            double temp = cur.parents.get(parentNode) * calc(parentNode, target, visited);
            if(temp != 0) return temp;
        }
        return 0.0;
    }

    public class Node {
        String c;
        Map<String, Double> parents;

        public Node (String c) {
            this.c = c;
            parents = new HashMap<>();
        }

        public double getParentValue(String parent) {
            return parents.get(parent);
        }

        public void buildParent(String parent, double value) {
            parents.put(parent, value);
        }
    }

    public static void main(String[] args) {
        EvaluateDivision e = new EvaluateDivision();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x") );
        System.out.println(Arrays.toString(e.calcEquation(equations, values, queries)));
    }
}
