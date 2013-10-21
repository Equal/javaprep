import java.util.Arrays;

//Naive implementation not using hashcode - kinda stupid because it's not constant time
public class Hashtable <K, T>
{
    private K[] keys = null;
    private T[] values = null;
    private int size;

    public Hashtable()
    {
        //start as one, double when needed - gotta make this dynamic sigh
        keys = (K[])new Object[1];
        values = (T[])new Object[1];
        size = 0;
    }

    private void resize()
    {
        this.keys = Arrays.copyOf(this.keys, this.keys.length*2);
        this.values = Arrays.copyOf(this.values, this.values.length*2);
    }

    public void clear()
    {
        keys = (K[])new Object[1];
        values = (T[])new Object[1];
        this.size = 0;
    }

    public boolean contains(T val)
    {
        for (T v : this.values)
        {
            if (v.equals(val))
            {
                return true;
            }
        }
        return false;
    }

    public boolean containsKey(K key)
    {
        for (K k : this.keys)
        {
            if (k.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Hashtable h)
    {
        if (this.keys.equals(h.keys()) && this.values.equals(h.values()))
        {
            return true;
        }
        return false;
    }

    public K[] keys()
    {
        return this.keys;
    }

    public T[] values()
    {
        return this.values;
    }

    public T get(K key)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (this.keys[i].equals(key))
            {
                return this.values[i];
            }
        }
        return null;
    }

    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        return false;
    }

    public void put(K key, T val)
    {
        if (this.size == this.keys.length - 1)
        {
            this.resize();
        }

        this.keys[size] = key;
        this.values[size] = val;
        this.size = this.size + 1;
    }

    public void remove(K key)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (this.keys[i].equals(key))
            {
                this.keys[i] = null;
                this.values[i] = null;
                this.size--;
            }
        }
    }

    public int size()
    {
        return this.size;
    }
}



