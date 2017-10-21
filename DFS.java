import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DFS {
	public static void runDFS(Node startNode){
		// List<Node> sNodes = Board.sNodes;// get the source nodes

		Stack<Node> mStack = new Stack<>();
		mStack.push(startNode);


	}
    public static List<Node> unassigned = new ArrayList<Node>();

	public static boolean backTackSearch(List<Node> board){
		

		//Todo add local function complete in board
		if(Board.complete()){
			
			return true;
		}
		
		
		else{
			Node curr_node = unassigned.get(0);

			for (char it_color : curr_node.color_domain) {
			
				if(curr_node.checkConstraint(it_color)){
					curr_node.value = it_color;
				
					unassigned.remove(curr_node);

					boolean result = backTackSearch(board);
					System.out.println("running");
					if(result){
						return true;
					}
					else{
						unassigned.add(curr_node);
						if (!curr_node.isSource)
						    curr_node.value = '_';
					}
				}
			}
			return false;
		}

	}


	// public static void backTackSearch(){

	// 	int index = 0;
	// 	boolean lastFailure = false;
	// 	while(index == Board.board.size()-1){

	// 		Node curr_node = Board.board.get(index);

	// 		boolean colorAssignable = false;//true if this node can be assigned to a color

	// 		if(curr_node.sourceNode == false){
	// 		//if the curr_node is a sourceNode, then we dont check this node's color domain
	// 			for (char it_color : curr_node.color_domain) {

	// 				if(curr_node.checkConstraint(it_color)){

	// 					curr_node.color = it_color;
	// 					colorAssignable = true;

	// 				}

	// 				else{
	// 					curr_node.color_domain.remove(it_color);

	// 				}

	// 			}

	// 			if(!colorAssignable){
	// 				index--;
	// 			}
	// 			else{
	// 				index++;
	// 			}

	// 		}

	// 	}

	// 	//end code
	// }


}