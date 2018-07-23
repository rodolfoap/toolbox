package library;

import com.google.inject.Inject;

public class SLogutil
{
    @Inject
    private static ILog logger;


    public static void info(String message)
    {
        System.err.println("3.1.1. " + new Throwable().getStackTrace()[0].toString()
                           + ":Call to [@Inject ILog logger] logger.info(message);");
        logger.info(message);
    }
}
