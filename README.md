This project is for testing CDI programmatically.

I try to use CDI.current().select(My.Class, new MyQualifierAnnotationLiteral()).get()
to make CDI inject instance of a My.Class with MyAnnotation, but i got the follow error: No bean found for required type XXX and qualifiers XXX."

But if i use @Named("something") works , or when another code use @Inject with My.class, then the code to get programmatically works ok.

In this project has 2 factories of model Fruit

* AppleFactory

* OrangeFactory

AppleFactory uses @Named to get taste info and OrangeFactory uses @Qualifier annotation for the same.
In package rest has 2 endpoints one for injected example and other with programmatically CDI injection
When injected objects are commented the code in Programmatically class doesn't work but if it isn't commented it works fine.

Why and How does this happen? 

It's likely due to the beans not being in the final jar as the AOT processing cannot see that its being used. This is an optimisation by Quarkus to only add beans that are actually injected.

 https://quarkus.io/guides/cdi-reference#remove_unused_beans
