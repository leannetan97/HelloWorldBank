/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountStatefulBean;
import javax.ejb.Remote;
/**
 *
 * @jeejfyan
 */

@Remote
public interface Account {

    public String deposit(double amount);

    public String withdraw(double amount);

    public double getBalance();
}
