/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.User;

/**
 *
 * @author toesl
 */
public class AccountService {
    
    //empty AccountService constructor
    public AccountService() {
        
    }
    
    //Method checks if the params pass the authentication check for username and password
    //if it passes returns empty user object
    //if it fails returns null
    public User login(String username, String password) {
        if ((username.equals("adam") && password.equals("password")) || (username.equals("betty") && password.equals("password"))) {
            String pass = null;
            return new User(pass);
        }
        else {
            return null;
        }
    }
    
}
