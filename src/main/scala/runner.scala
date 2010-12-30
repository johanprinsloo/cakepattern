package caketest

object runner {
  def main(args: Array[String]): Unit = {
    val env = new WidgetActivationComponentImpl
      with WidgetRepositoryComponentHibernateImpl

    env.widgetActivation.activate(Widget("w1"));

    val cl = new Client(Config)

    val warmer = ComponentRegistry.warmer
    warmer.trigger

  }
}