package caketest.tests

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import caketest._

class StructSpec extends FlatSpec with ShouldMatchers {

  "A warmer" should "warm it" in {
     val cl = new Client(Config)
  }
}