import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NewArray newArray = new NewArray();
        newArray.displayTwoArrays();

        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<NewArray> future = service.submit(() -> {
            for (int i = 0; i < newArray.getSize(); i++) {
                Arrays.sort(newArray.getChunckedArray()[i]);
            }
            return newArray;
        });

        service.shutdown();

        System.out.println("Sorted array: ");
        System.out.println("[");
        for (int i = 0; i < newArray.getSize(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < newArray.getArrayLegth(); j++){
                System.out.print(future.get().getChunckedArray()[i][j] + " ");
            }
            Thread.sleep(1000);
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
