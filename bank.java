import java.util.ArrayList;
import java.util.Arrays;

public class bank {
    static long ifsc = 0001;
    static String bank_name = "sbi";
    ArrayList<account> accounts = new ArrayList<>(5);

    public bank() {
    }

    public void create_acc(String acc_holder_name, double bal, long contact_no, String acc_type) {
        if (acc_type.equals("savings")) {
            account a1 = new savings_acc(acc_holder_name, bal, contact_no, acc_type);
            accounts.add(a1);
        } else {
            account a1 = new current_acc(acc_holder_name, bal, contact_no, acc_type);
            accounts.add(a1);
        }

    }

    public void search_acc(ArrayList<account> accounts, String sname) {
        for (account acc : accounts) {
            if (acc instanceof savings_acc) {
                savings_acc sav = (savings_acc) acc;
                if (sname.equals(sav.acc_holder_name)) {
                    sav.details_0f_acc();
                    break;
                }
            } else if (acc instanceof current_acc) {
                current_acc curr = (current_acc) acc;
                if (sname.equals(curr.acc_holder_name)) {
                    curr.details_0f_acc();
                    break;
                }
            }
        }
    }

    public int total_no_of_acc(ArrayList<account> accounts) {
        return accounts.size();
    }

    public void vip_acc(ArrayList<account> acc) {
        for (account single_acc : acc) {
            if (single_acc.check_bal() > 20000) {
                if (find_type(single_acc)) {
                    savings_acc sav = (savings_acc) single_acc;
                    sav.details_0f_acc();
                } else {
                    current_acc curr = (current_acc) single_acc;
                    curr.details_0f_acc();
                }
            }
        }
    }

    public boolean find_type(account acc) {
        if (acc instanceof savings_acc) {
            return true;
        } else if (acc instanceof current_acc) {
            return false;
        }
        return false;
    }

    public void get_acc(String sname) {
        for (account acc : accounts) {
            if (acc instanceof savings_acc) {
                savings_acc sav = (savings_acc) acc;
                if (sname.equals(sav.acc_holder_name)) {
                    System.out.println("1." + sav.acc_holder_name + "-deposit");
                    System.out.println("2." + sav.acc_holder_name + "-withdraw");
                    System.out.println("3.check balance of " + sav.acc_holder_name + " account");
                    System.out.println("4.details of " + sav.acc_holder_name + " account");
                }
            } else if (acc instanceof current_acc) {
                current_acc curr = (current_acc) acc;
                if (sname.equals(curr.acc_holder_name)) {
                    System.out.println("1." + curr.acc_holder_name + "-deposit");
                    System.out.println("2." + curr.acc_holder_name + "-withdraw");
                    System.out.println("3.check balance of " + curr.acc_holder_name + " account");
                    System.out.println("4.details of " + curr.acc_holder_name + " account");
                }
            }
        }
    }

    public void get_option(int in, ArrayList<account> accounts,double amt,String sname) {
        for (account acc : accounts) {
            if (acc instanceof savings_acc) {
                savings_acc sav = (savings_acc) acc;
                if (in==1) {
                    sav.deposit(amt);
                    System.out.println(amt+"deposited");
                    break;
                }
                else if (in==2){
                    sav.withdraw(amt);
                    System.out.println(amt+"withdraw");
                    break;
                }
                else if (in==3 && sname.equals(sav.acc_holder_name)){
                    System.out.println(sav.check_bal());
                    break;
                }
                else if (in==4 && sname.equals(sav.acc_holder_name) ){
                    sav.details_0f_acc();
                    break;
                }
            }
            else if (acc instanceof current_acc){
                current_acc curr = (current_acc) acc;
                if (in==1) {
                    System.out.println(amt+" deposited");
                    curr.deposit(amt);
                    break;
                }
                else if (in==2){
                    System.out.println(amt+" withdraw");
                    curr.withdraw(amt);
                    break;
                }
                else if (in==3 && sname.equals(curr.acc_holder_name)){
                   System.out.println(curr.check_bal());
                    break;
                }
                else if (in==4 && sname.equals(curr.acc_holder_name)){
                    curr.details_0f_acc();
                    break;
                }
            }
        }
    }
}