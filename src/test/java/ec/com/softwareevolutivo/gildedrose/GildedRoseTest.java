package ec.com.softwareevolutivo.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item[] arrayWith(Item item) {
        return new Item[]{item};
    }

    @Test
    void foo() {
        Item[] items = new Item[] { new DefaultItem("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }    

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = new DefaultItem("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(9, whateverItem.sellIn);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = new DefaultItem("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(9, whateverItem.quality);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = new DefaultItem("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(8, whateverItem.quality);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = new DefaultItem("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(0, whateverItem.quality);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = new AgedBrie(5, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(2, agedBrie.quality);
    }

    @Test
    public void testAgedBrieIncreasesQualityTwiceWhenSellByPasses() {
        Item agedBrie = new AgedBrie( 0, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(3, agedBrie.quality);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = new AgedBrie(5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = new Sulfuras(0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        assertEquals(25, sulfuras.quality);
        assertEquals(0, sulfuras.sellIn);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThanTen() {
        Item backstagePasses = new Backstage(11, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(21, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerOrEqualsToTen() {
        Item backstagePasses = new Backstage(10, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(22, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerOrEqualsToFive() {
        Item backstagePasses = new Backstage(5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(23, backstagePasses.quality);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = new Backstage(0, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(0, backstagePasses.quality);
    }

    @Test
    public void testConjuredPassLosesQualityDouble() {
        Item conjuredItem = new Conjured(5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(conjuredItem));
        gildedRose.updateQuality();

        assertEquals(18, conjuredItem.quality);
    }

}
