/*
 * This program takes a log file named 'weblog.txt'
 * as input and displays some information about it.
 * Performed on NetBeans IDE, Windows OS
 * Performed by Abhinee A. Chavan
 * July 8, 2015
*/
package pk1;
import java.io.*;

/**
 *
 * @author Abhinee
 */
 
/*
* ReadLog class inputs a log file and displays some basic details about it.
*/
public class ReadLog {
     
     
    public static void main(String args[]){
         
        File file = new File("E:\\New stuff\\weblog.txt");
     
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
                
                int cnt1 = 0;
                int cnt2 = 0;
                int cnt3 = 0;
                int cnt4 = 0;
                int cnt5 = 0;
                
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
             
           
            while (dis.available() != 0)
            {
                                
                String s = dis.readLine();
                    
                if(s.contains("www.kinneryandrajan.com"))
                {
                cnt1++;
                }
                
                if(s.contains("www.twibuzz.com"))
                {
                cnt2++;
                }
                
                if(s.contains("www.recipewithme.com"))
                {
                cnt3++;
                }
                
                if(s.contains("GET"))
            
                {
                cnt4++;    
                }
                
                if(s.contains("POST"))
                {
                cnt5++;    
                }
              
            }
            /*
            * Displaying basic details about the file
            */
            System.out.println("Websites visited:");
            System.out.println("www.kinneryandrajan.com "+cnt1+" times");
            System.out.println("www.twibuzz.com "+cnt2+" times");
            System.out.println("www.recipewithme.com "+cnt3+" times\n");
            System.out.println("Get method used "+cnt4+" times");
            System.out.println("Post method used "+cnt5+" times");
            
        }
        catch (FileNotFoundException e){
                e.printStackTrace();
            }
        catch (IOException ee){
                ee.printStackTrace();
        }
        finally
                {
                    try{
                dis.close();
                bis.close();
                fis.close();  
                }
                
        catch(IOException e)
                {
                e.printStackTrace();
                }
                }
    }
 
}

/*OUTPUT
run:
Websites visited:
www.kinneryandrajan.com 844 times
www.twibuzz.com 1780 times
www.recipewithme.com 16 times

Get method used 2608 times
Post method used 158 times
BUILD SUCCESSFUL (total time: 0 seconds)

*/
