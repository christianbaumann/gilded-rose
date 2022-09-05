package com.gildedrose;

class GildedRose {
    Item item;

    public GildedRose(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        switch (item.name) {
            case "Aged Brie":
                item = updateQualityAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                item = updateQualityBackstagePass(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                item = updateQualitySulfuras(item);
                break;
            default:
                item = updateQualityNormal(item);
        }
    }

    private Item updateQualityAgedBrie(Item item) {
        item.sellIn--;

        if (item.quality >= 50) {
            return item;
        }

        item.quality++;
        if (item.quality >= 50) {
            return item;
        }

        if (item.sellIn <= 0) {
            item.quality++;
        }

        return item;
    }

    private Item updateQualityBackstagePass(Item item) {
        item.sellIn--;

        if (item.quality >= 50) {
            return item;
        }

        if (item.sellIn < 0) {
            item.quality = 0;
            return item;
        }

        item.quality++;
        if (item.quality >= 50) {
            return item;
        }

        if (item.sellIn < 10) {
            item.quality++;
        }
        if (item.quality >= 50) {
            return item;
        }

        if (item.sellIn < 5) {
            item.quality++;
        }
        if (item.quality >= 50) {
            return item;
        }

        return item;
    }

    private Item updateQualityNormal(Item item) {
        item.sellIn--;

        if (item.quality == 0) {
            return item;
        }

        item.quality--;

        if (item.sellIn <= 0) {
            item.quality--;
        }

        return item;
    }

    private Item updateQualitySulfuras(Item item) {
        return item;
    }
}
