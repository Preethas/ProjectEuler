import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * @author Preetha
 *
 */

public class Problem13 {
  public static void main(String args[]){
	  Problem13 problem6 = new Problem13();
	  if(args.length == 0){
	     System.out.println("Proper Usage is: java Problem6 <filepath>");
	     System.exit(0);
	  }
	  problem6.compute(args[0]);
  }
  
  public void compute(String filePath){
	  List<String> list = new ArrayList<String>();
	  try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
		    //1. Read the file line by line
		    //2. Result is a list of strings
		    //3. Reduce the list to get the sum
			list = stream
					.map(s -> {
						return s;
					}).collect(Collectors.toList());
			 
			Optional<String> answer = list.stream().reduce((a,b)->{
				BigInteger biga = new BigInteger(a);
				BigInteger bigb = new BigInteger(b);
				return biga.add(bigb).toString();
			});
			answer.ifPresent(ix->System.out.println("The first ten digits are " + ix.substring(0, 10)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
  }
}
