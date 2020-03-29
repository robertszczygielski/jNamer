#JNamer

Welcome to JNamer, a simply name generator. 

You can use this library for generate names and surnames.

#### Male Name:
to generate male name:
- one name: 
```
String name = MaleName.generateOne();
```

- more then one name
```
List<String> names = MaleName.numberOfNames(numberOfNames).generate();
```

- one name with respect = Mr.
```
String name = MaleName.withMr().generate();
```

#### Female name:

- for generate one female name use:
```
String name = FemaleName.generateOne();
```

- more then one name
```
List<String> names = FemaleName.numberOfNames(numberOfNames).generate();
```

- one name with respect = Ms.
```
String name = FemaleName.withMs().generate();
```

#### Surname:
- for generate one surname use:
```
String surname = Surname.generateOne();
```

- more then one name
```
List<String> surnames = Surname.numberOfNames(numberOfSurnames).generate();
```
