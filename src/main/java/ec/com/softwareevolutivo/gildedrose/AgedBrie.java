package ec.com.softwareevolutivo.gildedrose;

public class AgedBrie extends Item{

    public AgedBrie (int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality(){

        decreaseSellIn();

        increaseQuality();

        if (this.sellIn < 0) {
            increaseQuality();
        }
    }

}
