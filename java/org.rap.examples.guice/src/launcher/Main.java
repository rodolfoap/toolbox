package launcher;

import com.google.inject.Guice;
import com.google.inject.Injector;

// Launcher is the first called class.
public class Main
{

    // Main is called
    public static void main(String[] args)
    {
        System.err.println("1. " + new Throwable().getStackTrace()[0].toString()
                           + ":Create Guice injector RunTimeModule()");
        Injector injector = Guice.createInjector(new RuntimeModule());

        System.err.println("2. " + new Throwable().getStackTrace()[0].toString()
                           + ":Ask HelloWorld instance to injector");
        HelloWorld instance = injector.getInstance(HelloWorld.class);

        System.err.println("3. " + new Throwable().getStackTrace()[0].toString()
                           + ":Call HelloWorld created instance.body()");
        instance.body();
    }
}
