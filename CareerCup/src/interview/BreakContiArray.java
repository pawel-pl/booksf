package interview;

public class BreakContiArray {

    public static void getBreakEvenPoint(int[] arr) {
        int first = 0;
        int second = 0;
        for(int i: arr) { second += i; }

        for(int i=0; i < arr.length-1; i++) {
            first = first + arr[i];
            second = second - arr[i];
            if(first == second ) {
                System.out.println("Break even point is: "+i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,2,5,4,4};
        BreakContiArray.getBreakEvenPoint(arr);


    }
}
