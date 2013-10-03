import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
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

    //I do not have a test to check that it throws an exception. I'm aware that I should test it, though.
    public static void testZip() throws TestFailedException
    {
        List<String> indices = new ArrayList<String>();
        List<Integer> values = new ArrayList<Integer>();
        Map<String, List<Integer>> expected = new HashMap<String, List<Integer>>();

        indices.add("A");
        indices.add("B");
        indices.add("C");
        indices.add("A");

        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        //How can I create the array list and add the values in one line?
        List<Integer> expectedA = new ArrayList<Integer>();
        expectedA.add(1);
        expectedA.add(4);

        List<Integer> expectedB = new ArrayList<Integer>();
        expectedB.add(2);

        List<Integer> expectedC = new ArrayList<Integer>();
        expectedC.add(3);

        expected.put("A", expectedA);
        expected.put("B", expectedB);
        expected.put("C", expectedC);

        try {
            Map<String, List<Integer>> result = ZipExample.zip(indices, values);
            if (!expected.equals(result))
            {
                throw new TestFailedException("Zipping is not working!" , expected, result);
            }
        }
        catch (Exception e)
        {
            throw new TestFailedException("Zipping threw an error!", expected, e);
        }
    }

    public static void testLinkedListReverse() throws TestFailedException
    {
    }

    public static void main (String[] args) 
    {
        try
        {
            testReverseList();
            testZip();
        }
        catch (Exception e)
        {
            System.out.println("Failed!");
            System.out.println(e);
        }
    }

}
