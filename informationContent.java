public class Program
{
    public static void main(String[] args) {
        //change text to get information
        String text = "to be or not to be, that is the question";
        double []x = informationcontent(text);
        for (int i=0;i<26;i++){
            char h = (char)(i+97);
            System.out.println(h + ": " + x[i]);
        }
    }
    
    public static double[] informationcontent(String t){
        double  w[] = new double [26];
        double [] inf = new double[26];
        for(int i=0; i < 26; i++){
            w[i] = 0.0;
            inf[i] = 0.0;
        }
        w = propability(w,t);
        
        for (int i=0; i<26; i++){
            if (w[i] != 0){
                inf[i] = Math.log(1/w[i])/ Math.log(2);
            }
        }
        
        return inf;
    }
    
    public static double []propability(double[]w, String t){
        for (int i = 0; i < t.length();i++){
            if (Character.isLetter(t.charAt(i))){
                int x = (int)t.charAt(i);
                w[x-97] = (double) w[x-97]+1.0;
            }
        }
        for (int i=0;i<26;i++){
            if (w[i]!=0){
                w[i] = w[i] / (double)t.length();
            }
            
        }
        return w;
    }
}
