public class ChunkedArray {
    private int[][] chunkedArray;

    public ChunkedArray(OriginalArray originalArray, int chunkSize) {
        chunkedArray = createChunked(originalArray.getOriginalArray(), chunkSize);
    }

    public int[][] createChunked(int[] arr, int chunkSize) {
        int count = 0;
        int countChunk = 0;
        double num = (double) arr.length/chunkSize;
        int arrayLength = (int) Math.ceil(num);
        chunkedArray = new int[arrayLength][];
        int lastChunkSize = arrayLength - 1;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < chunkSize; j++) {
                if (lastChunkSize == i) {
                    chunkedArray[i] = new int[arr.length - countChunk];
                    break;
                }
                chunkedArray[i] = new int[chunkSize];
                countChunk++;
            }
        }

        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < chunkSize; j++) {
                if (count == arr.length) {
                    break;
                }
                chunkedArray[i][j] = arr[count++];
            }
        }
        return chunkedArray;
    }

    public void displayChunkedArray() {
        System.out.println();
        System.out.println("Chunked array: ");
        System.out.println("[ ");
        for (int i = 0; i < chunkedArray.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < chunkedArray[i].length; j++) {
                System.out.print(chunkedArray[i][j] + " ");
            }
            System.out.print("]\n");
        }
        System.out.print("]\n\n");
    }

    public int[][] getChunkedArray() {
        return chunkedArray;
    }
}

