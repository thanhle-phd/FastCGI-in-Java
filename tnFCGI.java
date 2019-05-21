import java.io.*;
import fastcgi.FCGIInterface;

public class tnFCGI {	
    public static void main (String args[]) {
        int port = 9000;
	// list for port indicated on command line
        for (int i=0; i<args.length; i++) {
            if (args[i].equals("-p")) {
                try { port = Integer.parseInt(args[i+1]); }
                catch (Exception ex) { port = 9000; }
            }
        }
        int count = 0;
        System.setProperty("FCGI_PORT", Integer.toString(port));
        System.out.println("Fast CGI server started at 127.0.0.1:" + Integer.toString(port));
        FCGIInterface fcgiinterface = new FCGIInterface();
        while( fcgiinterface.FCGIaccept() >= 0 ) {
            count ++;
            System.out.println("Content-type: text/html\n\n");
            System.out.println("<html>");
            System.out.println("<head><title>FastCGI-Hello Java stdio</title></head>");
            System.out.println("<body>");
            System.out.println("<H3>FastCGI-HelloJava stdio</H3>");
            System.out.println("request number " + count + " running on host " + System.getProperty("SERVER_NAME"));
            System.out.println("<H3>Environment Variables:</H3>");
	    // list request parameters sent from web server (NGINX for example)
            fcgiinterface.request.params.forEach((k, v) -> System.out.println( "  - "+k + ":" + v));
            
            System.out.println("</body>");
            System.out.println("</html>"); 
        }
    }
}
