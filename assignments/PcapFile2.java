/*
* The program displays basic details of the packets from a pcap file.
* Performed in NetBeans IDE, Windows OS
* Performed by Abhinee A. Chavan
* July 8, 2015
*/
package pk1;

//Included jnetpcap jar file packages
import java.util.Date;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

/**
 *
 * @author Abhinee
 */

/*
* PcapFile class inputs a pcap file, extracts basic details of first 100 packets and displays it. 
*/
public class PcapFile2 {
    
        public static void main(String[] args) {
		
                final String file = "E:\\New stuff\\bgp.pcap\\bgp.pcap";
                
		System.out.printf("Opening the pcap file for reading: %s%n", file);
                
                final StringBuilder errbuf = new StringBuilder();
		
                /*
                * Opening the pcap file.
                */
		Pcap pcap = Pcap.openOffline(file, errbuf);

                /*
                * if there is any error in opening the file, errbuf will display the
                * appropriate message.
                */
		if (pcap == null) {
                        
                        System.err.printf("Error !!! " + errbuf.toString());
			return;
		}
                else
                    
                    
                pcap.toString();
		
                /*
                * PcapPacketHandler ia an anonymous class to handle packets.
                */
                
                PcapPacketHandler<String> jpacketHandler = new PcapPacketHandler<String>() {

                /*
                * nextPacket method fetches paacket one by one and diaplys its details.    
                */    
                @Override
		public void nextPacket(PcapPacket packet, String user) {

			System.out.printf("Frame No.: %-4d \t Received Time: %s \t Captured Lenght: %-4d  \t Structname: %s \t state: %s \t Header Count: %-4d \t Total Size: %-4d  %s \n", 
			            packet.getFrameNumber(),
                                    new Date(packet.getCaptureHeader().timestampInMillis()), 
				    packet.getCaptureHeader().caplen(), 
				    packet.getCaptureHeader().getStructName(),
                                    packet.getState(),
                                    packet.getHeaderCount(),
                                    packet.getTotalSize(),
                                    user 
				    );
                                                            
                        }
		};

		try {
                    
                    /*
                    * Calling the loop method
                    */
		    pcap.loop(100, jpacketHandler,".....");
		}
                
                finally {
		
                /*
                * Closing the pcap handler.
                */
		   pcap.close();
		}
	}  
}


/*
OUTPUT:
run:
Opening the pcap file for reading: E:\New stuff\bgp.pcap\bgp.pcap
Frame No.: 1    	 Received Time: Thu Mar 30 10:26:48 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 2    	 Received Time: Thu Mar 30 10:26:48 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 3    	 Received Time: Thu Mar 30 10:26:48 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 4    	 Received Time: Thu Mar 30 10:26:48 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 5    	 Received Time: Thu Mar 30 10:26:56 IST 2000 	 Captured Lenght: 74    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 330   ..... 
Frame No.: 6    	 Received Time: Thu Mar 30 10:26:56 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 7    	 Received Time: Thu Mar 30 10:26:56 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 8    	 Received Time: Thu Mar 30 10:26:56 IST 2000 	 Captured Lenght: 83    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 379   ..... 
Frame No.: 9    	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 10   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 83    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 379   ..... 
Frame No.: 11   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 12   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 73    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 369   ..... 
Frame No.: 13   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 73    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 369   ..... 
Frame No.: 14   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 15   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 16   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 270   	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 566   ..... 
Frame No.: 17   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 118   	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 414   ..... 
Frame No.: 18   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
Frame No.: 19   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 73    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 4    	 Total Size: 369   ..... 
Frame No.: 20   	 Received Time: Thu Mar 30 10:26:57 IST 2000 	 Captured Lenght: 60    	 Structname: pcap_pkthdr 	 state: struct packet_state_t 	 Header Count: 3    	 Total Size: 316   ..... 
BUILD SUCCESSFUL (total time: 1 second)

*/
