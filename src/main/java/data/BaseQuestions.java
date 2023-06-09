package data;

import java.util.*;

public enum BaseQuestions {
    JAVA_ECOSYSTEM(new LinkedHashSet<>(List.of(
            "What is the JVM?",
            "What does Java compilation mean?",
            "What is Java bytecode?",
            "What is the difference between the JRE and the JDK?",
            "What is the `Iterable` interface?",
            "What is the `Collection` interface?",
            "What is the `Map` interface?",
            "Compare sets, lists, and queues in Java.",
            "Compare `ArrayList` and `LinkedList` in Java.",
            "Are sets sorted in Java?")));

    //    LANGUAGE_FEATURES(new LinkedHashSet<>(List.of(
//            "What control statements are available in Java?",
//            "Compare the different looping constructs in Java.",
//            "Compare the different conditional constructs in Java.",
//            "What is a `while` loop?",
//            "How do you manually break out of a loop?",
//            "What does the `var` keyword mean?",
//            "What are _lambda expressions_? How are they used in Java development?")));
//
//
//    TYPE_SYSTEM(new LinkedHashSet<>(List.of(
//            "What are primitive types in Java? Give some examples.",
//            "What is the difference between primitive types and reference types?",
//            "What is a class in Java?",
//            "What is an object in Java?",
//            "What is a constructor?",
//            "What is an enum in Java?",
//            "Explain the difference between a class and an enum.",
//            "Explain the difference between a class and a record.",
//            "What are interfaces? Why should we use them?",
//            "What is inheritance?",
//            "Is multiple inheritance allowed in Java?",
//            "What is a static class member?",
//            "Can a static method use non-static members?",
//            "What does the final keyword mean in Java?",
//            "What does the abstract keyword mean in Java?",
//            "What is overloading in Java?",
//            "What is overriding in Java?",
//            "What is the difference between overloading and overriding?",
//            "What is null?",
//            "Compare the access modifiers in Java.",
//            "What is the default access modifier in a class?",
//            "What is the purpose of the equals() method?",
//            "What is the difference between `==` and `equals()`?",
//            "What is the difference between `long` and `Long`?",
//            "Which can store bigger numbers, `long` or `Long`?",
//            "What kind of packages do you know under `java.util.*` ? Bring at least 3 examples."
//    ))),
//
//    ARCHITECTURE(new LinkedHashSet<>(List.of(
//            "Explain the Single Responsibility Principle.",
//            "Explain the Interface Segregation Principle.",
//            "What is composition over inheritance?",
//            "What is a model class?",
//            "What is a service class?",
//            "Explain the Open/Closed principle.",
//            "Explain the Liskov Substitution Principle.",
//            "Explain the Dependency Inversion Principle.",
//            "What do we mean by the Gang of Four (GoF) Design Patterns? Can you name some of these patterns?",
//            "What are the risks associated with using the GoF design patterns?",
//            "What do we mean by YAGNI?",
//            "What do we mean by SLAP?",
//            "What do we mean by KISS?",
//            "What is the Repository Pattern?",
//            "What is a CRUD interface?"
//    ))),
//
//    UNIT_TESTING(new LinkedHashSet<>(List.of(
//            "Why is unit testing a good practice?",
//            "What is JUnit?",
//            "What is a parameterized test?",
//            "What options do you have in NUnit to create parameterized tests?",
//            "What is mocking?",
//            "What is the difference between mocking, stubbing and faking?"))),
//
//    DATABASES(new LinkedHashSet<>(List.of(
//            "What are relational databases? What are their advantages and disadvantages?",
//            "How do you associate entities to each other in a relational database model?",
//            "What are tables in a relational database?",
//            "What is a primary key?",
//            "What is a foreign key?",
//            "What does the SQL abbreviation stand for?",
//            "What are some of the SQL database providers that you’ve heard of?",
//            "What are SQL data types? Are there any differences in data types between different SQL databases?",
//            "What are constraints in SQL?",
//            "How can we program different SQL databases in Java?",
//            "Which SQL statement is used to create tables? Describe the syntax briefly.",
//            "Which SQL statement can be used to insert values? Describe the syntax briefly.",
//            "Which SQL statement can be used to update values? Describe the syntax briefly.",
//            "Which SQL statement can be used to delete rows?. Describe the syntax briefly.",
//            "Which SQL statement can be used to create queries?. Describe the syntax briefly.",
//            "How can you join tables together in SQL? When should you do it?"
//    )));
    private final Set<String> questions;

    BaseQuestions(Set<String> questions) {
        this.questions = questions;
    }

    public Set<String> getQuestions() {
        return questions;
    }
}
