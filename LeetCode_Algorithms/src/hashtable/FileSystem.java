package hashtable;

import java.util.*;

public class FileSystem {
    //Map<String, String> fileContentMap;
    Node root;

    public FileSystem() {
        //fileContentMap = new HashMap<>();
        root = new Node("");
    }

    public List<String> ls(String path) {
        List<String> res = new LinkedList<>();
        if (path.length() == 1) {
            res.addAll(root.childrenMap.keySet());
        } else {
            String[] arr = path.split("/");
            Node cur = root;
            for (int i = 1; i < arr.length; i++) {
                cur = cur.childrenMap.get(arr[i]);
            }
            if(cur.isFile) return List.of(cur.name);
            res.addAll(cur.childrenMap.keySet());
        }
        Collections.sort(res);
        return res;
    }

    public void mkdir(String path) {
        if (path.length() <= 1) return;
        String[] arr = path.split("/");
        Node parentNode = root;
        for (int i = 1; i < arr.length; i++) {
            String name = arr[i];
            if (parentNode.childrenMap.containsKey(name)) {
                parentNode = parentNode.childrenMap.get(name);
            } else {
                Node newNode = new Node(name);
                parentNode.childrenMap.put(name, newNode);
                parentNode = newNode;
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        Node cur = root;
        String[] arr = filePath.split("/");
        for (int i = 1; i < arr.length - 1; i++) {
            cur = cur.childrenMap.get(arr[i]);
        }
        String fileName = arr[arr.length - 1];
        if(cur.childrenMap.containsKey(fileName)) {
            cur.childrenMap.get(fileName).content += content;
        } else {
            Node fileNode = new Node(fileName);
            fileNode.content = content;
            fileNode.isFile = true;
            cur.childrenMap.put(fileName, fileNode);
        }
    }

    public String readContentFromFile(String filePath) {
        Node cur = root;
        String[] arr = filePath.split("/");
        for (int i = 1; i < arr.length; i++) {
            cur = cur.childrenMap.get(arr[i]);
        }
        return cur.content;
    }

    class Node implements Comparable<Node> {
        String name;
        Map<String, Node> childrenMap = new HashMap<>();
        String content;
        boolean isFile;

        public Node(String name) {
            this.name = name;
            content = "";
            isFile = false;
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
        System.out.println(f.readContentFromFile("/a/b/xx"));
    }
}
