/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.messagemanager;

import java.io.*;
import java.text.*;
import java.util.*;
import za.ac.tut.bl.*;
import za.ac.tut.entities.*;

/**
 *
 * @author MNCEDISI
 */
public class MessageManager implements MessageInterface
{
    public MessageManager() { }

    @Override
    public EncryptMessage encryptedMessage(File file)throws IOException
    {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        String outcome = "";
        
        while(line!=null)
        {
            outcome+=line;
            line = br.readLine();
        }

        EncryptMessage encryptMessage =  new EncryptMessage(outcome);
        encryptMessage.encryptMessage(outcome);
        
        return encryptMessage;
    }

    @Override
    public String decryptMessage(String encryptMsg ,int [] count) 
    {
        DecryptMessage dm = new DecryptMessage(encryptMsg , count);
        
        return dm.decryptMessage(encryptMsg , count).getEncryptMsg();
    }

    @Override
    public List<String> words(String decryptMsg) 
    {
        String data [] = decryptMsg.split(" ");
        
        List<String> words = new ArrayList<>();
        
        for (String display : data)
            words.add(display);
        
        return words;
    }

    @Override
    public double searchKeywords(List<String> words) 
    {
        DecimalFormat dec = new DecimalFormat("#.00");
        final double keyword = 5.0;
        int count = 0;
        
        for (String display : words) 
        {
            switch(display)
            {
                case "burn": count++ ;break;
                case "protest": count++ ;break;
                case "ziyakhala": count++ ;break;
                case "president": count++ ;break;
                case "state": count++ ;break;
            }
        }
        
        return Double.parseDouble(dec.format((count/keyword)*100));
        
    }

    @Override
    public Map<String, Integer> determineWordsFrequence(List<String> words) 
    {
        Map<String , Integer> wordFre = new HashMap<>();
        
        for (String display : words) 
        {
            Integer count = words.indexOf(display)+1;
            wordFre.put(display, count);
        }
        
        return wordFre;
    }

    @Override
    public String classify(double searchWords) 
    {
        String outcome = "Dangerous";
        
        if(searchWords<40)
            outcome="Normal";
        
        return outcome;
    }

    @Override
    public void storeStatisticMessage(File file, Map<String, Integer> wordFre, double searchWords, String classify) 
    {      
        try
        {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String output = "";
            
            for (Map.Entry<String, Integer> display : wordFre.entrySet())
                output+=display.getKey()+" :"+display.getValue()+"\n";
            
            String outcome = "\nA message comprises of "+searchWords+"%\n"+
                             "The message is "+classify+"\n";
            
            String msg = outcome.concat(output);
            
            bw.write(msg);
            
            bw.close();
            
        } 
        catch (IOException ex) 
        {
            System.err.println("Something went wrong\n"+ex.getMessage());
        }
    }   
}
