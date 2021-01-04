package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> dq;

    public NestedIterator(List<NestedInteger> nestedList) {
        dq = new ArrayDeque<>();
        for (NestedInteger n : nestedList) {
            add(n);
        }
    }

    private void add(NestedInteger n) {
        if (n.isInteger()) {
            dq.addLast(n);
            return;
        }

        if (n.getList().size() == 0) {
            return;
        }


        List<NestedInteger> list = n.getList();
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public Integer next() {
        while (!dq.isEmpty() && !dq.peekFirst().isInteger()) {
            List<NestedInteger> list = dq.pollFirst().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                dq.addFirst(list.get(i));
            }
        }
        return dq.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !dq.isEmpty();
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
