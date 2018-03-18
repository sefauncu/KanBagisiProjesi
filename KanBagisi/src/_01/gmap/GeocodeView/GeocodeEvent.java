package _01.gmap.GeocodeView;


import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;


public class GeocodeEvent extends AjaxBehaviorEvent {
	
    private final String query;
	private final List<GeocodeResult> results;
	
	public GeocodeEvent(UIComponent component, Behavior behavior, String query, List<GeocodeResult> results) {
		super(component, behavior);
        this.query = query;
        this.results = results;
	}

	@Override
	public boolean isAppropriateListener(FacesListener faceslistener) {
		return (faceslistener instanceof AjaxBehaviorListener);
	}

	@Override
	public void processListener(FacesListener faceslistener) {
		((AjaxBehaviorListener) faceslistener).processAjaxBehavior(this);
	}

    public String getQuery() {
        return query;
    }

    public List<GeocodeResult> getResults() {
        return results;
    }
}