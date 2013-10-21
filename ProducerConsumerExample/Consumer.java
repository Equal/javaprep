import java.util.Random;
public class Consumer implements Runnable
{
    private Drop drop;
    public Consumer(Drop d)
    {
        this.drop = d;
    }

    public void run()
    {
        Random random = new Random();
        for (String s = this.drop.getMessage(); s != "DONE"; s = this.drop.getMessage())
        {
            System.out.println(s);
            try
            {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        System.out.println("DONE");
    }
}
