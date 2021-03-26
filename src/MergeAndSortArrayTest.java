
public class MergeAndSortArrayTest {

    public static void main(String[] params) {
        int[] array1 = new int[]{31, 88, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        int[] array2 = new int[]{22, 9, 16, 55, 32, 13, 38, 83, 66, 26, 49, 15, 44};

        int[] resultArray = new int[array1.length + array2.length];
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            resultArray[i] = array1[i];
            count++;
        }
        for (int j = 0; j < array2.length; j++) {
            resultArray[count++] = array2[j];
        }
        for (int i = 0; i < resultArray.length; i++) ;

        System.out.println("Объединенный массив: " + arrayToString(resultArray));
        resultArray = mergeSort(resultArray);
        System.out.println("Объединенный и отсортированный массив: " + arrayToString(resultArray));
    }

    public static int[] mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

        }
        return currentSrc;
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}