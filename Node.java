import java.util.ArrayList;
import java.util.List;

class Node {

    public int x;//current position for x
    public int y;//current position for y
    //linked node
    public Node up_child;
    public Node down_child;
    public Node left_child;
    public Node right_child;

    public List<Node> neighbor = new ArrayList<Node>();

    //has visited;
    public Boolean isVisited;
    public Boolean isSource;
    //three way blocked

    public char value;//store for curr node's value;

    //distance from goal state
    public int curr_distance;

    public Node nextPath;


    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Node(int x, int y, char value) {
        this.x = x;
        this.y = y;

        this.value = value;

        up_child = null;
        down_child = null;
        left_child = null;
        right_child = null;

        isVisited = false;
        isSource = false;

        neighbor = new ArrayList<Node>();
    }

    public Node() {
        this.x = x;
        this.y = y;

        this.value = value;

        up_child = null;
        down_child = null;
        left_child = null;
        right_child = null;

        isVisited = false;
        isSource = false;

        neighbor = new ArrayList<Node>();

    }


    public boolean equals(Node other) {
        return ((this.x == other.x) && (this.y == other.y));
    }


    public boolean hasChild() {
        return !neighbor.isEmpty();
    }


}
