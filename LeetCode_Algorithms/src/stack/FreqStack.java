package stack;

import java.util.*;

public class FreqStack {

    Map<Integer, Integer> freqMap;
    PriorityQueue<Node> pq;
    int pushOrder;
    public FreqStack() {
        pushOrder = 0;
        freqMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> a.freq == b.freq ? b.pushOrder - a.pushOrder : b.freq - a.freq);
    }

    public void push(int x) {
        freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        int freq = freqMap.get(x);
        Node node = new Node(x, freq, pushOrder++);
        pq.add(node);
    }

    public int pop() {
        Node node = pq.poll();
        int updatedFreq = freqMap.get(node.key) - 1;
        if(updatedFreq == 0) {
            freqMap.remove(node.key);
        } else {
            freqMap.put(node.key, updatedFreq);
        }
        return node.key;
    }

    class Node {
        int key;
        int freq;
        int pushOrder;

        public Node (int key, int freq, int pushOrder){
            this.key = key;
            this.freq = freq;
            this.pushOrder = pushOrder;
        }
    }

    public static void main (String[] args) {
        FreqStack f = new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        //[[],[1], [1], [1], [2], [], [], [2], [2], [1], [], [], []]
        // 1 1 1 2
        // 1 1 2
        // 1 2
        // 1 2 2 2 1

    }

}
