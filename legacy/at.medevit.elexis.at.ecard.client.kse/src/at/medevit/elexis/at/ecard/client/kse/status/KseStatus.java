package at.medevit.elexis.at.ecard.client.kse.status;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import java.util.Observer;

import at.chipkarte.client.base.soap.exceptions.AccessException;
import at.chipkarte.client.base.soap.exceptions.DialogException;
import at.chipkarte.client.base.soap.exceptions.ServiceException;
import at.chipkarte.client.kse.soap.exceptions.KseException;
import at.medevit.elexis.at.ecard.client.base.status.DialogStatus;
import at.medevit.elexis.at.ecard.client.kse.KseService;

public class KseStatus implements Observer {
	
	private static KseStatus instance = null;
	
	long numberOfflineKonsultationen;
	long numberOfflineNachsignaturen;
	
	private KseStatus(){}
	
	public static KseStatus getInstance(){
		if (instance == null) {
			instance = new KseStatus();
		}
		return instance;
	}
	
	public void updateStatus(){
		int dialogStatus = DialogStatus.getDialogStatus();
		if (dialogStatus != DialogStatus.DIALOG_STATUS_CLOSED) {
			try {
				setNumberOfflineKonsultationen(KseService.getInstance(null)
					.getNumberOfflineKonsultationen(DialogStatus.getDialogId()));
				setNumberOfflineNachsignaturen(KseService.getInstance(null)
					.getNumberOfflineNachsignaturen(DialogStatus.getDialogId()));
			} catch (DialogException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1){
		instance.updateStatus();
	}

	private void setNumberOfflineKonsultationen(long val){
		firePropertyChange("numberOfflineKonsultationen", this.numberOfflineKonsultationen,
			this.numberOfflineKonsultationen = val);
	}
	
	public long getNumberOfflineKonsultationen(){
		return numberOfflineKonsultationen;
	}
	
	private void setNumberOfflineNachsignaturen(long val){
		firePropertyChange("numberOfflineNachsignaturen", this.numberOfflineNachsignaturen,
			this.numberOfflineNachsignaturen = val);
	}
	
	public long getNumberOfflineNachsignaturen(){
		return numberOfflineNachsignaturen;
	}
	
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
	
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener){
		propertyChangeSupport.removePropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener){
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}
	
	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue){
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
