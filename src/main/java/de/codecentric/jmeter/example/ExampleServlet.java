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
		sleep(100);
		res.getOutputStream().print("Hello ...");
		res.getOutputStream().flush();
		sleep(100);
		res.getOutputStream().print("... World");
    }

	private void sleep(int interval) {
		try {
			// Wait a random time between 0.5*interval and 1.5*interval msec
			Thread.sleep(random.nextInt(interval) + interval/2);
		} catch (InterruptedException e) {
			// Don't care if we've been interrupted
		}
	}
}
