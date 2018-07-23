package org.rap.examples.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class RAPDocumentProvider extends FileDocumentProvider {

	protected IDocument createDocument(Object element) throws CoreException {
		System.err.println(new Throwable().getStackTrace()[0].toString()); /* RODOLFO */
		IDocument document = super.createDocument(element);
		return document;
	}
}