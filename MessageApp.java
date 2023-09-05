/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp;

import java.io.*;
import java.util.*;
import za.ac.tut.entities.*;
import za.ac.tut.messagemanager.*;

/**
 *
 * @author MNCEDISI
 */
public class MessageApp 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        try
        {
            MessageManager mm = new MessageManager();
            
            EncryptMessage encryptMessage = mm.encryptedMessage(new File("C:\\Users\\MNCEDISI\\Desktop\\Message.txt"));
            
            String encryptMsg = encryptMessage.getPlainText();
            int count [] = encryptMessage.getCount();
            
            String dencryptMsg = mm.decryptMessage(encryptMsg , count);
            
            List<String> words = mm.words(dencryptMsg);
            
            double searchWords = mm.searchKeywords(words);
            
            String output = "Encrypt message  :"+encryptMsg+"\n"+
                            "Dencrypt message :"+dencryptMsg+"\n"+
                            "A message comprises is "+searchWords+"%\n\n"+
                            "Frequency of keywords occurrence\n";
            
            String outcome = "";
            
            Map<String ,Integer> wordFre = mm.determineWordsFrequence(words);
                
            for (Map.Entry<String, Integer> display : wordFre.entrySet()) 
                outcome+=display.getKey()+" :"+display.getValue()+"\n";
            
            outcome+="The message is :"+mm.classify(searchWords)+"\n";
            
            String msg = output.concat(outcome);
            
            System.out.println(msg);
            
            File file = new File("C:\\Users\\MNCEDISI\\Desktop\\NewMessage.txt");
            mm.storeStatisticMessage(file, wordFre, searchWords, mm.classify(searchWords));
            
        } 
        catch (IOException ex) 
        {
            System.err.println("Something went wrong\n"+ex.getMessage());
        }
        
    } 
}
