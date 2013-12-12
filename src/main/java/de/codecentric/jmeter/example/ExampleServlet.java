package de.codecentric.jmeter.example;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Random;


public class ExampleServlet extends GenericServlet {
    private Random random = new Random();

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            // Wait a random time between 500 and 1500 msec
            Thread.sleep(random.nextInt(1000) + 500);
        } catch (InterruptedException e) {
            // Don't care if we've been interrupted
        }
        res.getOutputStream().print("Hello World");
    }
}
