# Design patterns in practice
Sample of common java design patterns

## Strategy
In Strategy pattern, a class behavior or its algorithm can be changed at run time

Design principle:
* Identify the aspects of your application that vary and separate them from what stays the same.
* Program to an interface not an implementation.
* Favor composition over inheritance.

## Singleton
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

## Decorator

We’ll re-examine the typical overuse of inheritance and you’ll learn how to decorate
your classes at runtime using a form of object composition. Why? Once you know the
techniques of decorating, you’ll be able to give your (or someone else’s) objects new
responsibilities without making any code changes to the underlying classes