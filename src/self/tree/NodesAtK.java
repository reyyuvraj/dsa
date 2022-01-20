package self.tree;

import java.util.*;

public class NodesAtK {

    static void nodeAtKFromRoot(Node root, int k){
        if(root==null)
            return;
        if (k==0)
            System.out.print(root.key+" ");
        else{
            nodeAtKFromRoot(root.left,k-1);
            nodeAtKFromRoot(root.right,k-1);
        }
    }

    static void markParents(Node root, Map<Node, Node> parent_track, Node target){
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            Node current = queue.poll();

            if (current.left!=null){
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }

            if (current.right!=null){
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    static List<Integer> nodesAtK(Node root, Node target, int k){
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track, root);

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(root, true);

        int current_level = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            if (current_level == k) break;

            current_level++;

            for (int i=0; i<size; i++){
                Node current = queue.poll();

                if (current.left!=null && visited.get(current.left)==null){
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right!=null && visited.get(current.right)==null){
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if (parent_track.get(current)!=null && visited.get(parent_track.get(current))==null){
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            Node current = queue.poll();
            result.add(current.key);
        }

        return result;
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        nodeAtKFromRoot(root,2);
        System.out.println(nodesAtK(root, root.right, 1));
    }
}