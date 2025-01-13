package primenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeNumberTask implements Callable<List<Integer>> {
    public int start;
    public int end;

    public PrimeNumberTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isSimple(i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean isSimple(int num) {
        if (num < 2) {
            return false;
        }
        for (int k = 2; k <= Math.sqrt(num); k++) {
            if (num % k == 0) {
                return false;
            }
        }
        return true;
    }
}

