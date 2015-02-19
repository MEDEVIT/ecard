package at.medevit.elexis.at.validator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.fieldassist.ControlDecoration;

import at.medevit.elexis.at.XID.SVNR;

public class SVNRValidator implements IValidator {

	private final String errorText;
	private final ControlDecoration controlDecoration;

	public SVNRValidator(String errorText, ControlDecoration controlDecoration) {
		super();
		this.errorText = errorText;
		this.controlDecoration = controlDecoration;
	}

	@Override
	public IStatus validate(Object value) {
		if (value == null) {
			controlDecoration.hide();
			return Status.OK_STATUS;
		} else if (value instanceof String) {
			String text = (String) value;
			if (text.length() == 0 || SVNR.validateSVNumber(text)) {
				controlDecoration.hide();
				return Status.OK_STATUS;
			}
		}
		controlDecoration.show();
		return ValidationStatus.error(errorText);

	}
}
