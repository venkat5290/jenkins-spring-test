package in.mytest.jenkins.spring.test.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private String res;

    public String getHello(String name){
        res = "Hello  "+ name;
        return res;
    }

    public String getHealth(String instance){
       res = instance + " is ok";
        return res;
    }
}
