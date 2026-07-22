/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node,Node> vis = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // If the node has already been cloned, return its clone reference.
        if(vis.containsKey(node)) return vis.get(node);
        // Create a new clone for the current node (with empty neighbors list)
        Node cloneNode = new Node(node.val,new ArrayList<>());
        // Save the clone to the map BEFORE traversing neighbors to handle cycles correctly
        vis.put(node,cloneNode);
        // Iterate through all neighbors and clone them recursively
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}