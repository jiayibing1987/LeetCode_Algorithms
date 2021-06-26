package graph;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new LinkedList<>();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parents = new HashMap<>();

        for(List<String> account : accounts) {
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                parents.put(email, email);
            }
        }

        //run union find to set up parents map
        for(List<String> account : accounts) {
            String curParent = find(account.get(1), parents);
            for(int i = 2; i < account.size(); i++) {
                String email = account.get(i);
                if(parents.containsKey(email)) {
                    String originalParent = find(email, parents);
                    parents.put(originalParent, curParent);
                } else {
                    parents.put(email, curParent);
                }
            }
        }

        //retrieve ans from parents map
        Map<String, Set<String>> mergedAccounts = new HashMap<>();
        for(List<String> account : accounts) {
            for(int i = 1; i < account.size(); i ++) {
                String email = account.get(i);
                String parent = find(email, parents);
                if(!mergedAccounts.containsKey(parent)) {
                    mergedAccounts.put(parent, new HashSet<>());
                }
                mergedAccounts.get(parent).add(email);
            }
        }

        //add name in the front of each subset and sort emails.
        for(Map.Entry<String, Set<String>> entry : mergedAccounts.entrySet()) {
            String parent = entry.getKey();
            String name = emailToName.get(parent);
            LinkedList<String> list = new LinkedList<>(entry.getValue());
            Collections.sort(list);
            list.addFirst(name);
            res.add(list);
        }
        return res;
    }

    private String find(String e, Map<String, String> parents) {
        String ans = e;
        if(!parents.get(e).equals(e)) {
            ans = find(parents.get(e), parents);
        }
        return ans;
    }
}
