package hashtable;

import java.util.*;

public class FileSystem {
    Map<String, String> fileContentMap;
    Map<String, Node> rootMap;

    public FileSystem() {
        fileContentMap = new HashMap<>();
        rootMap = new HashMap<>();
    }

    public List<String> ls(String path) {
        List<String> res = new LinkedList<>();
        if(path.length() == 1) {
            res.addAll(rootMap.keySet());
        } else {
            String[] arr = path.split("/");
            if(fileContentMap.containsKey(path)) {
                res.add(arr[arr.length - 1]);
            } else {
                Node cur = null;
                for(int i = 1; i < arr.length; i++) {
                    if(i == 1) { //get root node
                        cur = rootMap.get(arr[i]);
                    } else {
                        cur = cur.childrenMap.get(arr[i]);
                    }
                }
                res.addAll(cur.childrenMap.keySet());
            }
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        if(path.length() <= 1) return;
        String[] arr = path.split("/");
        Node parentNode = null;
        for(int i = 1; i < arr.length; i++) {
            String name = arr[i];
            if(i == 1) {
                if(rootMap.containsKey(name))
                    parentNode = rootMap.get(name);
                else {
                    parentNode = new Node(name);
                    rootMap.put(name, parentNode);
                }
            } else {
                if(parentNode.childrenMap.containsKey(name)) {
                    parentNode = parentNode.childrenMap.get(name);
                } else {
                    Node newNode = new Node(name);
                    parentNode.childrenMap.put(name, newNode);
                    parentNode = newNode;
                }
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        String oldContent = "";
        if(fileContentMap.containsKey(filePath)) {
            oldContent = fileContentMap.get(filePath);
        } else {
            mkdir(filePath);
        }
        fileContentMap.put(filePath, oldContent + content);
    }

    public String readContentFromFile(String filePath) {
        return fileContentMap.get(filePath);
    }

    class Node implements Comparable<Node> {
        String name;
        Map<String, Node> childrenMap = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node node) {
            return this.name.compareTo(node.name);
        }
    }

    public static void main(String[] args) {

        //["FileSystem","ls","mkdir","  ls","    mkdir","   ls"]
        //[[],         ["/"],["/a/b/c"],["/a/b"],["/a/b/a"],["/a/b"]]
        FileSystem f = new FileSystem();
        f.ls("/");
        f.mkdir("/a/b/c");
        System.out.println(f.ls("/a/b"));
        f.mkdir("/a/b/a");
        System.out.println(f.ls("/a/b"));
        f.addContentToFile("/a/b/xx", "some contents");
        System.out.println(f.ls("/a/b"));

    }
}
