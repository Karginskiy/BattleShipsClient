package models;

enum ShipValue {

    FourDecked(4), ThreeDecked(3), DoubleDecked(2), SingleDecked(1);
    private int decks;

    ShipValue(int decks) {
        this.decks = decks;
    }

    public int getDecks() {
        return decks;
    }
}
