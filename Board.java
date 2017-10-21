import java.util.*;

class Board{

	public static List<Node> board = new ArrayList<>();//store all nodes in a board

	public static int width;

	public static List<Node> sNodes = new ArrayList<>();

	public static List<Node> pathBoard = new ArrayList<>();

	 public static void printMap() {
	 	
        for (int i = 0; i < board.size(); i++) {
            System.out.print(board.get(i).value);
            if ((i + 1) % width == 0) {
                System.out.println();
            }
        }
    }

    public static void initPathBoard(){
    	for (Node it_node : board) {
    		pathBoard.add(it_node);
    	}
    }
   
    public static Node getNode(int x, int y) {
        return board.get(width * y + x);
    }

    public static boolean complete(){
        for (Node it_node : board) {
            if(it_node.value == '_'){
                return false;
            }
        }
        return true;
    }


    public static List<Character> setColorList(){
    List<Character> result = new ArrayList<>();
    for (Node node: sNodes) {
        if (!result.contains(node.value))
            result.add(node.value);
    }
    return result;
    }

    public static void iColorDomain(List<Character> default_color){
        for (Node it_node : board) {
            if(it_node.isSource){

                it_node.color_domain.add(it_node.value);
            }
            else{
                it_node.color_domain = default_color;
            }
            it_node.neighbor.add(it_node.left_child);
            it_node.neighbor.add(it_node.up_child);
            it_node.neighbor.add(it_node.right_child);
            it_node.neighbor.add(it_node.down_child);
        }
    }

  
  

}