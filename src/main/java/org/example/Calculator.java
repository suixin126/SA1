package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Calculator {
    @WebMethod
    public int calculator(int a, int b) {
        if(a - b > 0){
            return  a - b - 5000;
        }
        return a - b;
    }
}
