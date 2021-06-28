package resources;

public enum DriverType {

	IE("Internet Explorer"),
	Chrome("Chrome"),
	FireFox("FireFox");
	
	private final String value;

    DriverType(final String newValue) {
        value = newValue;
    }

    public String getValue() { return value; }
}

