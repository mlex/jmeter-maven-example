# JMeter Maven Example
Example how to integrate jmeter tests in a maven build and how to automatically generate graphs from the test results using the jmeter plugins CMDRunner.

The jmeter tests can easily be used as part of a jenkins-job. See https://mlex.ci.cloudbees.com/job/jmeter-maven-example/. The repository also contains a docker-image of a preconfigured jenkins.

This example was created to accompany a blog post: https://blog.codecentric.de/2013/12/jmeter-tests-mit-maven-und-jenkins-automatisieren/

The [jmeter-maven-plugin](https://github.com/Ronnie76er/jmeter-maven-plugin) is used to integrate jmeter in the maven build. To generate graphs from the jmeter results, the [jmeter-graph-maven-plugin](https://github.com/codecentric/jmeter-graph-maven-plugin) is used.

## Jenkins
Under `docker/jenkins` can find a jenkins with a preconfigured build-job that runs the jmeter tests and archives the results. Just build the docker image with
```
cd docker/jenkins
docker build -t jmeter-jenkins .
```

and run the container with
```
docker run -p=8080:8080 jmeter-jenkins
```
and you can access the jenkins in your browser via `http://localhost:8080/jenkins/`.

## Quickstart
Just execute

```bash
mvn -Pembedded-jetty verify
```

This will
* start an embedded jetty server wit a small webapp,
* run jmeter tests (just some http requests) against this webserver and
* create some nice graphs of the result (you will find them in `target/jmeter/results`).

## JMeter GUI

To start the JMeter GUI, use the `jmeter:gui` goal. The tests are located in `/src/test/jmeter`. If you start the tests, make sure that the example webapp is running. You can start the webapp explicitly with `jetty:run`.

## JMeter Headless

To just execute the jmeter-tests from commandline (without gui, without embedded webapp, without graph-generation), use the `jmeter:jmeter` goal. The tests expect a running example webapp, so make sure at `http://localhost:9097/`. The results of the test-run can be found in `/target/jmeter/results`. If you want graph-generation, run `mvn verify` (without the "local" profile).

## Configuration
The following maven-properties are available (to set them from commandline, simply add `-Dproperty=value`)

<table>
  <tr>
    <th>Property</th>
    <th>Default</th>
  </tr>
  <tr>
    <td>jetty.port</td>
    <td>9097</td>
  </tr>
  <tr>
    <td>performancetest.webservice.host</td>
    <td>localhost</td>
  </tr>
  <tr>
    <td>performancetest.webservice.port</td>
    <td>${jetty.port}</td>
  </tr>
  <tr>
    <td>performancetest.webservice.path</td>
    <td>/</td>
  </tr>
  <tr>
    <td>performancetest.connectTimeout</td>
    <td>1000</td>
  </tr>
  <tr>
    <td>performancetest.responseTimeout</td>
    <td>3000</td>
  </tr>
  <tr>
    <td>performancetest.threadCount</td>
    <td>20</td>
  </tr>
  <tr>
    <td>performancetest.loopCount</td>
    <td>10</td>
  </tr>
</table>
