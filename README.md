# Common

Contains resources that can be shared between microservices.

## Running Development

Create jar
```sh
$ mvn clean package
```

Install jar in maven repository
```sh
$ mvn install:install-file \
   -Dfile=/path/to/target/st-common-1.0.0.jar  \
   -DgroupId=com.ai.st.microservice.common \
   -DartifactId=st-common \
   -Dversion=1.0.0 \
   -Dpackaging=jar \
   -DgeneratePom=true
```

Now microservices can make use of this component

## License

[Agencia de Implementación - BSF Swissphoto - INCIGE](https://github.com/SwissTierrasColombia/st-common/blob/master/LICENSE)