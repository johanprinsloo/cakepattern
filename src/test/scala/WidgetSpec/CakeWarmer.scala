package caketest.tests

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import caketest._

class CakeWarmer extends FlatSpec with ShouldMatchers {

  "A cake warmer" should "warm it" in {

    val warmer = ComponentRegistry.warmer
     expect("heater.on"){ warmer.trigger  }

  }
}