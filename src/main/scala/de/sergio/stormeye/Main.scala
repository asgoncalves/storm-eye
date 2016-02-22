import org.rogach.scallop._;
import de.sergio.stormeye.model.Model._;
import de.sergio.stormeye.model.Model.HeroName._;
import de.sergio.stormeye.model.Model.Universe._;

object Main extends App {

  val opts = new ScallopConf(args) {

    banner(
      """
        |Storm Eye v0.1
        |
        |Simple command line interface for information about heroes of the storm.
        |Configure your own builds for your favorite heroes and quickly visualize them when needed.
        |
        |Usage example:
        |   run -h stiches -b tank
        |
        |""".stripMargin)

    val hero = trailArg[String]("hero", descr = "The hero you want to get info about")
    val build = opt[String]("build", descr = "The build name you want")
    val help = opt[Boolean]("help", noshort = true, descr = "Show this message")

  }

  // val stiches = Hero(Stiches, Warcraft, List(Build(1, List(Talent(1, "tst1", "tst1desc"), Talent(2, "tst2", "tst2desc"), Talent(3, "tst3", "tst3desc"), Talent(4, "tst4", "tst4desc")))))
  // println(stiches.builds.head)
  println(opts.hero())

}
