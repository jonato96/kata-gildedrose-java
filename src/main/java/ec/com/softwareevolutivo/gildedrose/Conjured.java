package ec.com.softwareevolutivo.gildedrose;

public class Conjured extends Item{

    public Conjured (int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    @Override
    public void updateQuality() {

        decreaseSellIn();

        decreaseQuality();
        decreaseQuality();

    }
}
