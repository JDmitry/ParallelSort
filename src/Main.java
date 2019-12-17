import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OriginalArray originalArray = new OriginalArray();
        originalArray.displayOriginalArray();

        NewArray newArray = new NewArray(originalArray, 20);
        newArray.displayNewArray();

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<NewArray> future = service.submit(() -> {
            for (int i = 0; i < newArray.getArrayLegth(); i++) {
                Arrays.sort(newArray.getChunckArray()[i]);
            }
            return newArray;
        });

        service.shutdown();

        System.out.println("Sorted array: ");
        System.out.println("[");
        for (int i = 0; i < newArray.getArrayLegth(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < newArray.getChunckSize(); j++){
                System.out.print(future.get().getChunckArray()[i][j] + " ");
            }
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
