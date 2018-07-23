package library;

public class LogImpl implements ILog
{
    @Override
    public void info(String message)
    {
        System.err.println("3.1.1.1. " + new Throwable().getStackTrace()[0].toString()
                           + ":LogImpl implements ILog, prints message with info(mnessage) ");
        System.out.println(message);
    }
}
