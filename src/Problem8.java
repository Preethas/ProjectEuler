import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. 
 * What is the value of this product?
 * @author  preetha
 *
 */


public class Problem8 {
	public static void main(String[] args) {
		if(args.length == 0 || args[0] == null || args[1] == null){
		     System.out.println("Proper Usage is: java Problem8 <n> <filepath>");
		     System.exit(0);
		}
		Problem8 problem8 = new Problem8();
		long answer = problem8.compute(Integer.parseInt(args[0]),args[1]);
		System.out.println(answer);
	}
	
	private long compute(int m, String filepath){
		long max = 0L;
		StringBuilder buffer = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNext()){
				String line = scanner.nextLine();
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String s=buffer.toString();
		for (int i=0;i<s.length()-m;i++){
			String mDigits = s.substring(i, i+m);
			long digitalProduct = getProduct(mDigits);
			if (digitalProduct > max) max = digitalProduct;
		}
		return max;
		
	}
	
	private long getProduct(String s){
		long product = 1;
		if (!s.contains("0")){
			for (int i=0;i<s.length();i++){
			  product*= Long.parseLong(s.charAt(i) + "");
			}
		}
		return product;
	}
	

}
