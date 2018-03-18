package _01.gmap.GeocodeView;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;
import org.primefaces.model.map.LatLng;

public class ReverseGeocodeEvent extends AjaxBehaviorEvent {
	
    private final LatLng latlng;
	private final List<String> addresses;
	
	public ReverseGeocodeEvent(UIComponent component, Behavior behavior, LatLng latlng, List<String> addresses) {
		super(component, behavior);
        this.latlng = latlng;
		this.addresses = addresses;
	}

	@Override
	public boolean isAppropriateListener(FacesListener faceslistener) {
		return (faceslistener instanceof AjaxBehaviorListener);
	}

	@Override
	public void processListener(FacesListener faceslistener) {
		((AjaxBehaviorListener) faceslistener).processAjaxBehavior(this);
	}
    
    public LatLng getLatlng() {
        return latlng;
    }

    public List<String> getAddresses() {
        return addresses;
    }
}

