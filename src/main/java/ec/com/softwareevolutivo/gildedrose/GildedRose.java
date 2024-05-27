package ec.com.softwareevolutivo.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private final String AGED = "Aged Brie";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros"; //this case doesnt need changes
    private final String CONJURED = "Conjured";

    public void updateQuality() {
        for (Item item : items) {            
            if (item.name.equals(AGED)) {
                updateAged(item);
                continue;
            }
            if (item.name.equals(BACKSTAGE)) {
                updateBackStage(item);
                continue;
            }
            if (item.name.equals(SULFURAS)) {                
                continue;
            }
            if (item.name.equals(CONJURED)) {
                updateConjured(item);
                continue;
            }
            if (item.name.equals(AGED)) {
                updateAged(item);
                continue;
            }
            updateNormal(item);
        }  
    }

    private void updateAged(Item item) {        
        if (item.quality < 50) {
            item.quality = item.quality + 1;           
        }
        item.sellIn -= 1;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality += 1;
        }
    }

    private void updateBackStage (Item item) {        
        if (item.quality < 50) {
            item.quality = item.quality + 1;            
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality += 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality += 1;
            }            
        }
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality -= item.quality;
        }
    }    

    private void updateNormal(Item item) {        
        if (item.quality > 0) {
            item.quality -= 1;
        }
        item.sellIn -= 1;
        if (item.sellIn < 0 && item.quality > 0) {                        
            item.quality -= 1;                        
        }         
    }

    private void updateConjured(Item item) {        
        if (item.quality > 0) {                
                item.quality -= 2;                                        
        }
        item.sellIn -= 1;       
        if (item.sellIn < 0 && item.quality > 0) {                                   
            item.quality -= 1;                    
        }             
    }    

}
