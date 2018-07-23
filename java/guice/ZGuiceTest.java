package org.rap.prgtests.guice;
import java.io.InputStream;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
 
public class ZGuiceTest {
 
     public static void main(String args[]) {
          boolean isAndroidApp = true;
 
          Injector injector = null;
          if ( isAndroidApp ){
               injector = Guice.createInjector(new MobileInjectionModule( ));
          }
          else
               injector = Guice.createInjector(new DesktopInjectionModule( ));
 
          ImageLoader imageLoader = injector.getInstance(ImageLoader.class);
 
          System.out.println(imageLoader.getFileHandler().getClass().toString());
 
     }
 
     public static class DesktopInjectionModule extends AbstractModule {
 
          @Override
          protected void configure() {
               bind(FileHandler.class).to(FileHandlerDesktop.class);
 
          }
 
     }
 
     public static class MobileInjectionModule extends AbstractModule {
 
          @Override
          protected void configure() {
               bind(FileHandler.class).to(FileHandlerAndroid.class);
 
          }
 
     }
 
     public static interface FileHandler {
 
          InputStream getInputStream(String uri);
 
     }
 
     public static class FileHandlerAndroid implements FileHandler {
 
          public InputStream getInputStream(String uri) {
               // Código propio de la aplicación móvil
               return null;
          }
 
     }
 
     public static class FileHandlerDesktop implements FileHandler {
 
          public InputStream getInputStream(String uri) {
               // Código propio de la aplicación de escritorio
               return null;
          }
 
     }
 
     public static class ImageLoader {
 
          private FileHandler fileHandler;
 
          @Inject
          public ImageLoader(FileHandler fileHandler) {
               this.fileHandler = fileHandler;
          }
 
          public void loadImage(String uri) {
               InputStream is = fileHandler.getInputStream(uri);
               // Más código de procesamiento...
          }
 
          public FileHandler getFileHandler( ){
               return fileHandler;
          }
 
     }
}