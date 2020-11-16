![example workflow name](https://github.com/geekskick/CoinSorterRedo/workflows/Java%20CI%20with%20Maven/badge.svg)


# Coinsorter (redo)
I did a uni project to learn java, but I wasn't happy with what I was able to produce due to academic restrictions. I therefore got some great feedback from my team lead at work, a Java guru, and re did it how I wanted to. 

# Dependencies
* Java 11
* Maven

# Build
```bash
mvn clean package
```

Tests are run prior to the packaging phase, but it's possible to run these alone using:
```bash
mvn clean test
```

# Run
```bash
java -jar target/CoinSorterRedo-1.0.0-jar-with-dependencies.jar
```
## Run with extra logging
```bash
java -jar -Dlog4j.configurationFile=log4j.xml target/CoinSorterRedo-1.0.0-jar-with-dependencies.jar
``
