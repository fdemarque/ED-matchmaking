import java.util.Scanner;
import java.util.*;
import java.io.*;

public abstract class Utils{
    
    private static Scanner scan = new Scanner(System.in);

    public static void print(String mensagem){
       System.out.print(mensagem);
    }
    public static void println(String mensagem){
        System.out.println(mensagem);
    }
    public static int scanInt(){
        int valor = scan.nextInt();
        scan.nextLine();        
        return valor;
    }
    public static double scanDouble(){
        double valor = scan.nextDouble();
        //scan.nextLine();        
        return valor;

    }
    public static boolean scanBoolean(){
        boolean valor = scan.nextBoolean();
        //scan.nextLine();        
        return valor;
    }
    public static float scanFloat(){
        float valor = scan.nextFloat();
        //scan.nextLine();        
        return valor;
    }
    public static String scanLine(){
        String valor = scan.nextLine();
        //scan.nextLine();        
        return valor;
    }
}