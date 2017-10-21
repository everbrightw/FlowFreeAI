

public class FlowFreeAI{
    public static void main(String[] args){
        Utilities.fileReader();
        Board.printMap();
        Board.iColorDomain(Board.setColorList());// initialie domain 
   //      for (Node it_node :Board.sNodes) {
   //          System.out.println(it_node.value);
   //      }
   //      System.out.println(" ");
   //      for (Node it_node :Board.board ) {
   //      	if(it_node.isSource){
   //      		System.out.println(it_node.value);
			// }
   //      }

      
       	Node startnode = Board.board.get(0);
       	DFS.unassigned.addAll(Board.board);
      	
       	DFS.backTackSearch(Board.board);
       	Board.printMap();
        
    }
}
