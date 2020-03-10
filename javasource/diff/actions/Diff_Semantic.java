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
import com.mendix.systemwideinterfaces.core.IMendixObject;
import diff.proxies.Diff;
import diff.proxies.ENUM_Operation;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import name.fraser.neil.plaintext.diff_match_patch;

/**
 * Pass two texts to this action and it will return a list of Diff entities containing the difference between the two texts.
 */
public class Diff_Semantic extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String OriginalText;
	private java.lang.String NewText;

	public Diff_Semantic(IContext context, java.lang.String OriginalText, java.lang.String NewText)
	{
		super(context);
		this.OriginalText = OriginalText;
		this.NewText = NewText;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		diff_match_patch dmp = new diff_match_patch();
		LinkedList<diff_match_patch.Diff> diff = dmp.diff_main(this.OriginalText, this.NewText);
		dmp.diff_cleanupSemantic(diff);

		ArrayList<IMendixObject> r = new ArrayList<IMendixObject>();

		Iterator<diff_match_patch.Diff> iterator = diff.iterator();
		while (iterator.hasNext()) {
			diff_match_patch.Diff d = iterator.next();
			Diff mxDiff = new Diff(this.getContext());
			mxDiff.setText(d.text);
			switch(d.operation) {
				case DELETE: 
					mxDiff.setOperation(ENUM_Operation.DELETE);
					break;
				case INSERT:
					mxDiff.setOperation(ENUM_Operation.INSERT);
					break;
				default:
					mxDiff.setOperation(ENUM_Operation.EQUAL);
					break;
			}			
			r.add(mxDiff.getMendixObject());
		}

		return r;		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Diff_Semantic";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}