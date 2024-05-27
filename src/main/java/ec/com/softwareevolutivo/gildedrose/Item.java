package ec.com.softwareevolutivo.gildedrose;

abstract class Item {

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public abstract void updateQuality();

    void decreaseSellIn() {
        this.sellIn -= 1;
    }

    void increaseQuality() {
        if (this.quality < MAX_QUALITY) {
            this.quality += 1;
        }
    }

    void decreaseQuality() {
        if (this.quality > MIN_QUALITY) {
            this.quality -= 1;
        }
    }

    void resetQuality() {
        this.quality = 0;
    }

}
