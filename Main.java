
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
      bank b=new bank();
      boolean flag=true;

      do {
          System.out.println("*******welcome********");
          System.out.println("select the input");
          System.out.println("1.create accont\n2.search account\n3.display the total account\n4.vip account\n5.access an account\n6.exit the page");
          int input=sc.nextInt();
          switch (input){
              case 1: {//create acc
                  boolean create_acc_loop = true;
                  do {
                      System.out.println("select which type of account");
                      System.out.println("1.savings account\n2.current account");
                      int acc_type_in = sc.nextInt();
                      switch (acc_type_in) {
                          case 1: {//sav acc
                              System.out.println("enter the account holder name: ");
                              String new_name=sc.next();
                              System.out.println("enter the initial account balance: ");
                              double new_bal=sc.nextDouble();
                              System.out.println("enter the account holder contact number: ");
                              long new_cont_no=sc.nextLong();
                              b.create_acc(new_name,new_bal,new_cont_no,"savings");
                              System.out.println("account created successfully");
                              create_acc_loop=false;
                              break;
                          }
                          case 2: {//cuu acc
                              System.out.println("enter the account holder name: ");
                              String new_name=sc.next();
                              System.out.println("enter the initial account balance: ");
                              double new_bal=sc.nextDouble();
                              System.out.println("enter the account holder contact number: ");
                              long new_cont_no=sc.nextLong();
                              b.create_acc(new_name,new_bal,new_cont_no,"current");
                              System.out.println("account created successfully");
                              create_acc_loop=false;
                              break;
                          }
                      }
                  } while (create_acc_loop);
                  break;
              }

              case 2:{//search account
                  boolean search_loop=true;
                  do {
                      System.out.println("1.enter the account holder name");
                      String new_search_name=sc.next();
                      b.search_acc(b.accounts,new_search_name);
                      System.out.println("1.continue the search\n2.exit the search");
                      int exit=sc.nextInt();
                      if (exit==2){
                          search_loop=false;
                      }
                  }while (search_loop);
                  break;}

              case 3:{//display the no of acc
                 System.out.println("total no of account is: "+b.total_no_of_acc(b.accounts));
                  break;}

              case 4:{//vip acc
                  b.vip_acc(b.accounts);
                  break;}

              case 5:{//access an account
                  System.out.println("**********account holders**********");
                  for (account acc: b.accounts){
                      if(b.find_type(acc)){
                         savings_acc sav=(savings_acc) acc;
                         System.out.println(sav.acc_holder_name);
                      } else{
                          current_acc cur=(current_acc) acc;
                          System.out.println(cur.acc_holder_name);
                      }
                  }
                  System.out.println("enter the name to access the acc");
                  String acc_account=sc.next();
                  b.get_acc(acc_account);
                  System.out.print("select the option");
                  int acc_in=sc.nextInt();
                  boolean acc_loop=true;
                  do {
                     switch (acc_in){
                         case 1:{
                             System.out.println("enter the amount");
                             double dep_amt=sc.nextDouble();
                             b.get_option(1,b.accounts,dep_amt,acc_account);
                             acc_loop=false;
                             break;

                         }
                         case 2:{
                             System.out.println("enter the amount");
                             double wit_amt=sc.nextDouble();
                             b.get_option(2,b.accounts,wit_amt,acc_account);
                             acc_loop=false;
                             break;
                         }
                         case 3:{
                             b.get_option(3,b.accounts,0,acc_account);
                             acc_loop=false;
                             break;
                         }
                         case 4:{
                             b.get_option(4,b.accounts,0,acc_account);
                             acc_loop=false;
                             break;
                         }
                         case 5:{
                             System.out.println("exiting from access page");
                             acc_loop=false;
                             break;}
                     }

                  }while (acc_loop);

                  break;}

              case 6:{//exiting the main page
                  System.out.println("***********exiting*******");
                  flag=false;
                  break;}

              default:{//invaild input
                  System.out.println("***********invalid input********");
                  break;}
          }
      }while (flag);
    }
}