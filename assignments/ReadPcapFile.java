/*
* The program displays header details of a pcap file.
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
public class ReadPcapFile {

    
    public static void main(String[] args) {  
  
        final String fname = "E:\\New stuff\\tcp-ecn-sample.pcap";  

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
Opening file: E:\New stuff\tcp-ecn-sample.pcap

Header details of the packets:


frame no: 1
tcp dest port no: 80
tcp src port no: 46557
tcp ack: 0


frame no: 2
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf604f


frame no: 3
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86a1b


frame no: 4
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86a1b
http header length: 161
http header: 161
http name: Http


frame no: 5
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0
http header length: 256
http header: 256
http name: Http


frame no: 6
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86b1b


frame no: 7
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 8
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86c34


frame no: 9
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 10
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86c34


frame no: 11
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c86e34


frame no: 12
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 13
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 14
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8704c


frame no: 15
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8704c


frame no: 16
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87264


frame no: 17
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87264


frame no: 18
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 19
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87466


frame no: 20
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 21
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8767e


frame no: 22
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8767e


frame no: 23
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 24
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87896


frame no: 25
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 26
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87896


frame no: 27
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87aae


frame no: 28
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87aae


frame no: 29
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 30
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87cc6


frame no: 31
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87cc6


frame no: 32
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 33
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 34
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c87ede


frame no: 35
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c880f6


frame no: 36
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c880f6


frame no: 37
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c880f6


frame no: 38
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 39
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 40
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8830e


frame no: 41
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88526


frame no: 42
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88526


frame no: 43
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88526


frame no: 44
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 45
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8873e


frame no: 46
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8873e


frame no: 47
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 48
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 49
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88956


frame no: 50
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88b6e


frame no: 51
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88b6e


frame no: 52
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88b6e


frame no: 53
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 54
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88d86


frame no: 55
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88d86


frame no: 56
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 57
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88f9e


frame no: 58
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c88f9e


frame no: 59
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 60
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c891b6


frame no: 61
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 62
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c891b6


frame no: 63
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c893ce


frame no: 64
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c893ce


frame no: 65
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 66
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c895e6


frame no: 67
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c895e6


frame no: 68
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 69
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 70
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c897fe


frame no: 71
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89a16


frame no: 72
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89a16


frame no: 73
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89a16


frame no: 74
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 75
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89c2e


frame no: 76
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89c2e


frame no: 77
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 78
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 79
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c89e46


frame no: 80
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a05e


frame no: 81
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a05e


frame no: 82
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a05e


frame no: 83
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 84
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 85
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a276


frame no: 86
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a48e


frame no: 87
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a48e


frame no: 88
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a48e


frame no: 89
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 90
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a6a6


frame no: 91
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 92
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a6a6


frame no: 93
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a8be


frame no: 94
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8a8be


frame no: 95
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 96
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8aad6


frame no: 97
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8aad6


frame no: 98
tcp dest port no: 46557
tcp src port no: 80
tcp ack: aaf60f0


frame no: 99
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8acee


frame no: 100
tcp dest port no: 80
tcp src port no: 46557
tcp ack: a6c8acee
BUILD SUCCESSFUL (total time: 1 second)

*/
