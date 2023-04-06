import java.util.*;
import java.io.*;

public class abstract Utils{
    
    Scanner scan = new Scanner(System.in);

    public static print(String mensagem){
        System.out.print(mensagem);
    }
    public static scanInt(){
        return scan.nextInt();
    }
    public static scanDouble(){
        return scan.nextDouble();
    }
    public static scanBoolean(){
        return scan.nextBoolean();
    }
    public static scanFloat(){
        return scan.nextFloat();
    }
    public static scanLine(){
        return scan.nextLine();
    }
}