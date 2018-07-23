//package org.rap.prgtests.annotations;
//
///**
// * This editor is related to XML/testset files. This class is the main editor.
// * Its contents depend on the structure of the object that it should display.
// * 
// * @author RodolfoAP
// */
//public class TestSetEditor
//{
//    /**
//     * Displays the (current) element that is selected on the TreeView box.
//     * 
//     * @param element
//     */
//    public void showElement(Element element)
//    {
//        System.err.println(new Throwable().getStackTrace()[0].toString() + ": --- : " + element);
//        this.textName.setText(element.toString());
//        this.textDescription.setText(element.getDescription());
//        this.textValueType.setText(element.getValueType());
//
//        /**
//         * This is what I must generate:
//         */
//        // new Label(group1, SWT.NORMAL).setText("Name:");
//        // this.textName.createWidget(group1, "NOMINAL_VOLTAGE_A1", false);
//        // // ---------------------------------------------------- Description
//        // new Label(group1, SWT.NORMAL).setText("Description:");
//        // this.textDescription.createWidget(group1, "Description", false);
//        // // ---------------------------------------------------- Source Type
//        // new Label(group1, SWT.NORMAL).setText("Source Type:");
//        // this.textSourceType.createWidget(group1, "ENGINEERING_PARAMETER",
//        // false);
//        // // ---------------------------------------------------- Type
//        // new Label(group1, SWT.NORMAL).setText("ValueType:");
//        // this.textValueType.createWidget(group1, "Real", false);
//
//        System.err.println(new Throwable().getStackTrace()[0].toString() + ":" + element.getTestSetElement());
//
//        // This is the array of all fields in the test set element;
//        TestSetElement tsElement = element.getTestSetElement();
//        Class tseClass = tsElement.getClass();
//        Field[] allFields = Stream.concat(Arrays.stream(tseClass.getSuperclass().getDeclaredFields()),
//                                          Arrays.stream(tseClass.getDeclaredFields())).toArray(Field[]::new);
//        for (Field field : allFields)
//        {
//            if (field.isAnnotationPresent(FormField.class))
//            {
//                FormField ff = field.getAnnotation(FormField.class);
//                System.out.println(new Throwable().getStackTrace()[0].toString() + ":LBL=" + ff.label() + ":SECTION="
//                                   + ff.section());
//                if (ff.section() == Section.PARAM_DEFINITION)
//                {
//                    try
//                    {
//                        new Label(this.group1, SWT.NORMAL).setText(ff.label());
//                        Object value =
//                                new PropertyDescriptor(field.getName(), tseClass).getReadMethod().invoke(tsElement);
//                        // field.setAccessible(true);
//                        this.textName.createWidget(this.group1, value.toString(), false);
//                    }
//                    catch (Exception e)
//                    {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//}
