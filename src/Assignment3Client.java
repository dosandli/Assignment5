
/**
 *
 * @author Donnie Sandlin
 */
public class Assignment3Client {
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args){
    
    
    Assignment3 test = new Assignment3();
    
    
    test.readFile();
    test.readSpelling();
    System.out.println(test);

    }
  
}
//Output
/*
run:
Words found/correct words: 940320.0
Words Not Found/incorrect: 59221.0
total comparison: 1.5295584E7
word incorrect comparison: 568198.0
avg word found: 16.266360387953036
avg word not found: 9.594535722125597
BUILD SUCCESSFUL (total time: 4 seconds)

*/
