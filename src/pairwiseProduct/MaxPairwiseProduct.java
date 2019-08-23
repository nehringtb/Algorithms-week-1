package pairwiseProduct;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
	
    static long getMaxPairwiseProduct(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((long)numbers[i] * (long)numbers[j] > result) {
                    result = (long)numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }
    
    static long getMaxPairwiseProductFast(int[] numbers) {
        int n = numbers.length;
        long biggest=0;
        long secondBiggest=0;
        int bI=0;
        for (int i = 0; i < n; ++i) {
           if(numbers[i]>biggest){
        	   bI=i;
        	   secondBiggest=biggest;
        	   biggest=numbers[i];
           }

           if(numbers[i]>secondBiggest && bI!=i){
        	   secondBiggest=numbers[i];
           }
           
           
        }
        return biggest*secondBiggest;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
         int n = scanner.nextInt();
        //while(true){
        //int n=(int)(Math.random()*5);
        //System.out.println("N: "+ n);
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        //long resOne;
        long resTwo;
        //System.out.println(getMaxPairwiseProductFast(numbers));
        //resOne=getMaxPairwiseProduct(numbers);
        resTwo=getMaxPairwiseProductFast(numbers);
        System.out.println(resTwo);
        //System.out.println("Result 1: "+ resOne +" Result 2: " + resTwo);
        
        /*if(resOne!=resTwo){
        	System.out.println("Results do not mach!!!");
        	return;
        }*/
        
        //}
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        	//long num=(long)(Math.random()*100);
        	//System.out.println(num);
        	//return  num;
        }
    }

}