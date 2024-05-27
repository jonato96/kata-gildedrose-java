package ec.com.softwareevolutivo.gildedrose;

public class Backstage extends Item{

    public Backstage (int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {

        decreaseSellIn();

        increaseQuality();

        if (this.sellIn < 10) {
            increaseQuality();
        }
        if (this.sellIn < 5) {
            increaseQuality();
        }

        if (this.sellIn < 0) {
            resetQuality();
        }
    }
}
