import java.util.ArrayList;
import java.util.List;

public class Week9BaiTap {
    public static class Node {
        int id;
        String data;
        int parent;
        int firstChild;
        int nextSibling;
        public Node(int id, String data) {
            this.id = id;
            this.data = data;
            this.parent = -1;
            this.firstChild = -1;
            this.nextSibling = -1;
        }
    }
    private List<Node> nodes;
    public GeneralTree() {
        nodes = new ArrayList<>();
    }
    public int addNode(String data) {
        int id = nodes.size();
        Node node = new Node(id, data);
        nodes.add(node);
        return id;
    }
    public void addChild(int parentId, int childId) {
        if (parentId < 0 || parentId >= nodes.size() || childId < 0 || childId >= nodes.size()) {
            System.out.println("Chỉ số nút không hợp lệ");
            return;
        }
        Node parentNode = nodes.get(parentId);
        Node childNode = nodes.get(childId);
        childNode.parent = parentId;
        if (parentNode.firstChild == -1) {
            parentNode.firstChild = childId;
        } else {
            int currentSiblingId = parentNode.firstChild;
            while (nodes.get(currentSiblingId).nextSibling != -1) {
                currentSiblingId = nodes.get(currentSiblingId).nextSibling;
            }
            nodes.get(currentSiblingId).nextSibling = childId;
        }
    }
    public Node getParent(int u) {
        if (u < 0 || u >= nodes.size()) return null;
        int parentId = nodes.get(u).parent;
        return (parentId != -1) ? nodes.get(parentId) : null;
    }
    public Node getFirstChild(int u) {
        if (u < 0 || u >= nodes.size()) return null;
        int firstChildId = nodes.get(u).firstChild;
        return (firstChildId != -1) ? nodes.get(firstChildId) : null;
    }
    public Node getNextSibling(int u) {
        if (u < 0 || u >= nodes.size()) return null;
        int nextSiblingId = nodes.get(u).nextSibling;
        return (nextSiblingId != -1) ? nodes.get(nextSiblingId) : null;
    }
    public String getNodeInfo(Node node) {
        return (node != null) ? (node.data + " (ID: " + node.id + ")") : "Null";
    }
}