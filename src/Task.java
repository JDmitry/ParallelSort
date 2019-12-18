import java.util.Arrays;
import java.util.concurrent.Callable;

public class Task implements Callable<int[]> {

    private int[] arr;

    public Task(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] call() throws Exception {
        Arrays.sort(arr);
        return arr;
    }
}
