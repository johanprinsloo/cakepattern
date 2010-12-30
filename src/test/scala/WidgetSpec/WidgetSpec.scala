package caketest.tests

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

import caketest._

class WidgetSpec extends FlatSpec with ShouldMatchers {

  "A H Widget" should "bind to the hibernate interfaces at run time" in {
    val env = new WidgetActivationComponentImpl
      with WidgetRepositoryComponentHibernateImpl

    env.widgetActivation.activate(Widget("w1"));
  }

    "A file based Widget " should "bind to the file interfaces at run time" in {
    val env = new WidgetActivationComponentImpl
      with WidgetRepositoryComponentFileImpl

    env.widgetActivation.activate(Widget("w2"));
  }

    "A alternative file based Widget" should "bind to the file interfaces at run time" in {
    val env = new WidgetActivationComponentImpl2
      with WidgetRepositoryComponentFileImpl

    env.widgetActivation.activate(Widget("w3"));
  }

}