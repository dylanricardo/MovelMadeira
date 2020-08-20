import java.util.Random;
import java.util.concurrent.Semaphore;

public class Loja extends Thread {

    private String[] buffer;
    private Semaphore mutex, itens, espacos;

    public Loja(String[] buffer, Semaphore mutex,
                    Semaphore itens, Semaphore espacos)

    {
        this.buffer = buffer;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }

    public void run()
    {
        Random gerador = new Random();
        String alphabet = "ABCDEFGH";
        while (true)
        {
            try {
                String k = String.valueOf(alphabet.charAt(gerador.nextInt(alphabet.length())));
                espacos.acquire();
                mutex.acquire();
                buffer[Inicio.ultimo] = k;
                Inicio.ultimo = (Inicio.ultimo + 1) % 100;
                System.out.println("Vendido: " + k);
                mutex.release();
                itens.release();
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
