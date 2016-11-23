import java.io.*;
import java.util.*;


//package package2;
//import package1.Faculty;


class Student {  
  String username, password;
    int flag=0;



    public void login () throws FileNotFoundException, IOException{
        String uname,paswd;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username : ");
        uname = s.nextLine();
        System.out.println("Enter password :");
        paswd = s.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader("Document.txt"))){
          String inpt = null ;
          while((inpt =br.readLine()) != null){
            String[] element;
            element = inpt.split(",");
            if(uname.equals(element[0]) && paswd.equals(element[1])){
                    flag=1;
            }
                
          }


          if(flag == 1){
            System.out.println("Login successful!!!!!!");
            System.out.println();
            test();
          }
          else{
            System.out.println("No such username");
          }
        }catch (IOException e) {
            e.printStackTrace();
        }
            
    }

    

  public void test() throws FileNotFoundException,IOException{            
  new Reminder(100);
        System.out.println();
        System.out.println("Your time starts now!!");
        System.out.println();
        int marks=0;
        BufferedReader br1 = new BufferedReader(new FileReader("a.txt"));

    try (BufferedReader br = new BufferedReader(new FileReader("q.txt")))
    {

      String sCurrentLine;
      Scanner reader = new Scanner(System.in); 
      Scanner s = new Scanner(System.in); 
      
      int i=0;
      
      while ((sCurrentLine = br.readLine()) != null ) {

        
        System.out.println(sCurrentLine);
        i++;
        if(i==5){
          String n =s.nextLine();
          String ans = br1.readLine();
          if(n.equals(ans)){
                System.out.println("The correct answer");
                System.out.println();
                  marks=marks+1;
              }
              
          else{
                System.out.println("The wrong answer");
                System.out.println();
          }
          i=0;
        }
        

      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("Score: " + marks);
    System.exit(0);
  }
}