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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilolopez
 */
public class Client implements Runnable {

    String[] args;

    public Client(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        URL url;
        try {
            url = new URL(args[0]);
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                String inputLine = null;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
