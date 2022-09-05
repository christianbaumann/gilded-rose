package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private Item item;

    @Test
    void testAgedBrieQualityIncreasesBy1BeforeSellinExpired() {
        item = new Item("Aged Brie", 5, 10);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(11, app.item.quality);
    }

    @Test
    void testAgedBrieQualityIncreasesBy2WhenSellinIs0() {
        item = new Item("Aged Brie", 1, 12);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(0, app.item.sellIn);
        assertEquals(14, app.item.quality);
    }

    @Test
    void testAgedBrieQualityIncreasesBy2WhenSellinIsMinus1() {
        item = new Item("Aged Brie", -1, 16);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(-2, app.item.sellIn);
        assertEquals(18, app.item.quality);
    }

    @Test
    void testAgedBrieQualityIncreasesBy2WhenSellinIsMinus5() {
        item = new Item("Aged Brie", -5, 18);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(-6, app.item.sellIn);
        assertEquals(20, app.item.quality);
    }

    @Test
    void testAgedBrieQualityNotGreater50Sellin17() {
        item = new Item("Aged Brie", 17, 49);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(16, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testAgedBrieQualityNotGreater50SellIn4711() {
        item = new Item("Aged Brie", 4711, 50);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(4710, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testAgedBrieQualityNotGreater50SellinMinus3() {
        item = new Item("Aged Brie", -3, 48);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(-4, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testAgedBrieQualityNotGreater50SellinMinus666() {
        item = new Item("Aged Brie", -666, 49);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Aged Brie", app.item.name);
        assertEquals(-667, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void SulfurasDoesNotChangeQualitySellin5() {
        item = new Item("Sulfuras, Hand of Ragnaros", 5, 10);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name);
        assertEquals(5, app.item.sellIn);
        assertEquals(10, app.item.quality);
    }

    @Test
    void SulfurasDoesNotChangeQualitySellin1() {
        item = new Item("Sulfuras, Hand of Ragnaros", 1, 12);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name);
        assertEquals(1, app.item.sellIn);
        assertEquals(12, app.item.quality);
    }

    @Test
    void SulfurasDoesNotChangeQualitySellin0() {
        item = new Item("Sulfuras, Hand of Ragnaros", 0, 14);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name);
        assertEquals(0, app.item.sellIn);
        assertEquals(14, app.item.quality);
    }

    @Test
    void SulfurasDoesNotChangeQualitySellinMinus1() {
        item = new Item("Sulfuras, Hand of Ragnaros", -1, 16);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name);
        assertEquals(-1, app.item.sellIn);
        assertEquals(16, app.item.quality);
    }

    @Test
    void SulfurasDoesNotChangeQualitySellinMinus5() {
        item = new Item("Sulfuras, Hand of Ragnaros", -5, 18);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.item.name);
        assertEquals(-5, app.item.sellIn);
        assertEquals(18, app.item.quality);
    }

    @Test
    void testNormalQualityDoesNotGoBelow0() {
        item = new Item("Normal", 5, 0);

        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testNormalQualityIncreasesBeforeSellinExpired() {
        item = new Item("Normal", 5, 10);

        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(9, app.item.quality);
    }

    @Test
    void testNormalQualityDecreasesBy2AtSellinMinus1() {
        item = new Item("Normal", -1, 16);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(-2, app.item.sellIn);
        assertEquals(14, app.item.quality);
    }

    @Test
    void testNormalQualityDecreasesBy2AtSellinMinus5() {
        item = new Item("Normal", -5, 18);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(-6, app.item.sellIn);
        assertEquals(16, app.item.quality);
    }

    @Test
    void testNormalQualityDecreasesBy2AtSellin0() {
        item = new Item("Normal", 0, 14);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(-1, app.item.sellIn);
        assertEquals(12, app.item.quality);
    }

    @Test
    void testNormalQualityDecreasesBy2AtSellin1() {
        item = new Item("Normal", 1, 12);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Normal", app.item.name);
        assertEquals(0, app.item.sellIn);
        assertEquals(10, app.item.quality);
    }

    @Test
    void testBackstagePass10Days0() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(10, app.item.sellIn);
        assertEquals(4, app.item.quality);
    }

    @Test
    void testBackstagePass10Days1() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 4);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(9, app.item.sellIn);
        assertEquals(6, app.item.quality);
    }

    @Test
    void testBackstagePass10Days2() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5);

        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(8, app.item.sellIn);
        assertEquals(7, app.item.quality);
    }

    @Test
    void testBackstagePass5Days0() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 6);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(5, app.item.sellIn);
        assertEquals(8, app.item.quality);
    }

    @Test
    void testBackstagePass5Days1() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 7);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(10, app.item.quality);
    }

    @Test
    void testBackstagePass5Days2() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 8);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(3, app.item.sellIn);
        assertEquals(11, app.item.quality);
    }

    @Test
    void testBackstagePassAfterTheConcert0() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 9);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(0, app.item.sellIn);
        assertEquals(12, app.item.quality);

    }

    @Test
    void testBackstagePassAfterTheConcert1() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(-1, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testBackstagePassAfterTheConcert2() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 11);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(-2, app.item.sellIn);
        assertEquals(0, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_0() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 48);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(9, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_1() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(9, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_2() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(9, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_3() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_4() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_5() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }

    @Test
    void testBackstagePassQualityNotGreater50_6() {
        item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        GildedRose app = new GildedRose(item);

        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.item.name);
        assertEquals(4, app.item.sellIn);
        assertEquals(50, app.item.quality);
    }
}
