package math;

public final class MathUtils {
    private static final int EI = -1;
    private MathUtils() {}

    public static int[] findElementsAfterDigit(int[] nubmers, int digit) {
        if (nubmers == null || nubmers.length ==0) {
            throw new RuntimeException("Array cannot be null or empty");
        }

        int idx = EI;
        for (int i = 0; i < nubmers.length; i++) {
            if (nubmers[i] == digit) {
                idx=i + 1;
            }
        }

        if (idx == EI) {
            throw new RuntimeException("Array does not contain any digit like: " + digit);
        }

        int size = nubmers.length - idx;
        int[] foundValues = new int[size];
        System.arraycopy(nubmers, idx, foundValues, 0, size);

        return foundValues;
    }

//    public static int[] returnArr(int[] arr) {
//        for (int i = arr.length-1; i >= 0; i--) {
//            if (arr[i] == 4) {
//                for (int j = i+1; j < arr.length; j++) {
//                    System.out.println(arr[j]);
//                }
//                return arr;
//            }
//        }
//        return arr;
//    }
}
