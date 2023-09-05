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
public class EncryptMessage 
{
    private String plainText;
    private int [] count;
    
    public EncryptMessage(String plainText) 
    {
        this.plainText = plainText;
        this.count = new int[7];
    }

    public EncryptMessage encryptMessage(String encryptMsg) 
    {  
        int ac = 0, bc = 0 , cc = 0 , wc = 0 , yc = 0 , xc = 0 , zc = 0;
        
        for (int i = 0; i < encryptMsg.length(); i+=3)
        {
            char letter = encryptMsg.charAt(i);
                
            switch(letter)
            {
                case 'a':
                    encryptMsg=encryptMsg.replace("a", "d");
                    ac++;
                break;

                case 'b':
                    encryptMsg=encryptMsg.replace("b", "e");
                    bc++;
                break;

                case 'c':
                    encryptMsg=encryptMsg.replace("c", "f");
                    cc++;
                break;
                    
                case 'x':
                    encryptMsg=encryptMsg.replace("x", "z");
                    xc++;
                break;

                case 'w':
                    encryptMsg=encryptMsg.replace("w", "a");
                    wc++;
                break;

                case 'y':
                    encryptMsg=encryptMsg.replace("y", "b");
                    yc++;
                break;

                case 'z':
                    encryptMsg=encryptMsg.replace("z", "c");
                    zc++;
                break;                             
            }            
        }
        
        count[0]=ac;count[1]=bc;count[2]=cc;
        count[3]=xc;count[4]=wc;count[5]=yc;
        count[6]=zc;
        
        this.plainText=encryptMsg;
        
        return new EncryptMessage(plainText);
    }

    public String getPlainText() {
        return plainText;
    }

    public int[] getCount() {
        return count;
    }
}
