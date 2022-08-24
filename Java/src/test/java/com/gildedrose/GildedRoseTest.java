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
