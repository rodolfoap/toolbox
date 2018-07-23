package org.rap.examples.editor;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;

public class RAPEditor extends TextEditor {

	public RAPEditor() {
		super();
		setDocumentProvider(new RAPDocumentProvider());
		IEditorPart editor=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		System.err.println(new Throwable().getStackTrace()[0].toString()); /* RODOLFO */
//		System.out.println(editor.getTitle()); /* RODOLFO */
	}
	public void dispose() {
		System.err.println(new Throwable().getStackTrace()[0].toString()); /* RODOLFO */
		super.dispose();
	}

}
