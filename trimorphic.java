import java.util.Scanner ;

public class Program
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        if (((x*x*x)%100)==x){System.out.println("trimorphic number");} 
        else{
            System.out.println("no trimorphic number");
        }
    }
}
