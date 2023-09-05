/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.io.*;
import java.util.*;
import za.ac.tut.entities.*;

/**
 *
 * @author MNCEDISI
 */
public interface MessageInterface
{
    public EncryptMessage encryptedMessage(File file) throws IOException;
    
    public String decryptMessage(String encryptMsg , int [] count);
    
    public List<String> words(String decryptMsg);
    
    public double searchKeywords(List<String> words);
    
    public Map<String , Integer> determineWordsFrequence(List<String> words);
    
    public String classify(double searchWords);
    
    public void storeStatisticMessage(File file , Map<String , Integer> wordFre , double searchWords ,String classify);
}
