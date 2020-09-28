package thirtydayschallenge;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    Map<String, Node> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        initGraph(equations, values);

        double[] results = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if(!graph.containsKey(x) || !graph.containsKey(y)) {
                results[i] = -1.0d;
                continue;
            }

            Node parentX = find(graph.get(x), 1.0d);
            double valueX = parentX.value;
            Node parentY = find(graph.get(y), 1.0d);
            double valueY = parentY.value;
            if(parentX.c == parentY.c) {
                results[i] = valueY / valueX;
                parentX.value = 1.0d;
            } else {
                results[i] = -1.0d;
            }
        }
        return results;
    }

    private void initGraph(List<List<String>> equations, double[] values) {
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            String parent = equations.get(i).get(0);
            String child = equations.get(i).get(1);
            if (!graph.containsKey(child)) {
                Node node = new Node(child);
                graph.put(child, node);
            }
            if (!graph.containsKey(parent)) {
                Node node = new Node(parent);
                graph.put(parent, node);
            }

            union(parent, child, values[i]);
        }
    }

    private Node find(Node node, double v) {
        if (node.parent == null) {
            node.value = v;
            return node;
        }
        return find(node.parent, v * node.value);
    }

    private void union(String x, String y, double value) {
        Node parentX = find(graph.get(x), 1.0d);
        Node parentY = find(graph.get(y), 1.0d);
        if(parentX.c == parentY.c) return;

        parentY.parent = parentX;
        parentY.value = parentX.value / parentY.value * value;
        parentX.value = 1.0d;
    }


    class Node {
        String c;
        Node parent;
        double value;

        public Node(String c) {
            this.c = c;
        }

        public Node(String c, int v) {
            this.c = c;
            this.value = v;
        }
    }
}
