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
public class LockState implements State {

    AccountBean account;

    public LockState(Account account) {
        this.account = (AccountBean) account;
    }

    @Override
    public String withdraw(double amount) {
        return "Sorry, Unable to perform withdrawal. Account should have minimum RM50 in order to perform withdrawal.\n" + "Current Account State: " + account.getState().getStateName() + "\nAccount Balance RM:" + account.getBalance() + "\n";

    }

    @Override
    public String deposit(double amount) {
        account.increaseBalance(amount);
        if (account.getBalance() >= 50) {
            account.setState(account.getNormalState());
        }
        return "RM" + amount + " is added to the account\nCurrent Account State: " + account.getState().getStateName() + "\nAccount Balance: RM" + account.getBalance() + "\n";
    }

    @Override
    public String getStateName() {
        return "Lock State";
    }
}
