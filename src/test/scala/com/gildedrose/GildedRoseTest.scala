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

  it should "[BackstagePass] does not change quality when sellIn is higher than 10" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 123, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 122
    item.quality shouldBe 50
  }


  it should "[BackstagePass] increase quality by 1 when sellIn is higher than 10" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 35)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 10
    item.quality shouldBe 36
  }

  it should "[BackstagePass] increase quality by 2 when sellIn is between 5 and 10" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 35)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 9
    item.quality shouldBe 37
  }

  it should "[BackstagePass] increase quality by 3 when sellIn is between 1 and 5" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 4
    item.quality shouldBe 38
  }

  it should "[BackstagePass] does not change quality when quality is >= 50 and sellIn is higher than 10" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 10
    item.quality shouldBe 50
  }

  it should "[BackstagePassdoes not change quality when quality is >= 50 and sellIn is between 5 and 10" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 9
    item.quality shouldBe 50
  }

  it should "[BackstagePass] does not change quality when quality is >= 50 and sellIn is between 1 and 5" in {
    val item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)
    val items = Array[Item](item)
    val app = new GildedRose(items)

    app.updateQuality()

    item.sellIn shouldBe 4
    item.quality shouldBe 50
  }

}