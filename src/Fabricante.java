import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fabricante extends Thread {

    private String[] buffer;
    private Semaphore mutex, itens, espacos;
    private int ID;

    public Fabricante(String[] buffer, Semaphore mutex,
                Semaphore itens, Semaphore espacos, int ID)

    {
        this.buffer = buffer;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
        this.ID = ID;
    }

    public void run()
    {
        while (true)
        {
            try {
                itens.acquire();
                mutex.acquire();
                String k = buffer[Inicio.primeiro];
                Inicio.primeiro = (Inicio.primeiro + 1) % 100;
                System.out.println("Fabricado: " + k);
                mutex.release();
                espacos.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
