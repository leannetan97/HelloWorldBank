/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountStatefulBean;

import ServiceFeesBean.ServiceFees;
import javax.ejb.Stateful;
import javax.ejb.EJB;
import javax.annotation.PreDestroy;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
/**
 *
 * @jeejfyan
 */

@Stateful
//@Interceptors({AuditInterceptor.class})
public class AccountBean implements Account {
    @EJB(beanName="ServiceFeesBean")
    private ServiceFees serviceFees;
    private double balance;
    private final State lockState;
    private final State normalState;
    private State currentState;

    public AccountBean() {
        lockState = new LockState(this);
        normalState = new NormalState(this);
        currentState = lockState;
        balance = 0;
    }

    @Override
    public String deposit(double amount) {
        System.out.println("DEPOSIT");
        return currentState.deposit(amount);
    }

    @Override
    public String withdraw(double amount) {
        System.out.println("WITHDRAW");
        return currentState.withdraw(amount);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return currentState;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double newBalance) {
        balance += newBalance;
    }

    public void deductBalance(double newBalance) {
        balance -= newBalance;
    }

    public State getLockState() {
        return lockState;
    }

    public State getNormalState() {
        return normalState;
    }
    
    @ExcludeClassInterceptors
    public double getServiceCharge(double amount) {
        return serviceFees.serviceCharge(amount);
//        return 0.0;
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Invoking method: preDestroy()");
    }

}
