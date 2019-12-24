public class OriginalArray {
    private static final int LENGTH = 19;
    private static final int MAX_VALUE = 50;
    private int[] original;

    public OriginalArray() {
        original = new int[LENGTH];
        initOriginalArray();
    }

    public void initOriginalArray() {
        for (int i = 0; i < original.length; i++) {
            original[i] = (int)(Math.random() * MAX_VALUE + 1);
        }
    }

    public void displayOriginalArray() {
        System.out.println("Original array: ");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + ", ");
        }
        System.out.println();
    }

    public int[] getOriginalArray() {
        return original;
    }
}
