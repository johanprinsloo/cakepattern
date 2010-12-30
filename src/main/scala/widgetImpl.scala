package caketest

trait WidgetRepositoryComponentHibernateImpl
  extends WidgetRepositoryComponent {
  def widgetRepository = new WidgetRepositoryImpl

  class WidgetRepositoryImpl extends WidgetRepository {
    override def find(widgetname: String): Widget = {
      println("Find with Hibernate: " + widgetname)
      new Widget(widgetname)
    }
  }
}

trait WidgetRepositoryComponentFileImpl
  extends WidgetRepositoryComponent {
  def widgetRepository = new WidgetRepositoryImpl

  class WidgetRepositoryImpl extends WidgetRepository {
    override def find(widgetname: String): Widget = {
      println("Find with Filesys: " + widgetname)
      new Widget(widgetname)
    }
  }
}

// Component implementation
trait WidgetActivationComponentImpl extends WidgetActivationComponent {

  // Dependencies
  this: WidgetRepositoryComponent =>   /** here we specify that WidgetActivationComponentImpl requires *some*
                                           implementation of WidgetRepositoryComponent and also brings
                                           WidgetRepositoryComponent into scope
                                           this: Foo with Bar with Baz => */

  def widgetActivation = new WidgetActivationImpl

  class WidgetActivationImpl extends WidgetActivation {
    override def activate(widget: Widget) {
      println("Activating impl 1 " + widget.widgetname)
      // Obtaining the dependency and calling a method on it
      widgetRepository.find(widget.widgetname)
    }
  }
}

// Component implementation
trait WidgetActivationComponentImpl2 extends WidgetActivationComponent {

  this: WidgetRepositoryComponent =>

  def widgetActivation = new WidgetActivationImpl

  class WidgetActivationImpl extends WidgetActivation {
    override def activate(widget: Widget) {
      println("Activating impl 2 " + widget.widgetname)
      // Obtaining the dependency and calling a method on it
      widgetRepository.find(widget.widgetname)
    }
  }
}