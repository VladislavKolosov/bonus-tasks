package primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int end = 78;
        int numThreads = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int threadRange = (end - start + 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int from = threadRange * i + i;
            int to = threadRange * (i + 1);

            Future<List<Integer>> simpleIntegerList = executorService.submit(new PrimeNumberTask(from,to));
            try {
                arrayList.addAll(simpleIntegerList.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(arrayList);
        executorService.shutdown();
    }
}
