package com.gildedrose

sealed trait ImprovedItems {
  val item: Item
  def name = item.name
  def quality = item.quality
  def sellIn = item.sellIn
}

object ImprovedItems {
  def apply(item: Item): ImprovedItems = item.name match {
    case "Sulfuras, Hand of Ragnaros" => LegendaryItem(item)
    case "Backstage passes to a TAFKAL80ETC concert" => BackstagePass(item)
    case "Aged Brie" => AgedBrie(item)
    case "Conjured" => Conjured(item)
    case _ => DefaultItem(item)
  }
}

case class DefaultItem(item: Item) extends ImprovedItems
case class AgedBrie(item: Item) extends ImprovedItems
case class LegendaryItem(item: Item) extends ImprovedItems
case class BackstagePass(item: Item) extends ImprovedItems
case class Conjured(item: Item) extends ImprovedItems
