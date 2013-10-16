//A function that takes the name of a movie to look up and width of the letter grid, and computes the key presses that will enter that string into the DVR grid. The output should be a string, with "u", "d", "l", "r", and "!" corresponding to up, down, left, right and select, respectively.
//For example, with a grid of width 5:
//A B C D E
//F G H I J
//K L M N O
//P Q R S T
//U V W X Y
//Z
//
//In order to spell the movie "UP", the function would output "dddd!u!"



public class MovieSelector {
    
    public static void main(String[] args)
    {
        DirectionGenerator dg = new DirectionGenerator("Theros", 5);
        System.out.println(dg.directions());
        dg = new DirectionGenerator("up", 5);
        System.out.println(dg.directions());
    }

    public static class Coordinate 
    {
        public int x;
        public int y;
        public Coordinate(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static class DirectionGenerator
    {
        public String directions;
        public String movieName;
        int gridWidth;
        public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public DirectionGenerator(String movie, int gw)
        {
            this.directions = "";
            this.movieName = movie;
            this.gridWidth = gw;
        }

        //movie name should not have special characters
        public String directions()
        {

            this.movieName = this.movieName.toUpperCase();
            char[] name = this.movieName.toCharArray();
            Coordinate c = new Coordinate(1, 1);

            for (char letter : name)
            {
                //Navigate to the letter
                c = getDirectionsTo(letter, c);
            }

            return this.directions;
        }

        private Coordinate getDirectionsTo(char letter, Coordinate c)
        {
            int x = c.x;
            int y = c.y;
            
            //Find the location on the grid of the letter
            Coordinate goal = locationOfLetter(letter, this.gridWidth);

            while (x != goal.x)
            {
                if (x < goal.x)
                {
                    this.directions += "R";
                    x++;
                }
                if (x > goal.x)
                {
                    this.directions += "L";
                    x--;
                }
            }

            while (y != goal.y)
            {
                if (y < goal.y)
                {
                    this.directions += "D";
                    y++;
                }
                if (y > goal.y)
                {
                    this.directions += "U";
                    y--;
                }
            }
            this.directions += "!";
            c.x = x;
            c.y = y;
            return c;
        }

        private Coordinate locationOfLetter(char letter, int gridWidth)
        {
            int index = alphabet.indexOf(letter) + 1; // To deal with 'A'
            int row = index % gridWidth == 0 ? ((int)Math.floor(index/gridWidth)) : ((int)Math.floor(index / gridWidth)) + 1;
            int col = index % gridWidth == 0 ? 5 : index % gridWidth; 
            System.out.println(letter + " index " + index + " row " + row + " col " + col);
            return new Coordinate(col, row);
        }
    }
}
