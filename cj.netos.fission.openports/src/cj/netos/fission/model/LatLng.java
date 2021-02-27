package cj.netos.fission.model;

import java.util.Arrays;
import java.util.List;

public class LatLng {
    double longitude;//经度
    double latitude;//纬度

    public LatLng() {
    }

    public LatLng(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public List<Double> toCoordinate() {
        return Arrays.asList(this.longitude, this.latitude);
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }
}
