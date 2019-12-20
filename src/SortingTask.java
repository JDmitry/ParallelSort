import java.util.Arrays;
import java.util.concurrent.Callable;

class SortingTask implements Callable<int[]> {

    private int[] arr;

    public SortingTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] call(){
        Arrays.sort(arr);
        return arr;
    }
}
