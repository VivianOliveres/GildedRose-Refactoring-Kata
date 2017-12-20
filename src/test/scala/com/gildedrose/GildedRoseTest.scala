package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers {

  it should "[Aged Brie] increments quality and decrements sellIn" in {
    val itemAgedBrie = new Item("Aged Brie", 123, 15)
    val items = Array[Item](itemAgedBrie)
    val app = new GildedRose(items)

    app.updateQuality()

    itemAgedBrie.sellIn shouldBe 122
    itemAgedBrie.quality shouldBe 16
  }

  it should "[Aged Brie] increments quality by 2 and decrements sellIn when sellIn becomes negative" in {
    val itemAgedBrie = new Item("Aged Brie", 0, 15)
    val items = Array[Item](itemAgedBrie)
    val app = new GildedRose(items)

    app.updateQuality()

    itemAgedBrie.sellIn shouldBe -1
    itemAgedBrie.quality shouldBe 17
  }

  it should "[Aged Brie] does not change quality when sellIn is negative and quality is at least 50" in {
    val itemAgedBrie = new Item("Aged Brie", 0, 50)
    val items = Array[Item](itemAgedBrie)
    val app = new GildedRose(items)

    app.updateQuality()

    itemAgedBrie.sellIn shouldBe -1
    itemAgedBrie.quality shouldBe 50
  }
}