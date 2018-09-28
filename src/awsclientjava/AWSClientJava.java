/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awsclientjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author camilolopez
 */
public class AWSClientJava {

    public static final Integer threads = 10;
    public static final Integer requests = 10;
    public static Integer numRequests = 1;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        ExecutorService exe = Executors.newFixedThreadPool(threads);
        
        while (numRequests <= requests) {
            exe.execute(new Client(args));
            numRequests++;
        }
        exe.shutdown();
    }

}
