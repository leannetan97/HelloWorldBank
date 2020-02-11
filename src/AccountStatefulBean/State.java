/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountStatefulBean;

/**
 *
 * @author jee, jf , yan
 */
public interface State {

    public String getStateName();

    public String withdraw(double amount);

    public String deposit(double amount);
}
