public class Floodfill
{
    
    public enum Color
    {
        Red, Green, Blue
    }

    public static Color[][] getTestPicture()
    {
        Color[][] test = {{ Color.Red, Color.Red, Color.Blue, Color.Green, Color.Blue },
                { Color.Red, Color.Blue, Color.Blue, Color.Blue, Color.Blue },
                { Color.Red, Color.Red, Color.Blue, Color.Green, Color.Green},
                { Color.Red, Color.Red, Color.Green, Color.Green, Color.Green}};
        return test;
    }

    public static Color[][] getResultPicture()
    {
        Color[][] result1 = {{ Color.Blue, Color.Blue, Color.Blue, Color.Green, Color.Blue },
                { Color.Blue, Color.Blue, Color.Blue, Color.Blue, Color.Blue },
                { Color.Blue, Color.Blue, Color.Blue, Color.Green, Color.Green},
                { Color.Blue, Color.Blue, Color.Green, Color.Green, Color.Green}};
        return result1;
    }

    public static void printMatrix(Color[][] picture)
    {
        for (Color[] col: picture)
        {
            for (Color elem : col)
            {
                System.out.print("[" + elem + "]");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args)
    {
        Color[][] testPicture = getTestPicture();
        printMatrix(testPicture);
        testPicture = floodFill(testPicture, 3, 1, Color.Blue);

        System.out.println("-------------");
        printMatrix(testPicture);
      
        Color[][] comparePicture = getResultPicture();
        //Not the best unit test, but meh.
        for (int i = 0; i < testPicture.length; i++)
        {
            for (int j = 0; j < testPicture[i].length; j++)
            {
                if (testPicture[i][j] != comparePicture[i][j])
                {
                    System.out.println("Flood fill didn't work =(");
                    System.out.println("Cell at " + i + ", " + j + " did not match.");
                    return;
                }
            }
        }
    }

    //provide public entry to flood fill
    public static Color[][] floodFill(Color[][] picture, int col, int row, Color newColor)
    {
        return floodFill(picture, col, row, picture[col][row], newColor);
    }

    private static Color[][] floodFill(Color[][] picture, int col, int row, Color oldColor, Color newColor)
    {
        if (oldColor == newColor)
        {
            return picture;
        }
        if (picture[col][row] != oldColor)
        {
            return picture;
        }

        picture[col][row] = newColor;

        //Check left edge
        if (col != 0)
        {
            picture = floodFill(picture, col - 1, row, oldColor, newColor);
        }

        //Check right edge
        if (col != picture.length - 1)
        {
            picture = floodFill(picture, col + 1, row, oldColor, newColor);
        }

        //Check top edge
        if (row != 0)
        {
            picture = floodFill(picture, col, row - 1, oldColor, newColor);
        }

        //Check bottom edge
        if (row != picture[col].length - 1)
        {
            picture = floodFill(picture, col, row + 1, oldColor, newColor);
        }

        return picture;
    }
}
