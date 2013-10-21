public class ProducerConsumerExample
{
    public static void main(String[] args)
    {
        Drop d = new Drop();
        new Thread(new Producer(d)).start();
        new Thread(new Consumer(d)).start();
    }
}
