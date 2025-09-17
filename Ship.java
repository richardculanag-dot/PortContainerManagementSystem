package samokauy;

class Ship {
    String name;
    String captain;

    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    @Override
    public String toString() {
        return name + " | " + "Capt. " + captain;
    }
}