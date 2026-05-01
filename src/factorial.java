public class factorial {
    public static void main(String[] args){
        int number = 5;
        System.out.println("factorial of " + number +" is " +factorial(number));

    }
    public static long factorial(int n){
        if (n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
