import sbt._

class JRubyPluginProject(info: ProjectInfo) extends PluginProject(info) {
  val jruby = "org.jruby" % "jruby-complete" % "1.5.6"
}
