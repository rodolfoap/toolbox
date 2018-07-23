//package a.ssm.runnable;
//
//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.emf.ecore.resource.ResourceSet;
//import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
//import ssm.Activity;
//import ssm.SsmFactory;
//import ssm.SystemElement;
//import ssm.impl.SsmFactoryImpl;
//import java.io.File;
//import java.io.IOException;
//import java.util.Collections;
//
//public class Runnable {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//			System.out.println("Hil.");
//			
//			SsmFactoryImpl.init();
//			SsmFactory factory=SsmFactoryImpl.eINSTANCE;
//
//			SystemElement Se1 = factory.createSystemElement();
//			Se1.setName("SystemElement1");
//			
//			Activity Ac1=factory.createActivity();
//			Ac1.setName("Activity1");
//			Activity Ac2=factory.createActivity();
//			Ac2.setName("Activity2");
//			
//			Se1.getActivities().add(Ac1);
//			Se1.getActivities().add(Ac2);
//			System.out.println(Se1.getName());
//			
//			
//			
//			
//			
//			// Create a resource set.
//			ResourceSet resourceSet = new ResourceSetImpl();
//
//			// Register the default resource factory -- only needed for stand-alone!
//			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//		Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
//
//			// Get the URI of the model file.
//			URI fileURI = URI.createFileURI(new File("mylibrary.xmi").getAbsolutePath());
//
//			// Create a resource for this file.
//			Resource resource = resourceSet.createResource(fileURI);
//
//			// Add the book and writer objects to the contents.
//			resource.getContents().add(Se1);
//			resource.getContents().add(Ac1);
//			resource.getContents().add(Ac2);
//
//			// Save the contents of the resource to the file system.
//			try
//			{
//			resource.save(Collections.EMPTY_MAP);
//			}
//			catch (IOException e) {}
//	}
//}
//
