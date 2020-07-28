package arrays;
import java.util.Arrays;

public class ChairsNeeded {
	public static void main(String[] args) {
		int [] S = {1, 2, 6, 5, 3};
		int [] E = {5, 5, 7, 6, 8};
		Arrays.sort(S);
        Arrays.sort(E);
        int noChairsReqd = 0;
        int endItr = 0;
        for(int i=0;i<S.length;i++){
            if(S[i]<E[endItr]){
                noChairsReqd++;
            }else{
                endItr++;
            }
        }
        System.out.println(noChairsReqd);
	}
}
