package caketest


sealed case class Widget(widgetname: String)

trait WidgetRepositoryComponent {
  // For expressing dependencies
  def widgetRepository: WidgetRepository

  // Way to obtain the dependency

  trait WidgetRepository {
    // Interface exposed to the user
    def find(widgetname: String): Widget = {
      println("WidgetRepositoryComponent creating Widget: ")
      new Widget("default - wrong")
    }
    def create(widget: Widget) = println("WidgetRepositoryComponent creating Widget: " + widget)
    def delete(widget: Widget) = println("WidgetRepositoryComponent deleting Widget: " + widget)
  }
}

trait WidgetActivationComponent {
    // Dependencies
  this: WidgetRepositoryComponent =>   /** here we specify that WidgetActivationComponentImpl requires *some*
                                           implementation of WidgetRepositoryComponent and also brings
                                           WidgetRepositoryComponent into scope
                                           this: Foo with Bar with Baz => */
  def widgetActivation: WidgetActivation

  trait WidgetActivation {
    def activate(widget: Widget) = println("WidgetActivationComponent activating Widget: " + widget)
  }

}