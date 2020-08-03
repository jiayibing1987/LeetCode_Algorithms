package thirtydayschallenge;



import util.Pair;

import java.util.Set;
import java.util.Stack;


public class StockSpanner {

    Stack<Pair<Integer, Integer>> stack; // pair of stock price and stock span of it
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int temp = 1;
        while(!stack.isEmpty() && price < stack.peek().getKey()) {
            int span = stack.pop().getValue();
            temp = temp + span;
        }
        stack.push(new Pair(price,temp));
        return temp;
    }
}
