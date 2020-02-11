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
public class NormalState implements State {

    AccountBean account;

    public NormalState(Account account) {
        this.account = (AccountBean) account;
    }

    @Override
    public String withdraw(double amount) {
        double charges = account.getServiceCharge(amount);
        double total = charges + amount;
        if (amount >= 1000 && total <= account.getBalance()) {
            account.deductBalance(total);
            updateState();
            return "RM" + amount + " with addititonal charges RM" + charges + " is deduct from the account\nCurrent Account State:" + account.getState().getStateName() + "\nAccount Balance: RM" + account.getBalance() + "\n";
        } else if (amount < 1000 && amount <= account.getBalance()) {
            account.deductBalance(amount);
            updateState();
            return "RM" + amount + " is deduct from the account\nCurrent Account State: " + account.getState().getStateName() + "\nAccount Balance: RM" + account.getBalance() + "\n";
        } else {
            return "Withdraw amount is more than account balance.\nWithdraw transaction is denied.";
        }
    }

    @Override
    public String deposit(double amount) {
        account.increaseBalance(amount);
        return "RM" + amount + " is added to the account\nCurrent Account State: " + account.getState().getStateName() + "\nAccount Balance: RM" + account.getBalance() + "\n";
    }

    @Override
    public String getStateName() {
        return "Normal State";
    }

    private void updateState() {
        if (account.getBalance() < 50) {
            account.setState(account.getLockState());
        }
    }
}
