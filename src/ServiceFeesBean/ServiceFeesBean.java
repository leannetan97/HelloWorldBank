/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceFeesBean;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeDefaultInterceptors;

/**
 *
 * @jeejfyan
 */
@Stateless
@ExcludeDefaultInterceptors
public class ServiceFeesBean implements ServiceFees {

    @Override
    public double serviceCharge(double amount) {
        double charge = amount * 0.01;
        return charge;
    }

}
