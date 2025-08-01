public class countPrime {
    public static void main(String[] args) {
        int total=100;
        int count=0;
        for (int j=1; j<=total; j++)
        if(isPrime(j)){
            ++count;
        }

        System.out.println("Total number of primes in "+total+" is : "+count);
    }

    static boolean isPrime(int n){
        if (n==1 || n==0){
            return false;
        }

    
        int mid=n/2;
        for(int i=2 ; i<=mid ; ++i){
            if (n%i==0){
                return false;
            }
        }

        System.out.println(n+" is a prime number.");
        return true;
    }
}
