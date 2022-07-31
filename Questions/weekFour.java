package Questions;
import java.util.Arrays;

public class weekFour {
    public static void main(String[] args) {

        int[] grades = {5,2,6};
        Arrays.sort(grades);
        int sum = 0;
        int n = grades.length;

        int[] container = new int[n];

        //distributing container to each village based on their grade
        for(int i = 1; i <= n; i++){
            //adding container to each village

            sum += i;

            // storing the container count in an array
            container[i-1] = i;
        }
        System.out.println("minimum number of container required is : "+sum);
        System.out.println("container distribution is : "+Arrays.toString(container));

}
}
