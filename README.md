# Hello World Bank
This is Component Based Software Engineering Assignment developed using Java EE

## Introduction
We aim to implement a Hello World Bank system, which is a banking system, which applies the Component-based feature of EJB, which stands for Enterprise Java Beans. The system would allow the user to check his balance, withdraw, and deposit cash into it. We use EJB by separating two components which is the AccountStatefulBean component (which represents the AccountBeanRemote Interface), and the ServiceFeesBean component which (represents the ServiceFeesBeanLocal Interface), and both are deployed in the Glassfish Server.  
 
The requirements required in this application would include:- 
1. Allowing the user to check his/her account balance 
2. Allowing the user to withdraw a specific amount of value from his/her account 
3. Allowing the user to deposit a specific amount of value to his/her account 
4. Maintaining a dependency depth of 1 for the whole system 


## Use Case and Use Case Description
### Use Case
![](/markdownImage/helloWorldBank_usecase.png)

### Use Case Description
1. Deposit ---- User can deposit the money to their account. 
2. Withdraw ---- User can withdraw the money from their account under normal state. If the account is under lock state, then user no longer can withdraw the money.
3. CheckBalance ---- User can check the current balance of their account. 


## State Machine Diagram
![](/markdownImage/helloWorldBank_stateDiagram.png)

<p> In this program, we apply State design pattern which the account will loop between the Lock State and Normal State. The initial state of the Account is Lock State as the balance is RM0. The account will only change to Normal State when the account balance is more than equal to RM50. On the other hand, after user perform withdrawal and the balance is less than RM50, the account will change to Lock State. </p>


## Deployment
### Deployment Diagram
![](/markdownImage/helloWorldBank_deployment.png)

### Steps of Deployment of System 
1. Download and launch Java EE Netbeans 8.2 
2. Create Java Class Library in Java category.  
3. Create remote interface <i>AccountBeanRemote class</i> and local interface <i>ServiceFeesBeanLocal class</i>
4. Create an Enterprise Application 
5. Create a Stateful Session Bean, <i>AccountBean</i> session bean 
6. Add business method to the beans (deposit(), withdraw(), checkBalance()) 
7. Create a Stateless Session Bean, <i>ServiceFeesBean</i> session bean 
8. Add business method to the beans (serviceCharge()) 
9. Create Application Client, HelloWorldBank 
10.Adding the Class Library to call Enterprise Bean, <i>AccountBean</i>
11.Run Application Client, <i>HelloWorldBank</i>

## Contributors:
1. Low Jie Fong
2. Lee Chia Jee 
3. Tan Lay Yan
