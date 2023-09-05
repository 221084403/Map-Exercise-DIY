/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entities;

/**
 *
 * @author MNCEDISI
 */
public class DecryptMessage 
{
    private String encryptMsg;
    private int [] count;

    public DecryptMessage(String encryptMsg , int [] count)
    {
        this.encryptMsg = encryptMsg;
        this.count = count;
    }
    
    public DecryptMessage decryptMessage(String encryptMsg ,int [] count )
    {
        if(count[0]>0)
            encryptMsg = encryptMsg.replace("d", "a");
        
        if(count[1]>0)
            encryptMsg = encryptMsg.replace("e", "b");
        
        if(count[2]>0)
            encryptMsg = encryptMsg.replace("f", "c");
        
        if(count[3]>0)
            encryptMsg = encryptMsg.replace("z", "x");
        
        if(count[4]>0)
            encryptMsg = encryptMsg.replace("a", "w");
           
        if(count[5]>0)
            encryptMsg = encryptMsg.replace("b", "y");
        
        if(count[6]>0)
            encryptMsg = encryptMsg.replace("c", "z");
                     
        return new DecryptMessage(encryptMsg , count);
    }

    public String getEncryptMsg()
    {
        return encryptMsg;
    }
}
