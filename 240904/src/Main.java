import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] a = new char[str.length()];

        for (int i = 0; i < a.length; i++){
            a[i] = str.charAt(i);
        }
        System.out.println(Arrays.toString(a));
    }
}