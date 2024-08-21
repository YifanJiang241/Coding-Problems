public class Presum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,3,3,3,3,7};
        for(int i = 0; i < arr.length; i++){
            System.out.println("i: " + i);
            int j = i;
            while(j < arr.length - 1 && arr[j] == arr[++j]);
            System.out.println(arr[j]);
        }

    }
}
