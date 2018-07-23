//package org.rap.prgtests.xtend
//
///* See the annotation definition on org.rap.library.xtend.annotations.Customized1
// * The @Customized1 annotation is extracted from an example video
// * on YouTube: https://www.youtube.com/watch?v=k8ldvkWhzTM
// * 
// * What it does? 
// * - Adds a field:
// * 		private final LinkedList myList = new LinkedList(); ...
// * 
// * - Adds a method:
// * 		public void addTwice(final LinkedList param1) { myList.add(param1); myList.add(param1); }
// *
// * - Adds getters & setters:
// *		public String getName() { return name; }
// * 		public void setName(final String name) { this.name=name; }
// */
//
//import org.rap.library.xtend.annotations.Customized1
//
//@Customized1
//class ActiveAnnotations_Customized1 {
//	String name
//}
//
///* Generated code:
//
//package org.rap.prgtests.xtend;
//
//import java.util.LinkedList;
//import org.rap.library.xtend.annotations.Customized1;
//
//@Customized1
//@SuppressWarnings("all")
//public class Customized1_Person {
//  private String name;
//  
//  private final LinkedList myList = new LinkedList();
//  
//  public void addTwice(final LinkedList param1) {
//    myList.add(param1);
//    myList.add(param1);
//  }
//  
//  public String getName() {
//    return name;
//  }
//  
//  public void setName(final String name) {
//    this.name=name;
//  }
//}
//
// 
//---THE-ANNOTATION--------------------------------------------------------------------------------------------------
//
// package org.rap.library.xtend.annotations
//
//import java.util.LinkedList
//import org.eclipse.xtend.lib.macro.AbstractClassProcessor
//import org.eclipse.xtend.lib.macro.Active
//import org.eclipse.xtend.lib.macro.TransformationContext
//import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
//
//@Active(Customized1Processor)
//annotation Customized1 {}
//
//class Customized1Processor extends AbstractClassProcessor {
//
//	override doTransform(MutableClassDeclaration annotatedClass, extension TransformationContext context) {
//		
//		val myList = LinkedList.newTypeReference
//		annotatedClass.addField("myList") [
//			type = myList
//			final = true
//			initializer = '''new «myList.simpleName»()'''
//		]
//		annotatedClass.addMethod("addTwice") [
//			addParameter("param1", myList)
//			body = '''
//				myList.add(param1);
//				myList.add(param1);
//			'''
//		]
//		for (field : annotatedClass.declaredFields.filter[simpleName != 'myList']) {
//			annotatedClass.addMethod('''get«field.simpleName.toFirstUpper»''') [
//				returnType = field.type
//				body = '''
//					return «field.simpleName»;
//				'''
//			]
//			annotatedClass.addMethod('''set«field.simpleName.toFirstUpper»''') [
//				addParameter(field.simpleName, field.type)
//				body = '''
//					this.«field.simpleName»=«field.simpleName»;
//				'''
//			]
//		}
//	}
//}
//
//*/