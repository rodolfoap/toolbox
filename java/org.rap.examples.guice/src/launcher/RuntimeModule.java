package launcher;

import com.google.inject.AbstractModule;

import library.ILog;
import library.LogImpl;
import library.SLogutil;

/**
 * The runtime module binds interfaces with implementations
 *
 * @author RodolfoAP
 */
public class RuntimeModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        System.err.println("1.1." + new Throwable().getStackTrace()[0].toString()
                           + ":Injector.configure() binds ILog.class to LogImpl.class");
        bind(ILog.class).to(LogImpl.class);

        System.err.println("1.2." + new Throwable().getStackTrace()[0].toString()
                           + ":Injector.configure() requests static injection of SLogUtil.class");
        requestStaticInjection(SLogutil.class);
    }
}
