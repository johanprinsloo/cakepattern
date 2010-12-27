`package caketest.tests

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import caketest._

class WidgetSpec extends FlatSpec with ShouldMatchers {

  "A Widget" should "bind to the correct interfaces at run time" in {
    val env = new WidgetActivationComponentImpl
      with WidgetRepositoryComponentHibernateImpl

    env.widgetActivation.activate(Widget("w1"));
  }

}