public class Program
{
    public static void main(String[] args) {
        // change the following string to encrypt a specific text
        String text = "To be or not to be, that is the question";
        
        //change the offset depending on the text 
        //offset should be between 1-26
        int offset= 15;              
        
        text = decrypt(text, offset);
        System.out.println("crypted text: \n" + text);
        text = decrypt(text, offset*(-1));
        System.out.println("decrypted text: \n" + text);
    }
    
    public static String decrypt(String n, int offset){
        String erg = "";       
        //turn all letters to lower case to get ASCII codes between 97-122
        n = n.toLowerCase();       
        for (int i = 0; i < n.length();i++){            
            //if the letter is a char, retrieve the ascii code, add the offset and convert back to char
            if (Character.isLetter(n.charAt(i))){
                int x = (int) n.charAt(i);
                x += offset;
                if (x > 122){
                    x -= 26;
                }
                erg += (char) x;
            } else{
                erg += n.charAt(i);
            }
        }
        return erg;
    }
    
    public static String encrypt(String n, int offset){
        String erg = "";
        n = n.toLowerCase();
        for (int i = 0; i < n.length();i++){
            if (Character.isLetter(n.charAt(i))){
                int x = (int) n.charAt(i);
                x -= offset;
                if (x < 97){
                    x += 26;
                }
                erg += (char) x;
            } else{
                erg += n.charAt(i);
            }
        }
        return erg;
    }
}
