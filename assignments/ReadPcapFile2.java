/*
* The program displays header details of a pcap file named 'bgp.pcap'.
* Performed in NetBeans IDE, Windows OS
* Performed by Abhinee A. Chavan
* July 8, 2015
*/
package pk1;

//Included jnetpcap jar file packages
import org.jnetpcap.Pcap;    
import org.jnetpcap.packet.JPacket;  
import org.jnetpcap.packet.JPacketHandler;  
import org.jnetpcap.protocol.tcpip.Http;  
import org.jnetpcap.protocol.tcpip.Tcp; 
/**
 *
 * @author Abhinee
 */

/*
* ReadPcapFile class inputs a pcap file, checks for 
* tcp and http and displays basic details about the header of first 100 packets.
*/
public class ReadPcapFile2 {

    
    public static void main(String[] args) {  
  
   
        final String fname = "E:\\New stuff\\bgp.pcap\\bgp.pcap"; 
        System.out.println("Opening file: "+fname+"\n");
        
        final StringBuilder errbuf = new StringBuilder();  
  
        final Pcap pcap = Pcap.openOffline(fname, errbuf);  
        
        /*
        * If there is error in finding the file
        * appropriate error message will be displayed.
        */
        if (pcap == null) {  
        
            System.err.println(errbuf);   
            return;  
        }  
        
        System.out.println("Header details of the packets:");
       
        /*
        * loop method takes each and every packet, extracts its details and displays it.
        */
        pcap.loop(100, new JPacketHandler<StringBuilder>() {  
        
        final Http http = new Http();  
          
        final Tcp tcp = new Tcp();  
    
        @Override
        public void nextPacket(JPacket packet, StringBuilder errbuf) {  
  
            
            System.out.println("\n");        
            System.out.printf("frame no: %d%n", packet.getFrameNumber());  
            
            /*
            * TCP header details
            */    
            if (packet.hasHeader(Tcp.ID)) {  
                                
                   packet.getHeader(tcp);  
                  
                   System.out.printf("tcp dest port no: %d%n", tcp.destination());  
                   System.out.printf("tcp src port no: %d%n", tcp.source());  
                   System.out.printf("tcp ack: %x%n", tcp.ack());    
  
                }  
            
            /*
            * HTTP header details
            */    
            if (packet.hasHeader(http)) {  
                  
                   System.out.printf("http header length: %d%n", http.getHeaderLength());
                   System.out.printf("http header: %d%n", http.getLength());
                   System.out.printf("http name: %s%n", http.getName());
                    
                }  
                
            }  
  
        }, errbuf);
       
        
        /*
        * Closing the pcap handler.
        */
        pcap.close();  
  
    }  
}      

/*
OUTPUT OF THE PROGRAM:
run:
Opening file: E:\New stuff\bgp.pcap\bgp.pcap

Header details of the packets:


frame no: 1
tcp dest port no: 2123
tcp src port no: 179
tcp ack: d20bb756


frame no: 2
tcp dest port no: 179
tcp src port no: 2123
tcp ack: 7553d58d


frame no: 3
tcp dest port no: 179
tcp src port no: 2123
tcp ack: 7553d58d


frame no: 4
tcp dest port no: 2123
tcp src port no: 179
tcp ack: d20bb757


frame no: 5
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 0


frame no: 6
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339d62


frame no: 7
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e046


frame no: 8
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e046


frame no: 9
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339d7f


frame no: 10
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339d7f


frame no: 11
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e063


frame no: 12
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e063


frame no: 13
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339d7f


frame no: 14
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e076


frame no: 15
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339d92


frame no: 16
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e076


frame no: 17
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339e6a


frame no: 18
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e0b6


frame no: 19
tcp dest port no: 2124
tcp src port no: 179
tcp ack: d6339e6a


frame no: 20
tcp dest port no: 179
tcp src port no: 2124
tcp ack: 7a40e0c9
BUILD SUCCESSFUL (total time: 1 second)

*/
