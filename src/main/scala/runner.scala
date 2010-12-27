package caketest

object runner {
  def main(args: Array[String]) : Unit = {
      val env = new WidgetActivationComponentImpl
            with WidgetRepositoryComponentHibernateImpl

      env.widgetActivation.activate(Widget("w1"));
  }
}