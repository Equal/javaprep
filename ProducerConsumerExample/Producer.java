import java.util.Random;

public class Producer implements Runnable
{
    private Drop drop;

    public Producer(Drop d)
    {
        this.drop = d;
    }

    public void run()
    {
        String importantInfo[] = { "LOLZ"
                               , "CATS"
                               , "uh"
                               , "i think i'm..."
                               , "DONE"
        };

        Random random = new Random();
        for (int i = 0; i < importantInfo.length; i++)
        {
            drop.setMessage(importantInfo[i]);
            try
            {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
