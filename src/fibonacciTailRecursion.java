class FibonacciTailRecursion {
    public static void main(String[] args) {
        System.out.println(fibonacciTailRecursion(10));
    }
    public static long fibonacciTailRecursion(long index) {
        return fibonacciTailRecursion(index, 0, 1);
    }

    public static long fibonacciTailRecursion(long index, int curr, int next) {
        System.out.printf("index %d, curr %d, next %d \n",index,curr,next);
        if (index == 0) {
            return curr;
        } else {
            return fibonacciTailRecursion(index - 1, next, curr + next);
        }
    }

}
