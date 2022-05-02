package in.mytest.jenkins.spring.test.controller;
import in.mytest.jenkins.spring.test.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    private String instance = "Test-Machine";
    private String name = "Welcome to Automated JENKINS DEPLOYMENT to K8S";

    @Autowired
    private HelloService hs;

    @GetMapping("/health")
    public String health(){
        return hs.getHealth(instance);
    }

    @GetMapping("/hello")
    public String hello(){
        return hs.getHello(name);
    }
}
