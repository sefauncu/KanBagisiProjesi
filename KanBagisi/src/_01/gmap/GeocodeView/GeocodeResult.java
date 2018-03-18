package _01.gmap.GeocodeView;

import org.primefaces.model.map.LatLng;

public class GeocodeResult {

    private String address;
    private LatLng latLng;

    public GeocodeResult() {
    }

    public GeocodeResult(String address, LatLng latLng) {
        this.address = address;
        this.latLng = latLng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }  
    
    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
