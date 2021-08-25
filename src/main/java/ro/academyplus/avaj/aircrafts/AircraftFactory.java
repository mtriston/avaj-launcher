package ro.academyplus.avaj.aircrafts;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.exceptions.InvalidAircraftTypeException;
import ro.academyplus.avaj.exceptions.IllegalCoordinatesException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (longitude <= 0 || latitude <= 0 || height < 0 || height > 100) {
            throw new IllegalCoordinatesException(String.format("%d %d %d", longitude, latitude, height));
        }
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equalsIgnoreCase("helicopter") || type.equalsIgnoreCase(getHash("Helicopter")))
            return new Helicopter(name, coordinates);
        if (type.equalsIgnoreCase("jetplane") || type.equalsIgnoreCase(getHash("JetPlane")))
            return new JetPlane(name, coordinates);
        if (type.equalsIgnoreCase("baloon") || type.equalsIgnoreCase(getHash("Baloon")))
            return new Baloon(name, coordinates);
        throw new InvalidAircraftTypeException(type);
    }

    private static String getHash(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
        md.update(str.getBytes());
        return byteArrayToHex(md.digest());
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b : a)
           sb.append(String.format("%02x", b));
        return sb.toString();
     }
}
