import java.util.ArrayList;

public interface account {
    void deposit(double amt);
    void withdraw(double amt);
    double check_bal();
}
class savings_acc implements account{
    double bal;
    String acc_holder_name;
    long contact_no;
    String acc_type;

    savings_acc(){}

    public savings_acc(String acc_holder_name,double bal,long contact_no,String type) {
        this.acc_holder_name = acc_holder_name;
        this.bal=bal;
        this.contact_no=contact_no;
        this.acc_type=type;
    }

    @Override
    public void deposit(double amt) {
        this.bal=this.bal+amt;
        System.out.println(this.acc_holder_name+"balance is"+this.bal);
    }

    @Override
    public void withdraw(double amt) {
        this.bal=this.bal-amt;
        System.out.println(this.acc_holder_name+"balance is"+this.bal);
    }

    @Override
    public double check_bal() {
        return this.bal;
    }

    public void details_0f_acc(){
        System.out.println("name of acc holder: "+this.acc_holder_name);
        System.out.println("acc balance of acc holder: "+this.bal);
        System.out.println("contact no of acc holder: "+this.contact_no);
        System.out.println("account type: "+this.acc_type);
    }
}
class current_acc implements account{
    double bal;
    String acc_holder_name;
    long contact_no;
    String acc_type;

    public current_acc() {
    }

    public current_acc(String acc_holder_name,double bal, long contact_no, String acc_type) {
        this.acc_holder_name = acc_holder_name;
        this.bal=bal;
        this.contact_no=contact_no;
        this.acc_type=acc_type;
    }
    @Override
    public void deposit(double amt) {
        this.bal=this.bal+amt;
        System.out.println(this.acc_holder_name+"balance is"+this.bal);
    }

    @Override
    public void withdraw(double amt) {
        this.bal=this.bal-amt;
        System.out.println(this.acc_holder_name+"balance is"+this.bal);
    }

    @Override
    public double check_bal() {
        return this.bal;
    }

    public void details_0f_acc(){
        System.out.println("name of acc holder: "+this.acc_holder_name);
        System.out.println("acc balance of acc holder: "+this.bal);
        System.out.println("contact no of acc holder: "+this.contact_no);
        System.out.println("account type: "+this.acc_type);
        System.out.println("***********************************");
    }

}
