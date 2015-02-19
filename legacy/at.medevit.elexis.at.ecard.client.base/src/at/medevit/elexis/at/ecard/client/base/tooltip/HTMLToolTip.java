package at.medevit.elexis.at.ecard.client.base.tooltip;

import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;


public class HTMLToolTip extends ToolTip {
	
	Control m_control;
	String m_htmlString;
	
	/**
	 * 
	 * @param control
	 * @param htmlString conforming to {@link FormText}
	 */
	public HTMLToolTip(Control control, String htmlString) {
		super(control);
		m_control = control;
		m_htmlString = htmlString;
		super.setShift(new Point(15, 15));
	}
	
	private HTMLToolTip(Control control){
		super(control);
	}

	@Override
	protected Composite createToolTipContentArea(Event event, Composite parent){
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		FormColors colors = toolkit.getColors();
		
		Form form = toolkit.createForm(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		form.getBody().setLayout(layout);
		
		FormText text = toolkit.createFormText(form.getBody(), true);
		GridData td = new GridData();
		td.heightHint = 200;
		td.widthHint = 300;
		text.setLayoutData(td);
		
		try {
			text.setText("<form>"+m_htmlString+"</form>", true, true);
		} catch (IllegalArgumentException e) {
			text.setText("<form><p>Fehlerhafter ToolTip Eingabestring</p><br /></form>", true, true);
		}
		
		return parent;
	}

	
}
