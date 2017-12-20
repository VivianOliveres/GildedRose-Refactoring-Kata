package com.gildedrose

class GildedRose(val items: Array[Item]) {

  private def updateQualityAgedBrie(item: Item): Unit = {
    item.sellIn = item.sellIn - 1

    if (item.quality >= 50)
      Unit // Do nothing
    else if (item.sellIn > 0)
      item.quality = item.quality + 1
    else
      item.quality = item.quality + 2
  }

  private def updateLegendaryItem(item: Item): Unit =
    item.quality = 80

  private def updateBackstagePass(item: Item): Unit = {
    item.sellIn = item.sellIn - 1

    if (item.sellIn >= 10)
      item.quality = item.quality + 1
    else if (item.sellIn >= 5)
      item.quality = item.quality + 2
    else if (item.sellIn > 0)
      item.quality = item.quality + 3
    else
      item.quality = item.quality + 1

    if (item.quality > 50)
      item.quality = 50
  }

  private def updateDefaultItem(item: Item): Unit =
    updateDefaultItem(item, 1)

  private def updateDefaultItem(item: Item, decreaseFactor: Int): Unit = {
    item.sellIn = item.sellIn - 1

    if (item.sellIn > 0)
      item.quality = item.quality - decreaseFactor
    else
      item.quality = item.quality - decreaseFactor * 2

    if (item.quality < 0) item.quality = 0
  }

  private def updateConjured(item: Item): Unit =
    updateDefaultItem(item, 2)

  def updateQuality() =
    items
      .map(ImprovedItems(_))
      .foreach {
        case AgedBrie(item) => updateQualityAgedBrie(item)
        case LegendaryItem(item) => updateLegendaryItem(item)
        case BackstagePass(item) => updateBackstagePass(item)
        case Conjured(item) => updateConjured(item)
        case DefaultItem(item) => updateDefaultItem(item)
      }
}