package breadthfirstsearch;

import java.util.*;

public class KHighestRankedItemsWithinaPriceRange {

    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<Node> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.add(new Node(start[0], start[1], grid[start[0]][start[1]]));
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Node> candidates = new ArrayList<>();
            for(int i = 0; i < size; i ++) {
                Node cur = q.poll();
                if(cur.price >= pricing[0] && cur.price <= pricing[1])
                    candidates.add(cur);

                for(int[] d : directions) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || grid[x][y] == 0)
                        continue;
                    q.add(new Node(x, y, grid[x][y]));
                    visited[x][y] = true;
                }
            }

            Collections.sort(candidates);
            System.out.println(candidates);
            if(candidates.size() < k) {
                res.addAll(candidates);
                k -= candidates.size();
            } else {
                for(int i = 0; i < k; i ++) {
                    res.add(candidates.get(i));
                }
                break;
            }
        }

        List<List<Integer>> coordinates = new ArrayList<>();
        for(Node node : res) {
            coordinates.add(List.of(node.i, node.j));
        }
        return coordinates;
    }

    public static class Node implements Comparable<Node> {

        int i;
        int j;
        int price;

        Node (int i, int j, int price) {
            this. i = i;
            this. j = j;
            this.price = price;
        }

        @Override
        public int compareTo(Node node) {
            if(node.price != this.price ) {
                return Integer.compare(this.price, node.price);
            } else if (this.i != node.i) {
                return Integer.compare(this.i, node.i);
            } else {
                return Integer.compare(this.j, node.j);
            }
        }

        @Override
        public String toString() {
            return i + " " + j + " " + price ;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, 2, 3);
        Node n2 = new Node(2, 1, 2);
        List<Node> candidates = new ArrayList<>();
        candidates.add(n1); candidates.add(n2);
        Collections.sort(candidates);
        System.out.println(candidates);
    }
}
