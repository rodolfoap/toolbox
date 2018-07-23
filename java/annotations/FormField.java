///**
// * 
// */
//package org.rap.prgtests.annotations;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//
///**
// * This annotation is used to describe the location of the fields on the form.
// * 
// * @author RodolfoAP
// */
//@Retention(RetentionPolicy.RUNTIME)
//public @interface FormField
//{
//    /**
//     * @author RodolfoAP
//     */
//    public enum Section
//    {
//        GLOBALS, PARAM_DEFINITION, TESTSET_DEFINITION
//    }
//
//    /**
//     * @author RodolfoAP
//     */
//    public enum Widget
//    {
//        TEXT, COMBO, RADIO
//    }
//
//
//    /**
//     * @return
//     */
//    Section section();
//
//    /**
//     * @return
//     */
//    Widget widget();
//
//    /**
//     * @return
//     */
//    String label() default "NO_LABEL";
//
//    /**
//     * @return
//     */
//    int key() default 0;
//}
