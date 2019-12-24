public class ChunkedArray {
    private int[][] chunckedArray;

    public ChunkedArray(OriginalArray originalArray, int chunckSize) {
        chunckedArray = createChunck(originalArray.getOriginal(), chunckSize);
    }

    public int[][] createChunck(int[] arr, int chunckSize) {
        int count = 0;
        int countChunck = 0;
        double num = (double) arr.length/chunckSize;
        int arrayLength = (int) Math.ceil(num);
        chunckedArray = new int[arrayLength][];
        int lastChunckSize = arrayLength - 1;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < chunckSize; j++) {
                if (lastChunckSize == i) {
                    chunckedArray[i] = new int[arr.length - countChunck];
                    break;
                }
                chunckedArray[i] = new int[chunckSize];
                countChunck++;
            }
        }

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < chunckSize; j++) {
                if (count == arr.length) {
                    break;
                }
                chunckedArray[i][j] = arr[count++];
            }
        }
        return chunckedArray;
    }

    public void displayChunckedArray() {
        System.out.println();
        System.out.println("Chuncked array: ");
        System.out.println("[ ");
        for (int i = 0; i < chunckedArray.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < chunckedArray[i].length; j++) {
                System.out.print(chunckedArray[i][j] + " ");
            }
            System.out.print("]\n");
        }
        System.out.print("]\n\n");
    }

    public int[][] getChunckedArray() {
        return chunckedArray;
    }
}

