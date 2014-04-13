package interview;

/*
 * http://www.careercup.com/question?id=4804004722769920
 */
public class CreateGroups {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Integer arr[] = { 1, 2, 5, 7 };
        int numberOfRelocations = n - k;
        int totalDiff = 0;
        int toMerge = 0;
        for (int i = 0; i < numberOfRelocations; i++) {
            int minDiff = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] == null)
                    continue;
                for (int l = j + 1; l < arr.length; l++) {
                    if (arr[j] == null)
                        continue;
                    if (minDiff > Math.abs(arr[l] - arr[j])) {
                        toMerge = arr[l] > arr[j] ? j : l;
                        minDiff = Math.abs(arr[l] - arr[j]);
                    }
                }
            }
            totalDiff += minDiff;
            arr[toMerge] = null;
        }
        System.out.println(totalDiff);
    }

}
