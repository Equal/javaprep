import java.util.Map;
import java.util.HashMap;

public class StringManipulation
{
    //I could throw exceptions for bad arguments instead, but returning an empty string was easier
    public static String substrPrime(String str, int start, int end)
    {
        if (start < 0 || start >= str.length() || start >= end || end > str.length())
        {
            return "";
        }

        //I'm not sure how this function was supposed to be different from the .substring() function, so I decided to do it manually, in case that's what you wanted
        char[] cStr = str.toCharArray();
        char[] cSubStr = new char[end - start];
        for (int i = 0; i < end - start; i++)
        {
            cSubStr[i] = cStr[i+start];
        }

        return new String(cSubStr);
    }

    public static Map<Character, Integer> frequency(String str)
    {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (Character ch : str.toCharArray())
        {
            if (freq.containsKey(ch))
            {
                freq.put(ch, freq.get(ch) + 1);
            }
            else
            {
                freq.put(ch, 1);
            }
        }
        return freq;
    }

    public static void main (String[] args)
    { 
        System.out.println(substrPrime("Hello World!", 3, 5));
        System.out.println(frequency("Hello World!"));
    }
}
