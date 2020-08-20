import java.util.concurrent.Semaphore;

public class Transportadora extends Thread {

    private String[] buffer;
    private Semaphore mutex, itens, espacos;

    public Transportadora(String[] buffer, Semaphore mutex,
                Semaphore itens, Semaphore espacos)

    {
        this.buffer = buffer;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }
}
