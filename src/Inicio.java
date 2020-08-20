import java.util.concurrent.Semaphore;


public class Inicio {

    static int primeiro = 0;
    static int ultimo = 0;

    public static void main(String[] args) {

        String [ ] buffer  = new String[100];

        Semaphore mutex = new Semaphore( 1 );
        Semaphore itens = new Semaphore( 0 );
        Semaphore espacos = new Semaphore( 100 );

        Loja l1 = new Loja(buffer, mutex, itens, espacos);
        Loja l2 = new Loja(buffer, mutex, itens, espacos);
        Loja l3 = new Loja(buffer, mutex, itens, espacos);
        Loja l4 = new Loja(buffer, mutex, itens, espacos);
        Loja l5 = new Loja(buffer, mutex, itens, espacos);
        Loja l6 = new Loja(buffer, mutex, itens, espacos);
        Loja l7 = new Loja(buffer, mutex, itens, espacos);
        Loja l8 = new Loja(buffer, mutex, itens, espacos);
        Fabricante f1 = new Fabricante(buffer, mutex, itens, espacos, 0);
        Fabricante f2 = new Fabricante(buffer, mutex, itens, espacos, 1);
        Fabricante f3 = new Fabricante(buffer, mutex, itens, espacos, 2);
        Fabricante f4 = new Fabricante(buffer, mutex, itens, espacos, 3);
        Transportadora t1 = new Transportadora(buffer, mutex, itens, espacos);
        Transportadora t2 = new Transportadora(buffer, mutex, itens, espacos);

        l1.start();
        l2.start();
        l3.start();
        l4.start();
        l5.start();
        l6.start();
        l7.start();
        l8.start();
//        f1.start();
//        f2.start();
//        f3.start();
//        f4.start();
//        t1.start();
//        t2.start();
    }

}
