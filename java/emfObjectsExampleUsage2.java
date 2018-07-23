//package org.rap.prgtests;
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
//		System.out.println("Factory boot&instance.");
//		SsmFactoryImpl.init();
//		SsmFactory factory = SsmFactoryImpl.eINSTANCE;
//
//		System.out.println("Create SystemElement.");
//		SystemElement Se1 = factory.createSystemElement();
//		Se1.setName("SystemElement11");
//
//		System.out.println("Create Activity11.");
//		Activity Ac1 = factory.createActivity();
//		Ac1.setName("Activity11");
//		System.out.println("Create Activity22.");
//		Activity Ac2 = factory.createActivity();
//		Ac2.setName("Activity22");
//
//		System.out.println("Adding Activities to SystemElement.");
//		Se1.getActivities().add(Ac1);
//		Se1.getActivities().add(Ac2);
//		System.out.println("Se1.getName()="+Se1.getName());
//
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,new XMIResourceFactoryImpl());
//		URI fileURI = URI.createFileURI(new File("mylibrary.xmi").getAbsolutePath());
//		Resource resource = resourceSet.createResource(fileURI);
//		resource.getContents().add(Se1);
//		resource.getContents().add(Ac1);
//		resource.getContents().add(Ac2);
//		try {
//			resource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//		}
//	}
//}
