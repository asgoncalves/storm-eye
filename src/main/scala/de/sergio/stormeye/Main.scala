import de.sergio.stormeye.model.Model.{Ability, Build, Hero, Talent}
import org.rogach.scallop._
import org.json4s._
import org.json4s.native.JsonMethods._
import de.sergio.stormeye.utils.Presentation._

object Main extends App with DefaultFormats {

  implicit val formats = DefaultFormats

  val opts = new ScallopConf(args) {

    banner( """
        |Storm Eye v0.1
        |
        |Simple command line interface for information about heroes of the storm.
        |Configure your own builds for your favorite heroes and quickly visualize them when needed.
        |
        |Usage example:
        |   run --abilities stitches
        |
        |""".stripMargin)

    val hero = trailArg[String]("hero", descr = "The hero you want to get info about", required = true)
    val info = opt[Boolean]("info", short = 'i', descr = "Shows the hero's info")
    val abilities = opt[Boolean]("abilities", short = 'a', descr = "Shows the hero's abilities")
    val talents = opt[Boolean]("talents", short = 't', descr = "Shows the hero's talents")
    val builds = opt[Boolean]("builds", short = 'b', descr = "Shows the hero's builds")
    val help = opt[Boolean]("help", noshort = true, descr = "Show this message")
  }

  // save the hero name as a variable
  val heroName: String = opts.hero.get.getOrElse("").toLowerCase()

  // load the heroes data
  val heroesData: List[Hero] = parse(scala.io.Source.fromFile("src/main/resources/heroes.json").mkString).extract[List[Hero]]

  // load the heroes builds
  val buildsData: List[Build] = parse(scala.io.Source.fromFile("src/main/resources/builds.json").mkString).extract[List[Build]]

  // full data
  val heroesFullData: List[Hero] = heroesData map { hero =>
    hero.copy(builds = Some(buildsData.filter(_.hero.equalsIgnoreCase(heroName))))
  }

  // get the hero by name
  val hero = heroesFullData.find(_.name.toLowerCase == heroName)

  if(opts.info.get.getOrElse(false)) {
    printInfo(hero.get)
  }

  if(opts.abilities.get.getOrElse(false)) {
    printAbilities(hero.get.abilities)
  }

  if(opts.talents.get.getOrElse(false)) {
    printTalents(hero.get.talents)
  }

  if (opts.builds.get.getOrElse(false)) {
    printBuilds(hero.get.builds.get)
  }
}