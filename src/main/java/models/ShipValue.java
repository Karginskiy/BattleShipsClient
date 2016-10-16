package models;

public enum ShipValue {

    FourDecked(4), ThreeDecked(3), DoubleDecked(2), SingleDecked(1), Shot(0);
    private int decks;

    ShipValue(int decks) {
        this.decks = decks;
    }

    public int getDecks() {
        return decks;
    }
}
