package net.lockney

import sbt._

import org.jruby.embed.ScriptingContainer

trait JRubyPlugin extends Project {

  lazy val execRuby = execRubyAction

  lazy val jrubyHome = System.getenv("JRUBY_HOME")

  def execRubyAction = task { args =>
    if (jrubyHome == null || jrubyHome.isEmpty)
      task { Some("You must set JRUBY_HOME before running this task") }
    else if (args.length < 1) task { Some("Usage: execRuby 'scriptlet'") }
    else
      execRubyTask(args(0))
  }.describedAs("Executes a Ruby scriptlet")

  def execRubyTask(scriptlet: String) = task {
    val container = new ScriptingContainer()
    container.runScriptlet(scriptlet)
    None
  }

}
