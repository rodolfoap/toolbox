//package org.rap.prgtests;
//
//import org.eclipse.jface.window.ApplicationWindow;
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.*;
// 
//public class Jface extends ApplicationWindow {
//  public static void main(String[] args) {
//    new Jface().run();
//  }
//  public Jface() {
//    super(null);
//  }
//  public void run() {
//    setBlockOnOpen(true);
//    open();
//    Display.getCurrent().dispose();
//  }
//  protected Control createContents(Composite parent) {
//    Label label = new Label(parent, SWT.CENTER);
//    label.setText("Hello, World");
//    return label;
//  }
//}
