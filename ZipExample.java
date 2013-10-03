import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class ZipExample {
    
    public static void main(String[] args) {
        String[] indexArray = new String[3];
        indexArray[0] = "A";
        indexArray[1] = "B";
        indexArray[2] = "C";
        Integer[] valueArray = new Integer[3];
        valueArray[0] = 1;
        valueArray[1] = 2;
        valueArray[2] = 3;
        List<String> index = new ArrayList<String>(Arrays.asList(indexArray)); //I'm aware I could have just added to the list instead of doing an array conversion. I just wanted to relearn initializing arrays.
        List<Integer> values = new ArrayList<Integer>(Arrays.asList(valueArray));
        try {
            zip(index, values);
            index.add("C");
            values.add(4);
            zip(index, values);
            index.add("D");
            zip(index, values);
        } catch (InvalidListLengthException e) {
            System.out.println(e);
        }
    }

    public static Map<String, List<Integer>> zip (List<String> indices, List<Integer> values) throws InvalidListLengthException {
        if (indices.size() != values.size()) {
            throw new InvalidListLengthException("boo, lists are not equal length");
        }
        Map<String, List<Integer>> output = new HashMap<String, List<Integer>>();
        for (int i = 0; i < indices.size(); i++) {
            String index = indices.get(i);
            Integer value = values.get(i);
            if (output.containsKey(index)) {
                List<Integer> list = output.get(index);
                list.add(value);
                output.put(index, list);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(value);
                output.put(index, list);
            }
        }
        return output;
    }
}
