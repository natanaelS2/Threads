import java.util.ArrayList;
import java.util.List;
public class VerificaNumerosPrimos {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (String arg : args) {
            int numero = Integer.parseInt(arg);
            Thread n = new Thread(() -> {
                if (isNumeroPrimo(numero)) {
                    System.out.println("O número " + numero + " é primo.");
                } else {
                    System.out.println("O número " + numero + " não é primo.");
                }
            });
            threads.add(n);
            n.start();
        }
        for (Thread n : threads) {
            try {
                n.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isNumeroPrimo(int numero) {
        if (numero <= 1) return false;
        int i;
        for ( i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
}
