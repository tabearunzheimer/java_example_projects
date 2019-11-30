public class Program
{
    public static void main(String[] args) {
        // change text to encrypt a specific string
        String text = "To be or not to be, that is the question";
        int offset= 15;
        text = decrypt(text, offset);
        System.out.println("crypted text: \n" + text);
        text = encrypt(text, offset);
        System.out.println("decrypted text: \n" + text);
    }
    
    public static String decrypt(String n, int offset){
        String erg = "";
        n = n.toLowerCase();
        for (int i = 0; i < n.length();i++){
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
