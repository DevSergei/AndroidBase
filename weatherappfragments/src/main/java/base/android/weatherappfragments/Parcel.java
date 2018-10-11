package base.android.weatherappfragments;

import java.io.Serializable;

public class Parcel implements Serializable {

    private boolean showHumidity;
    private boolean showPressure;
    private boolean showWind;
    private String cityName;

    public Parcel(boolean showHumidity, boolean showPressure, boolean showWind, String cityName) {
        this.showHumidity = showHumidity;
        this.showPressure = showPressure;
        this.showWind = showWind;
        this.cityName = cityName;
    }

    public boolean isShowHumidity() {
        return showHumidity;
    }

    public boolean isShowPressure() {
        return showPressure;
    }

    public boolean isShowWind() {
        return showWind;
    }

    public String getCityName() {
        return cityName;
    }

    public void setShowHumidity(boolean showHumidity) {
        this.showHumidity = showHumidity;
    }

    public void setShowPressure(boolean showPressure) {
        this.showPressure = showPressure;
    }

    public void setShowWind(boolean showWind) {
        this.showWind = showWind;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
