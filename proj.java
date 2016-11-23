import java.io.*;
import java.util.*;

     


class proj{
  public static void main(String[] args) throws FileNotFoundException,IOException{
        System.out.println();
        System.out.println("                 ---Welcome to the Online Test---");
        System.out.println();
        System.out.println("Tell who you are");
        System.out.println("1.Student");
        System.out.println("2.Faculty");
        Scanner s = new Scanner(System.in);
        int ca = s.nextInt();
        if(ca == 1){
            Student st = new Student();
            st.login();
          }
        else{
            Faculty f = new Faculty();
            f.login();   
        }    
  }
}
 
