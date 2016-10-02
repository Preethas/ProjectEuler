import java.util.HashMap;
import java.util.Map;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 1*2* .. 10 will be the largest number that is divisible by each number between 1 and 10
 * But we need the smallest 
 * We write each number between 1 and 10 as a product of its prime factors
 * 2 = 2 
 * 3 = 3
 * 4 = 2 ^ 2
 * 5 = 5
 * 6 = 2 * 3
 * 7 = 7
 * 8 = 2 ^ 3
 * 9 = 3 ^ 2
 * To build any number between 1 and 10 we need 2 ^ 3 , 3 ^ 2 , 5 and 7 
 * The product is 8 * 9 * 5 * 7 which is 2520
 * We extend this logic for 20
 * 
 * @author Preetha
 *
 */

public class Problem5 {
	
    public static void main(String[] args) {
    	Problem5 problem5 = new Problem5();
    	int m = 20;
    	System.out.println(problem5.compute(m));
    	// Run tests
    	//runTests();
    }
    
    public static void runTests(){
    	Problem5 problem5 = new Problem5();
    	System.out.println(problem5.compute(10) == 2520 ? "m=10 Pass" : "m=10 Fail") ;
    	System.out.println(problem5.compute(1) == 1? "m=1 Pass" : "m=1 Fail" );
    	System.out.println(problem5.compute(0) == 0? "m=0 Pass" : "m=0 Fail" );
    	System.out.println(problem5.compute(-1) == 0? "m=-1 Pass" : "m=-1 Fail" );
    	System.out.println(problem5.compute(20) == 232792560 ? "m=20 Pass" : "m=20 Fail") ;
    }
    
	public  int compute(int m) {
	 int answer = 0;	
	 if (m >= 1){
	  Map<Integer, Integer> factorMap = new HashMap<Integer, Integer>();
	  while (m > 0) {
	   populatePrimeDivisors(m--,factorMap);
	  }
	  answer =  getProduct(factorMap);
	 }
	 return answer;
	}

    private  int getProduct(Map<Integer,Integer> factorMap){
     int product = 1;
     for (Map.Entry<Integer, Integer> entry : factorMap.entrySet()){
    	product*= Math.pow(entry.getKey(),entry.getValue());
     }
     return product;
    }
    
    private void populatePrimeDivisors(int product,Map<Integer,Integer> factorMap) {
        for (int factor = 2; factor <= product; factor++) {
            int exponent = 0;
            while (product % factor == 0) {
                product /= factor;
                exponent++;
            }
            if (exponent > 0) {
            	if (factorMap.containsKey(factor) ){
            		if (exponent > factorMap.get(factor)) factorMap.put(factor,exponent);
            	} else {
            		factorMap.put(factor,exponent);
            	}
            }
        }       
    }
}