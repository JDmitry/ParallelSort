public class OriginalArray {
    private static final int LENGTH = 1000;
    private int[] original;

    public OriginalArray () {
        original = new int[LENGTH];
        initArray();
    }

    public void initArray() {
        for (int i = 0; i < original.length; i++) {
            original[i] = (int) (Math.random()*101);
        }
    }

    public void displayOriginalArray() {
        System.out.println("Original array: ");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + ", ");
        }
        System.out.println();
    }

    public int[] getOriginal() {
        return original;
    }
}
