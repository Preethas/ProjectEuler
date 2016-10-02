/**
 *  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 *  The sum of these multiples is 23.
 *  Find the sum of all the multiples of 3 or 5 below 1000.
 *  @author Preetha
 *  
 *  Sum of Multiples of 3 upto 1000 are 3+6+9 ... 999 which is  3(1+2+3 + ...333)
 *  Sum of Multiples of 5 upto 1000 are 5+10+15 ...995 wich is  5(1+2+3 + ...199);
 *  Sum of Multiples of 15 upto 1000 are 15+30+45 ...990 wich is  15(1+2+3 + ...66);
 *  Final Sum =  Sum of Multiples of 3 +  Sum of Multiples of 5 -  Sum of Multiples of 15
 *  Sequence summation formula for n terms = n(n+1)/2
 *  Final Sum = 3 * [n * (n+1)/2] + 5 * [n * (n+1)/2] - 15 * [n * (n+1)/2] with n as 333,199 and 66 
 *
 */
public class Problem1 {

	public static void main(String[] args) {
		Problem1  problem1 = new Problem1();
		System.out.println(problem1.compute(1000,3,5));
	}
	
	private int compute(int m,int i,int j){
		int k = i*j;
		int HM_I = -1; // Highest multiple of i less than m
		int HM_J = -1; // Highest multiple of j less than m
		int HM_K = -1; // Highest multiple of k less than m
		
		for(int no = m-1; no > 0; no--){
			if (HM_I == -1 && no % i == 0) HM_I = no;
			if (HM_J == -1 && no % j == 0) HM_J = no;
			if (HM_K == -1 && no % k == 0) HM_K = no;
			
			if (HM_I > -1 && HM_J > -1 && HM_K > -1){
				break;
			}
		}
		int HF_I = HM_I/i; // Highest factor of i less than m
		int HF_J = HM_J/j; // Highest factor of j less than m
		int HF_K = HM_K/k; // Highest factor of k less than m
		
		// Summation of sequence of n terms n(n+1)/2
		int sum  = i*(HF_I * (HF_I+1))/2 + j*(HF_J * (HF_J+1))/2 - k*(HF_K * (HF_K+1))/2;
		
		return sum;
	}

}
