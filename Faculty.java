import java.io.*;
import java.util.*;


//package mypack;

class Faculty {
  String username, password;
  int flag=0;
  
  public void login () throws FileNotFoundException, IOException{
        String uname,paswd;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter username : ");
        uname = s.nextLine();
        System.out.println("Enter password :");
        paswd = s.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader("DocFaculty.txt"))){
            String inpt = null ;
            while((inpt =br.readLine()) != null){
                String[] element;
                element = inpt.split(",");
                if(uname.equals(element[0]) && paswd.equals(element[1])){
                    flag=1;
                }  
            }

            if(flag == 1){
                System.out.println(" Faculty Login successful!!!!");
                System.out.println();
                System.out.println("Select Category");
                System.out.println("1.Do you want to add students? If yes press 1 and then y");
                System.out.println("2.Do you want to add new set of questions");
                Scanner s1 = new Scanner(System.in);
                int ca = s1.nextInt();
                if(ca == 1){
                    Scanner q = new Scanner(System.in);
                    String choice= q.nextLine();
                    while(choice.equals("y") || choice.equals("Y")){
                        addstudent();
                        System.out.println("Do you want to continue?");
                        choice= q.nextLine();
                    }
                }
                else if(ca==2){
                    clearTheFile();
                    Scanner p = new Scanner(System.in);
                    System.out.println("If yes press y");
                    String ch= p.nextLine();
                    int i=0;
                    System.out.println("Enter questions and options");
                    while(ch.equals("y") || ch.equals("Y")){
                        
                        i++;
                        if(i<6){
                            addques();
                        }
                        if(i==5){
                            System.out.println("Enter the correct options");
                            addans();
                        }
                        if(i==6){                          
                            System.out.println("Do you want to continue, if yes press y and enter the question?");
                            ch= p.nextLine();
                            i=0;
                        }
                        
                    }
                }
                else{
                    System.out.println("Wrong Choice");
                }
            }
            else{
                System.out.println("No such username");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
            
  }

    public void addstudent(){
        System.out.println();
        System.out.println("Enter Username and Password of student");
        Scanner a = new Scanner(System.in);
        String us = a.nextLine();
        String ps = a.nextLine();
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("Document0.txt", true));
            writer.println(us + "," + ps);
            writer.close();
           } 
        catch (Exception e) {
            System.out.println("Error");
        }
        //System.out.println("Do you want to continue?");
        //choice = a.nextLine().charAt(0);
        
    } 

    public void addques(){

        
        Scanner z = new Scanner(System.in);
        String q = z.nextLine();
        try{
            PrintWriter writer = new PrintWriter(new FileWriter("q.txt", true));
            writer.println(q);
            writer.close();
           } 
        catch (Exception e) {
            System.out.println("Error");
        }
        
        //System.out.println("Do you want to continue?");
        //choice = a.nextLine().charAt(0);
        
    } 
    public void addans(){

        
        Scanner z = new Scanner(System.in);
        String q = z.nextLine();
        try{
            PrintWriter writer2 = new PrintWriter(new FileWriter("a.txt", true));
            writer2.println(q);
            writer2.close();
           } 
        catch (Exception e) {
            System.out.println("Error");
        }
        
        //System.out.println("Do you want to continue?");
        //choice = a.nextLine().charAt(0);
        
    } 

    public void clearTheFile() {
        //FileWriter fwOb = new FileWriter("q.txt", false);
        try{
            PrintWriter p1 = new PrintWriter(new FileWriter("q.txt", false));
        p1.flush();
        p1.close();
        PrintWriter pw2 = new PrintWriter(new FileWriter("a.txt", false));
        pw2.flush();
        pw2.close();
        } 
        catch (Exception e) {
            System.out.println("Error");
        }
        //fwOb.close();
    }

}
