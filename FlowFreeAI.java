 public static void fileReader(){


    BufferedReader reader = null;
    BufferedReader next_reader = null;
    try {
        File file = new File(M_MEDIUM_MAZE);
        reader = new BufferedReader(new FileReader(file));

        String line;
        int line_times = 0;
        int row = 0;
        int column = 0;
        List<Node> maze_map = MazeMap.curr_map;

        //detector for next line equals null

        while ((line = reader.readLine()) != null) {
            // System.out.println(line);
            MazeMap.width = line.length();
            for (column = 0; column < line.length(); column++ ) {
                //initialize the board;

                maze_map.add(new Node(column, row, line.charAt(column)));//add every single node of char to the MazeMap
                Node curr_node = MazeMap.getNode(column, row);

                if (MazeMap.getNode(column, row).value == 'P'){
                    MazeMap.startNode = curr_node;
                    MST.vertices.add(MazeMap.startNode);
                }
                if (MazeMap.getNode(column, row).value == '.'){
                    MazeMap.destination = curr_node;
                    MultiDots.destinations.add(curr_node);
                    MST.vertices.add(curr_node);
                }

                if(column == 0){MazeMap.getNode(column, row).left_child = null;} //left most
                else{
                    MazeMap.getNode(column, row).left_child =
                    MazeMap.getNode(column-1, row);
                    MazeMap.getNode(column-1, row).right_child = MazeMap.getNode(column, row);

                }
                //y cases
                if(row == 0){MazeMap.getNode(column, row).up_child = null;} // up most
                else{
                    MazeMap.getNode(column, row).up_child = MazeMap.getNode(column, row-1);
                    MazeMap.getNode(column, row-1).down_child = MazeMap.getNode(column, row);
                }
                int position = (row * MazeMap.width + column);
            }
            row++;
        }

        MazeMap.setWalls();//set walls and node blocked attribute


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