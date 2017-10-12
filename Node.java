import java.util.ArrayList;
import java.util.List;

class Node {

    public int x;//current position for x

    public int y;//current position for y
    
    public Node up_child, down_child, left_child, right_child;//linked node
    
    public List<Node> neighbor = new ArrayList<Node>();

    public Boolean isVisited; //has visited;

    public Boolean isSource; // if the node is the start or end,then it is the source node
   
    public char value;//store for curr node's value;

    //copy constructor
    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
    }

    //constructor
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
    //default constructor
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
