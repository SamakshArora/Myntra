package Myntra.Myntra;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	String a = "Samaksh";	
    	String	b="";
    	for (int i = 0; i < a.length(); i++) {
    		
			b= b+ a.charAt(i);
			b= b+ a;
		}
    	
    	System.out.println(b);
    }
    
}
