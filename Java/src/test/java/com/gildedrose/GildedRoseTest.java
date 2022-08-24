package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testAgedBrieQualityIncreasesBeforeSellinExpired() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 5, 10),
            new Item("Aged Brie", 1, 12),
            new Item("Aged Brie", 0, 14)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(13, app.items[1].quality);

        assertEquals("Aged Brie", app.items[2].name);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(16, app.items[2].quality);
    }

    @Test
    void testAgedBrieQualityIncreasesAfterSellinExpired() {
        Item[] items = new Item[]{
            new Item("Aged Brie", -1, 16),
            new Item("Aged Brie", -5, 18)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);

        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(-6, app.items[1].sellIn);
        assertEquals(20, app.items[1].quality);
    }

    @Test
    void testAgedBrieQualityNotGreater50() {
        Item[] items = new Item[]{
            new Item("Aged Brie", 17, 49),
            new Item("Aged Brie", 4711, 50),
            new Item("Aged Brie", -3, 48),
            new Item("Aged Brie", -666, 49),
            new Item("Aged Brie", -123, 50)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(16, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(4710, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("Aged Brie", app.items[2].name);
        assertEquals(-4, app.items[2].sellIn);
        assertEquals(50, app.items[2].quality);

        assertEquals("Aged Brie", app.items[3].name);
        assertEquals(-667, app.items[3].sellIn);
        assertEquals(50, app.items[3].quality);

        assertEquals("Aged Brie", app.items[4].name);
        assertEquals(-124, app.items[4].sellIn);
        assertEquals(50, app.items[4].quality);
    }

    @Test
    void testSulfurasQualityIncreasesBeforeSellinExpired() {
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 5, 10),
            new Item("Sulfuras, Hand of Ragnaros", 1, 12),
            new Item("Sulfuras, Hand of Ragnaros", 0, 14)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(1, app.items[1].sellIn);
        assertEquals(12, app.items[1].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(14, app.items[2].quality);
    }

    @Test
    void testSulfurasQualityIncreasesAfterSellinExpired() {
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", -1, 16),
            new Item("Sulfuras, Hand of Ragnaros", -5, 18)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(-5, app.items[1].sellIn);
        assertEquals(18, app.items[1].quality);
    }

    @Test
    void testNormalQualityIncreasesBeforeSellinExpired() {
        Item[] items = new Item[]{
            new Item("Normal", 5, 10),
            new Item("Normal", 1, 12),
            new Item("Normal", 0, 14)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);

        assertEquals("Normal", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(11, app.items[1].quality);

        assertEquals("Normal", app.items[2].name);
        assertEquals(-1, app.items[2].sellIn);
        assertEquals(12, app.items[2].quality);
    }

    @Test
    void testNormalQualityIncreasesAfterSellinExpired() {
        Item[] items = new Item[]{
            new Item("Normal", -1, 16),
            new Item("Normal", -5, 18)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(14, app.items[0].quality);

        assertEquals("Normal", app.items[1].name);
        assertEquals(-6, app.items[1].sellIn);
        assertEquals(16, app.items[1].quality);
    }

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testNormalItemBeforeSellDate() {
        Item[] items = new Item[]{new Item("normal", 10, 5)};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("normal", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

}
