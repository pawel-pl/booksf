package interview;

/*
 * http://www.careercup.com/question?id=4847342612119552
 */
public class ServerCapacity {

    public static void main(String[] args) {
        // int[] need = {18, 4, 8, 4, 6, 6, 8, 8};
        // int[] capacity = { 8, 16, 8, 32};
        int[] need = { 2, 2, 2, 3 };
        int[] capacity = { 4, 5 };
        System.out.println(schedule(need, capacity));
    }

    public static boolean schedule(int[] need, int[] capacity) {
        // check if total capacity is enough
        // check all can be scheduled
        return sumOfArray(capacity) >= sumOfArray(need) && schedule(0, need, capacity);
    }

    private static boolean schedule(int i, int[] need, int[] capacity) {
        if (i >= need.length)
            return true;

        for (int k = 0; k < capacity.length; ++k) {
            if (capacity[k] >= need[i]) {
                capacity[k] -= need[i];
                if (schedule(i + 1, need, capacity))
                    return true;
                capacity[k] += need[i];
            }
        }
        return false;
    }

    private static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
