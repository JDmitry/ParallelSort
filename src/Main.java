import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OriginalArray originalArray = new OriginalArray();
        originalArray.displayOriginalArray();

        NewArray newArray = new NewArray(originalArray, 20);
        newArray.displayNewArray();

        ExecutorService service = Executors.newFixedThreadPool(5);

        List<Callable<int[]>> call = new ArrayList<>();
        for ( int i = 0; i < newArray.getChunckArray().length; i++) {
            call.add(new Task(newArray.getChunckArray()[i]));
        }

        List<Future<int[]>> result = service.invokeAll(call);

        service.shutdown();

        System.out.println("Sorted array: ");
        System.out.println("[");
        for (int i = 0; i < newArray.getChunckArray().length; i++) {
            System.out.print(Arrays.toString(result.get(i).get()));
            System.out.print("\n");
        }
        System.out.println("]");
    }
}
