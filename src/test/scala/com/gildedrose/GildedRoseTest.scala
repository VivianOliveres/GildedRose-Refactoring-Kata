package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FlatSpec with Matchers {

  it should "AnyItem decrements quality and decrements sellIn" in {
    val item = new Item("SomeItem", 123, 15)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 122
    item.quality shouldBe 14
  }

  it should "AnyItem decrements quality by 2 and decrements sellIn when sellIn becomes negative" in {
    val item = new Item("SomeItem", 0, 15)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe -1
    item.quality shouldBe 13
  }

  it should "AnyItem should never have a negative quality" in {
    val item = new Item("SomeItem", 0, 0)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe -1
    item.quality shouldBe 0
  }

  it should "[Aged Brie] increments quality and decrements sellIn" in {
    val item = new Item("Aged Brie", 123, 15)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 122
    item.quality shouldBe 16
  }

  it should "[Aged Brie] increments quality by 2 and decrements sellIn when sellIn becomes negative" in {
    val item = new Item("Aged Brie", 0, 15)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe -1
    item.quality shouldBe 17
  }

  it should "[Aged Brie] does not change quality when sellIn is negative and quality is at least 50" in {
    val item = new Item("Aged Brie", 0, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe -1
    item.quality shouldBe 50
  }

  it should "[Sulfuras] does not change quality neither sellIn" in {
    val item = new Item("Sulfuras, Hand of Ragnaros", 123, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 123
    item.quality shouldBe 50
  }

}