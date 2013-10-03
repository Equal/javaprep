import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class TestSection3 {

    public static class TestFailedException extends Exception
    {
        public TestFailedException(String message, Object expected, Object result) 
        {
            super(message + "\nExpected: " + expected.toString() + "\nActual Result: " + result.toString());
        }
    }

    private static void testReverseList() throws TestFailedException
    {
        List<Integer> orig = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        orig.add(1);
        orig.add(3);
        orig.add(2);
        orig.add(4);
        orig.add(6);

        expected.add(6);
        expected.add(4);
        expected.add(2);
        expected.add(3);
        expected.add(1);

        List<Integer> result = DataManipulation.reverse(orig);
        if (!expected.equals(result))
        {
            throw new TestFailedException("Reversing lists isn't working!", expected, result);
        }
    }

    public static void testZip()
    {
    }

    public static void testLinkedListReverse()
    {
    }

    public static void main (String[] args) 
    {
        try
        {
            testReverseList();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
