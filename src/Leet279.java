import java.util.ArrayList;

public class Leet279 {
        public static void main(String[] args) {
            Leet279 l = new Leet279();
            System.out.println(l.numSquares(12));
            
        }
        public int numSquares(int n) {
            int a[];

            ArrayList<Integer> squares = new ArrayList<Integer>();
            for(int i = 0; i < n-1; i++){
                squares.add(i*i);
            }
            return findMinFullSquareSum(n,squares);

        }

        public int findMinFullSquareSum(int n, ArrayList<Integer> squares){
            for(int i = squares.size() - 1; i >= 0; i--) {
                int remain = n - i*i;
                if(remain < 0){
                    continue;
                }
                if (remain == 0){
                    System.out.println(i);
                    return 1;
                }
                int k = findMinFullSquareSum(remain,squares);
                if( k == -1){
                    return -1;
                }else {
                    System.out.println(i);
                    return k + 1;
                }
            }
            return -1;
        }

}
