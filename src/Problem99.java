import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Using base_exp.txt, a 22K text file containing one thousand lines with a base/exponent pair on each line, determine which line number has the greatest numerical value.
 * @author Preetha
 *
 */

public class Problem99 {
  public static void main(String args[]){
	  Problem99 problem99 = new Problem99();
	  if(args.length == 0){
	     System.out.println("Proper Usage is: java Problem99 <filepath>");
	     System.exit(0);
	  }
	  problem99.compute(args[0]);
  }
  
  public void compute(String filePath){
	  
	  try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			//1. Read a line , ex 3,2
			//2. convert it into token2*log(token2) , 2*log3 which is 0.6020
			//3. Result of map will be a list of values like  0.6020
		    //4. Reduce the list to find the max of values 
			List<Double> list = stream
					.map((s) -> {
						String[] tokens = s.split(",");
						Long base = new Long(tokens[0]);
						Long exp = new Long(tokens[1]);
						return exp * Math.log(base);
					}).collect(Collectors.toList());
			
			IntStream.range(0, list.size())
			  .reduce((a,b)->list.get(a)<list.get(b)? b: a)
			  .ifPresent(ix->System.out.println("The Line "+(ix+1)+ " has the maximum value" ));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
