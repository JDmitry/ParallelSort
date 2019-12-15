public class NewArray {
    private final int size = 5;
    private int arrayLegth;
    private int[][] chunckedArray;
    private OriginalArray originalArray;

    public NewArray() {
        originalArray = new OriginalArray();
        chunckedArray = chunck(originalArray.getOriginal(), size);
    }

    public int[][] chunck(int[] arr, int size) {
        arrayLegth = arr.length/size;
        int[][] chunckedArray = new int[size][arrayLegth];
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr.length/size; j++){
                chunckedArray[i][j] = arr[count++];
            }
        }
        return chunckedArray;
    }

    public void displayTwoArrays() {
        originalArray.displayOriginalArray();
        System.out.println();
        System.out.println("Chuncked array: ");
        System.out.println("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print("[ ");
            for (int j = 0; j < originalArray.getOriginal().length/size ; j++){
                System.out.print(chunckedArray[i][j] + " "); ;
            }
            System.out.print("]\n");
        }
        System.out.print("]\n\n");
    }

    public int[][] getChunckedArray() {
        return chunckedArray;
    }

    public int getSize() {
        return size;
    }

    public int getArrayLegth() {
        return arrayLegth;
    }
}
