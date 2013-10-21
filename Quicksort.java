//In place quicksort - not a stable sort!
//Holy crap this had a lot of moving parts. I might stick with a normal quicksort in interviews because they're easier to implement, even if the space requirement is O(n) instead of O(logn)

public class Quicksort<T extends Comparable<T>>
{
    public static void main(String[] args)
    {
        Quicksort<Integer> sort = new Quicksort<Integer>();
        Integer[] arr = { 6, 9, 3, 4, 1, 123, 34, 2356, 234, 72, 347, 233, 133 };
        arr = sort.quicksort(arr, 0, arr.length - 1);
        for (Integer i : arr)
        {
            System.out.println(i);
        }
    }

    public T[] quicksort(T[] arr, int left, int right)
    {
        if (left < right) {
            //pivot is median of left, middle and right values
            T leftVal = arr[left];
            T rightVal = arr[right];
            T middleVal = arr[(int)Math.floor((right - left)/2)];
            int pivotIndex;

            //is there an easier way to find a median? using Math.min constrains me too much in types
            if (leftVal.compareTo(middleVal) <= 0 && middleVal.compareTo(rightVal) <= 0)
            {
                pivotIndex = (int)Math.floor((right-left)/2);
            } 
            else if ((middleVal.compareTo(leftVal) <= 0  && leftVal.compareTo(rightVal) <= 0) || (rightVal.compareTo(leftVal) <= 0 && leftVal.compareTo(middleVal) <=0))
            {
                pivotIndex = left;
            }
            else
            {
                pivotIndex = right;
            }

            pivotIndex = partition(arr, left, right, pivotIndex);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
        return arr;
    }

    private int partition(T[] arr, int left, int right, int pivotIndex)
    {
        T pivotValue = arr[pivotIndex];
        swap(arr, right, pivotIndex);
        int storeIndex = left;
        for (int i = left; i <= right - 1; i++)
        {
            if (arr[i].compareTo(pivotValue) <= 0)
            {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    //swap two values in the array
    private void swap(T[] arr, int i, int k)
    {
        T val = arr[i];
        arr[i] = arr[k];
        arr[k] = val;
    }

}
