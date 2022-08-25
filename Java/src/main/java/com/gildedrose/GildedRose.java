package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case "Aged Brie":
                    item = updateQualityAgedBrie(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    item = updateQualitySulfuras(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item = updateQualityBackstagePass(item);
                    break;
                case "Normal":
                    item = updateQualityNormal(item);
                    break;
                default:
                    if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.sellIn < 11) {
                                    if (item.quality < 50) {
                                        item.quality = item.quality + 1;
                                    }
                                }

                                if (item.sellIn < 6) {
                                    if (item.quality < 50) {
                                        item.quality = item.quality + 1;
                                    }
                                }
                            }
                        }
                    }

                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.sellIn = item.sellIn - 1;
                    }

                    if (item.sellIn < 0) {
                        if (!item.name.equals("Aged Brie")) {
                            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                                if (item.quality > 0) {
                                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                        item.quality = item.quality - 1;
                                    }
                                }
                            } else {
                                item.quality = item.quality - item.quality;
                            }
                        } else {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
            }
        }
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

    private Item updateQualitySulfuras(Item item) {
        return item;
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
}
