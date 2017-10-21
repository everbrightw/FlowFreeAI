import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Utilities{
    final static String FIVE_BOARD = "input55.txt";
    final static String SEVEN_BOARD = "input77.txt";
    final static String EIGHT_BOARD = "input88.txt";
    final static String NINE_BOARD = "input99.txt";

 public static void fileReader(){


    BufferedReader reader = null;
    BufferedReader next_reader = null;

    try {
        File file = new File(NINE_BOARD);
        reader = new BufferedReader(new FileReader(file));

        String line;

        int row = 0;
        int column = 0;

        List<Node> board = Board.board;

        //detector for next line equals null
        while ((line = reader.readLine()) != null) {
      
            Board.width = line.length();
            for (column = 0; column < line.length(); column++ ) {

                //initialize the board;
                board.add(new Node(column, row, line.charAt(column)));//add every single node of char to the Board
                Node curr_node = Board.getNode(column, row);

                if (Board.getNode(column, row).value != '_'){
                    //make sure we only store one source node to the sNodes List;

                    boolean contains = false;
                    for (Node it_node : Board.sNodes ) {
                        if(it_node.value == curr_node.value){
                            contains = true;
                        }
                    }

                    if(!contains){
                        Board.sNodes.add(curr_node);
                    }

                    curr_node.isSource = true;// set current node as source node
                   
                }

                //connect nodes to each other
                if(column == 0){Board.getNode(column, row).left_child = null;} //left most

                else{
                    Board.getNode(column, row).left_child =
                    Board.getNode(column-1, row);
                    Board.getNode(column-1, row).right_child = Board.getNode(column, row);
                }

                //y cases
                if(row == 0){Board.getNode(column, row).up_child = null;} // up most
                else{
                    Board.getNode(column, row).up_child = Board.getNode(column, row-1);
                    Board.getNode(column, row-1).down_child = Board.getNode(column, row);
                }
            
            }
            row++;
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  }

}