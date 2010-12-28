package caketest


sealed case class Widget(widgetname: String)

trait WidgetRepositoryComponent {
  // For expressing dependencies
  def widgetRepository: WidgetRepository

  // Way to obtain the dependency

  trait WidgetRepository {
    // Interface exposed to the user
    def find(widgetname: String): Widget
    def create(widget: Widget) = println("creating Widget: " + widget)
    def delete(widget: Widget) = println("deleting Widget: " + widget)
  }
}

trait WidgetActivationComponent {
  def widgetActivation: WidgetActivation

  trait WidgetActivation {
    def activate(widget: Widget)
  }

}