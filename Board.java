import java.util.*;

class Board{

	public static List<Node> board = new ArrayList<>();

	public static int width;

	public static List<Node> sNodes = new ArrayList<>();

	 public static void printMap() {
        for (int i = 0; i < board.size(); i++) {
            System.out.print(board.get(i).value);
            if ((i + 1) % width == 0) {
                System.out.println();
            }
        }
    }

    public static Node getNode(int x, int y) {
        return board.get(width * y + x);
    }

  

}