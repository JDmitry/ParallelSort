public class ChunkedArray {
    private  int chunckSize;
    private double arrayLength;
    private int[][] chunckArray;

    public ChunkedArray(OriginalArray originalArray, int chunckSize) {
        chunckArray = creatChunck(originalArray.getOriginal(), this.chunckSize=chunckSize);
    }

    public int[][] creatChunck(int[] arr, int chunckSize) {
        int count = 0;
        int countChunck = 0;
        arrayLength = (double) arr.length/chunckSize;
        int num = (int) Math.ceil(arrayLength);
        chunckArray = new int[num][];
        int max = num - 1;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < chunckSize; j++) {
                if (max == i) {
                    chunckArray[i] = new int[arr.length - countChunck];
                    break;
                }
                chunckArray[i] = new int[chunckSize];
                countChunck++;
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < chunckSize; j++) {
                if (count == arr.length) {
                    break;
                }
                chunckArray[i][j] = arr[count++];
            }
        }
        return chunckArray;
    }

    public void displayChunckedArray() {
        System.out.println();
        System.out.println("Chuncked array: ");
        System.out.println("[ ");
        for (int i = 0; i < chunckArray.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < chunckArray[i].length; j++) {
                System.out.print(chunckArray[i][j] + " ");
            }
            System.out.print("]\n");
        }
        System.out.print("]\n\n");
    }

    public int[][] getChunckArray() {
        return chunckArray;
    }
}

