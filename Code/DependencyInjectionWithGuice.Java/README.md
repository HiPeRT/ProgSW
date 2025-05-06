# Depencency Injection with Guice

This is an example of usage of <a href="https://github.com/google/guice">Google Guice</a> for Dependency Injection in Java.

## To compile (Win Powershell)

```
> javac.exe -d ".\bin\" -cp ".\lib\guice-6.0.0.jar" .\src\diwithguice\ConfiguratorModule.java .\src\diwithguice\IServiceConsumer.java .\src\diwithguice\IWriter.java .\src\diwithguice\MainClass.java .\src\diwithguice\MyWriter.java .\src\diwithguice\ServiceConsumerWithSetter.java .\src\diwithguice\ServiceConsumerWithCtor.java
```

## To run (Win Powershell)

```
> java.exe -cp ".\lib\aopalliance-1.0.jar;.\lib\failureaccess-1.0.3.jar;.\lib\guava-33.4.8-jre.jar;.\lib\guice-6.0.0.jar;.\lib\jakarta.inject-api-2.0.1.jar;.\lib\javax.inject-1.jar;.\src\" diwithguice.MainClass
```