public class NewArray {
    private  int chunckSize;
    private int arrayLength;
    private int[][] chunckArray;

    public NewArray(OriginalArray originalArray, int chunckSize) {
        chunckArray = creatChunck(originalArray.getOriginal(), this.chunckSize=chunckSize);
    }

    public int[][] creatChunck(int[] arr, int chunckSize) {
        arrayLength = arr.length/chunckSize;
        int[][] chunckedArray = new int[arrayLength][chunckSize];
        int count = 0;
        for (int i = 0; i <arrayLength; i++) {
            for (int j = 0; j < chunckSize; j++){
                chunckedArray[i][j] = arr[count++];
            }
        }
        return chunckedArray;
    }

    public void displayNewArray() {
        System.out.println();
        System.out.println("Chuncked array: ");
        System.out.println("[ ");
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("[ ");
            for (int j = 0; j < chunckSize ; j++){
                System.out.print(chunckArray[i][j] + " "); ;
            }
            System.out.print("]\n");
        }
        System.out.print("]\n\n");
    }

    public int[][] getChunckArray() {
        return chunckArray;
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public int getChunckSize() {
        return chunckSize;
    }
}
