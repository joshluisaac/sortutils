
## PROJECT INTENT AND SOME BACKGROUND

[![Build Status](https://travis-ci.org/joshluisaac/sortutils.svg?branch=master)](https://travis-ci.org/joshluisaac/sortutils)


The intent of this project is to allow the user to sort a collection of distances in the most efficient way.
Efficient in this context is defined in terms of time and space complexity. It will first convert all distances (provided the distances are
any of `km,m,cm,mm`) into the same base unit. I have chosen millimeters(mm) as the lowest common denominator. All units are converted into mm
before sorting is executed.


I scoped the problem as a merge and insertion sort problem and implemented the merge sort in accordance to the
divide and conquer algorithm that was proposed and invented by John von Neumann in 1945.

What determines which algorithm would be used, depends on the size of `INSERTIONSORT_THRESHOLD`
located in [SortDistanceApp.java](src/main/java/com/sortutils/SortDistanceApp.java). This value is internally defaulted to 7.
This meas that if the sample data size is less than 7 insertion sort is used other wise merge sort is preferred.

The algorithm offers __O(n log(n))__ performance in all cases (worst,average and best case) and is better suited for
sorting large collection of integers. Other sorting algorithms such as insertion sort, radix sort or bubble sort yields a
quadratic __O(N^2)__ performance which isn't scalable for large data sets.


What is included?
------------------------
The project includes the source code, behaviour driven tests based on the specifications provided and build scripts for Maven.
It also ships with a compiled version of the project making it makes it easy execute the application from terminal.
The compiled version of the project resided in the `target` directory and can be executed from command-line/terminal

Bill of materials
--------------------------
1. Tests written with Junit.
2. Source code.
1. Code test coverage report: This can be found here `/target/site/cobertura`
2. API documentation: This can be found here `/target/site/apidocs`

Maven will automatically download all required dependencies, compile the project, and finally run the tests specs.

Prerequisites
-------------
- JDK 8 or higher
- Maven use `mvnw` wrapper

Building the application and copying the dependencies
-----------------------------------------------------
Run this command below to build and copy the dependencies to project `lib` directory.

```shell
mvn clean install dependency:copy-dependencies
```

This command will produce an output like this below.

```
INFO] --- maven-dependency-plugin:3.1.1:copy-dependencies (copy-dependencies) @ sortutils ---
[INFO] Copying groovy-all-2.4.15.jar to /media/joshua/martian/projects/sortutils/lib/groovy-all-2.4.15.jar
[INFO] Copying slf4j-api-1.7.22.jar to /media/joshua/martian/projects/sortutils/lib/slf4j-api-1.7.22.jar
[INFO] Copying gson-2.8.5.jar to /media/joshua/martian/projects/sortutils/lib/gson-2.8.5.jar
[INFO] Copying logback-classic-1.1.11.jar to /media/joshua/martian/projects/sortutils/lib/logback-classic-1.1.11.jar
[INFO] Copying logback-core-1.1.11.jar to /media/joshua/martian/projects/sortutils/lib/logback-core-1.1.11.jar
[INFO]
[INFO] --- maven-shade-plugin:3.2.1:shade (default) @ sortutils ---
[INFO] Including org.codehaus.groovy:groovy-all:jar:2.4.15 in the shaded jar.
[INFO] Including ch.qos.logback:logback-classic:jar:1.1.11 in the shaded jar.
[INFO] Including ch.qos.logback:logback-core:jar:1.1.11 in the shaded jar.
[INFO] Including org.slf4j:slf4j-api:jar:1.7.22 in the shaded jar.
[INFO] Including com.google.code.gson:gson:jar:2.8.5 in the shaded jar.
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /media/joshua/martian/projects/sortutils/target/sortutils-0.0.1-SNAPSHOT.jar with /media/joshua/martian/projects/sortutils/target/sortutils-0.0.1-SNAPSHOT-shaded.jar
[INFO] Dependency-reduced POM written at: /media/joshua/martian/projects/sortutils/dependency-reduced-pom.xml
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ sortutils ---
[INFO] Installing /media/joshua/martian/projects/sortutils/target/sortutils-0.0.1-SNAPSHOT.jar to /home/joshua/.m2/repository/com/sortutils/sortutils/0.0.1-SNAPSHOT/sortutils-0.0.1-SNAPSHOT.jar
[INFO] Installing /media/joshua/martian/projects/sortutils/dependency-reduced-pom.xml to /home/joshua/.m2/repository/com/sortutils/sortutils/0.0.1-SNAPSHOT/sortutils-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.900 s
[INFO] Finished at: 2019-04-08T16:18:33+10:00
[INFO] ------------------------------------------------------------------------


```

After building you will find the complied jar loated in `target/sortutils-0.0.1-SNAPSHOT.jar`

Executing the application
-------------------------

1. First prepare your unsorted list of distances. A sample of this is located here [inputsample.json](inputsample.json)

It basically looks like this. A `JSON` formatted string
```json
{"distances":
[{"key":"cm","value":1.367},{"key":"km","value":-1.37},{"key":"mm","value":1},
{"key":"mm","value":1},{"key":"km","value":1.976},{"key":"km","value":1.976}]}
```

2. Run `java -jar target/sortutils-0.0.1-SNAPSHOT.jar
       "{\"distances\":[{\"key\":\"cm\",\"value\":1.367},{\"key\":\"km\",\"value\":-1.37},{\"key\":\"mm\",\"value\":1}]}"`


Executing the above command will produce the following output

```
Raw list: {"distances":[{"key":"cm","value":1.367},{"key":"km","value":-1.37},{"key":"mm","value":1}]}
Unique list: [13.67, -1370000.0, 1.0]
Sorted result: [-1370000.0, 1.0, 13.67]
Response payload: {
  "count": 1,
  "sortResult": "[-1370000.0, 1.0, 13.67]",
  "runningTime": "0 ms",
  "arraySize": 3
}

```
>> 1. The raw `JSON` unsorted list of distances.
>> 1. Unique list: what is left after removing duplicates.
>> 1. Sorted result: the sorted result output
>> 1. Response payload: Complete response with extra meta data.
>>> 1. `count:` this is the minimum number of iterations.
>>> 2. `sortResult`: this is the sorted integer array
>>> 3. `runningTime`: Running time, how long it took to execute.
>>> 4. `arraySize`: the size of the input array after removing duplicates.


Type checking:
-----------------
These are the valid keys `km,mm,m,cm` anything outside this boundary will throw an `java.lang.IllegalArgumentException`

For example

Executing a command like this will throw a runtime exception.

```shell
java -jar target/sortutils-0.0.1-SNAPSHOT.jar "{\"distances\":[{\"key\":\"kcm\",\"value\":1.367}]}"

```

```java
2019-04-08 17:02:33,919 ERROR kcm is not a valid DistanceUnitType
Exception in thread "main" java.lang.IllegalArgumentException: The argument specified is not a valid DistanceUnitType
        at com.sortutils.util.MapperUtils.map(MapperUtils.java:55)
        at com.sortutils.SortDistanceApp.main(SortDistanceApp.java:51)
```


Building the API docs
---------------------

Execute the command below to build API javadoc from the source code.

```shell
mvn javadoc:javadoc
```

The result is put in `/target/site/apidocs`


Running the code coverage.
--------------------------
Execute `mvn cobertura:cobertura` to generate the code/test coverage report. The output is located in `target/site/cobertura/`

Building the source code without tests
--------------------------------------

```shell
mvn clean install -Dmaven.test.skip=true
```

This will compile, package and install the project. A JAR file called `sortutils-0.0.1-SNAPSHOT.jar` is generated
at the end of this phase and the result is copied to `target` directory.


Running the tests.
------------------

The tests are written in Java using Junit framework.
The source code for the tests are located in `src/test/java`.
I wrote the tests to be simple and readable. Anyone looking at the tests would find it easy to figure out what's going on.

```shell
mvn clean install
```
This will run all the tests in `src/test/java` directory and you will see an output like this below.

### Test logs
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running MergeSortTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.329 sec
Running InsertionSortTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running InputValidationParserTest
2019-04-08 17:11:14,560 ERROR {"distances"[{"key":"cm","value":1.367},{"key":"km","value":-1.37},{"key":"km","value":1.976}]} is not a valid JSON formatted string.
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.079 sec

Results :

Tests run: 10, Failures: 0, Errors: 0, Skipped: 0

```


## Continuous integration
Used Travis for continuous integration

[mainclass]: mainclass.png "Logo Title Text 2"