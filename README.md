# JMeter Maven Example
Example how to integrate jmeter tests in a maven build and how to automatically generate graphs from the test results using the jmeter plugins CMDRunner. 

Just execute

```bash
mvn -Plocal verify
```

This will 
* start an embedded jetty server wit a small webapp,
* run jmeter tests (just some http requests) against this webserver and
* create some nice graphs of the result (you will find them in 'target/jmeter/results').
