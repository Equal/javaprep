public class Drop
{
    private String message;
    private boolean isEmpty = true;

    public synchronized void setMessage(String s)
    {
        while (!this.isEmpty)
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.message = s;
        isEmpty = false;
        notifyAll();
    }

    public synchronized String getMessage()
    {
        while (this.isEmpty)
        {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        this.isEmpty = true;
        notifyAll();
        return this.message;
    }

}
