package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

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
