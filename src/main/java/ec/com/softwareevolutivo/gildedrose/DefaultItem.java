package ec.com.softwareevolutivo.gildedrose;

public class DefaultItem extends Item{

    public DefaultItem (String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        decreaseSellIn();
        decreaseQuality();

        if (this.sellIn < 0) {
            decreaseQuality();
        }

    }
}
