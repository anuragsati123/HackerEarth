import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
        public static void main(String args[] ) throws Exception {
    		/*
    		 * Read input from stdin and provide input before running
    		 */
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		String line = br.readLine();
    		int T = Integer.parseInt(line);
    		for (int t = 0; t < T; t++) {
    			line = br.readLine();
    			int N = Integer.parseInt(line);
    			line = br.readLine();
    			String[] inputs = line.split(" ");

    			int madhavTotal = 0;
    			int riyaTotal = 0;
    			int madhavCount = 0;
    			int riyaCount = 0;
    			int i = 0;
    			int j = inputs.length - 1;
     
    			while (i <= j) {
    					if (madhavTotal == riyaTotal * 2 && i == j){
    						madhavTotal = madhavTotal + Integer.parseInt(inputs[i]);
    						madhavCount++;
    						i++;
    					}else if (madhavTotal == riyaTotal * 2) {
    						riyaTotal = riyaTotal + Integer.parseInt(inputs[j]);
    						riyaCount++;
    						j--;
    						madhavTotal = madhavTotal + Integer.parseInt(inputs[i]);
    						madhavCount++;
    						i++;
    					} else if (madhavTotal < riyaTotal * 2) {
    						madhavTotal = madhavTotal + Integer.parseInt(inputs[i]);
    						madhavCount++;
    						i++;
    					} else if (madhavTotal > riyaTotal * 2) {
    						riyaTotal = riyaTotal + Integer.parseInt(inputs[j]);
    						riyaCount++;
    						j--;
    					}
    			}
    			System.out.println(madhavCount + " " + riyaCount);
    		}
    	}
    }
