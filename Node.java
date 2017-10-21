import java.util.ArrayList;
import java.util.List;

class Node {

    public int x;//current position for x

    public int y;//current position for y
    
    public Node up_child, down_child, left_child, right_child;//linked node
    
    public List<Node> neighbor = new ArrayList<Node>();

    public Boolean isVisited; //has visited;

    public Boolean isSource; // if the node is the start or end,then it is the source node

    public List<Node> path = new ArrayList<Node>(); // if the node is the source then it should have a path 

    public List<Character> color_domain = new ArrayList<Character>(); // colors domain


   
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
    
    public boolean checkSourceValid(){
    int count = 0;
    boolean hasUnsigned = false;
    for (Node node:neighbor) {
        if (node!=null){
            if (node.value == this.value){
                count++;
            }
            if (node.value == '_') {
                hasUnsigned = true;
            }
        }
    }
    if (count == 1){
        // System.out.println("first " );
        return true;
    } 
    else if (count > 1){
         // System.out.println("second " );
        return false;
    }
    else if (hasUnsigned){
        // System.out.println("third " );
        return true;
     }

    return false;
}

    public boolean checkZigzag(char color){
        if (color == '_') {
            return true;
        }
        if (this.isSource) {
            return true;
        }
        int count = 0;
        int unsigned = 0;
        List<Node> sameColor = new ArrayList<>();
        for (Node n:neighbor) {
            if (n!=null){
                if (n.value == color){
                    count++;
                    sameColor.add(n);
                }
                if (n.value=='_') unsigned++;
            }
        }
        if (count >= 3) return false;
        else if (count == 2){
            Node n1 = sameColor.get(0);
            Node n2 = sameColor.get(1);
            if (n1.x != n2.x && n1.y != n2.y) {
                if (n1.x == this.x && Board.getNode(n2.x,n1.y).value == color) {
                    return false;
                }
                if (n1.y == this.y && Board.getNode(n1.x,n2.y).value == color) {
                    return false;
                }
            }
            return true;
        }else {
            return ((unsigned+count) > 1);
        }
}   

    public boolean checkConstraint(char color){
        if(this.isSource){
          
            return checkSourceValid();
        }        
        else{
            return checkZigzag(color) && formerCheck();
        }
    }

    public boolean formerCheck(){
        for (Node it_node : Board.board) {
            if(!it_node.checkZigzag(it_node.value)){
                return false;
            }
        }
        return true;
    }

    





    


}
