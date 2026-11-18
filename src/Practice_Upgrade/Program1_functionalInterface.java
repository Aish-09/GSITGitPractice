package practice_Upgrade;

import java.util.function.Consumer;

@FunctionalInterface
interface ITest6 
{
    void hello(String name);
}

// =========================================================================
// STAGE 1 (OLDEST — Pre-Java 1.1): Separate Concrete Implementation Class
// =========================================================================
// WHAT IT WAS: Creating a whole separate class file just to implement 1 method.
// WHY IT WAS REPLACED: Massive boilerplate for simple one-off logic.
class OldConcreteImpl implements ITest6 {
    @Override
    public void hello(String name) {
        System.out.println("hello!" + name);
    }
}

public class Program1_functionalInterface {

    public static void main(String[] args) {

        // =====================================================================
        // STAGE 2 (LEGACY — Java 1.1 to Java 7): Anonymous Inner Class
        // =====================================================================
        // WHAT IT REPLACED: Stage 1's separate class file.
        // WHAT IT STILL REQUIRED: Repeating 'new ITest6()', '@Override', 'public void hello(String name)'.
        // WHY IT WAS REPLACED BY '->': Still 6 lines of boilerplate just to print 1 line,
        //                               plus it generates an extra '.class' file on disk (Program1$1.class).
        ITest6 legacyObj = new ITest6() {
            @Override
            public void hello(String name) {
                System.out.println("hello!" + name);
            }
        };
        legacyObj.hello("Rajat");


        // =====================================================================
        // STAGE 3 (PRIYANKA'S SCREEN — Java 8+): Lambda Expression ('->')
        // =====================================================================
        // WHAT REPLACED WHAT:
        //   - 'new ITest6() { @Override public void hello(String name) {'  ---> REPLACED BY --->  '(str) -> {'
        //   - The compiler infers the class, method name ('hello'), return type ('void'),
        //     and parameter type ('String') automatically from 'ITest6 obj'.
        //   - Uses 'invokedynamic' in bytecode instead of creating a new '.class' file.
        ITest6 obj = (str) -> 
        {
            System.out.println("hello!" + str);
        };
        obj.hello("Rajat"); // Console Output: hello!Rajat


        // =====================================================================
        // STAGE 4 (EVEN SHORTER — Java 8+): Method Reference ('::')
        // =====================================================================
        // WHAT IT REPLACES: A Lambda Expression ('->') that ONLY passes its parameter
        //                   directly into an existing method without modifying it.
        // HOW: 'System.out::println' replaces 'str -> System.out.println(str)'.
        // WHEN: Use '::' in Streams & Playwright/Selenium when an existing method already
        //       matches the Functional Interface's exact parameter & return signature.
        ITest6 methodRefObj = System.out::println;
        methodRefObj.hello("Rajat"); // Console Output: Rajat


        // =====================================================================
        // STAGE 5 (NO CUSTOM INTERFACE NEEDED): Built-in Consumer<T>.accept()
        // =====================================================================
        // WHAT IT REPLACES: Writing your own 'interface ITest6 { void hello(String name); }'.
        // HOW: Java's built-in 'Consumer<String>' already defines 'void accept(String t)'.
        Consumer<String> builtInObj = str -> System.out.println("hello!" + str);
        builtInObj.accept("Rajat"); // Console Output: hello!Rajat
    }
}
