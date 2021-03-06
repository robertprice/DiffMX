// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package diff.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import java.util.LinkedList;
import name.fraser.neil.plaintext.diff_match_patch;

/**
 * Compare two pieces of text and return an HTML string with the differences. This is intended for debugging and quick visualation of any changes.
 */
public class Diff_PrettyHTML extends CustomJavaAction<java.lang.String>
{
	private java.lang.String OriginalText;
	private java.lang.String NewText;

	public Diff_PrettyHTML(IContext context, java.lang.String OriginalText, java.lang.String NewText)
	{
		super(context);
		this.OriginalText = OriginalText;
		this.NewText = NewText;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		diff_match_patch dmp = new diff_match_patch();
		LinkedList<diff_match_patch.Diff> diff = dmp.diff_main(this.OriginalText, this.NewText);
		dmp.diff_cleanupSemantic(diff);

		return dmp.diff_prettyHtml(diff);		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Diff_PrettyHTML";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
