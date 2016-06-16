import de.sergio.stormeye.model.Model.{Ability, Hero, Talent}
import org.rogach.scallop._
import org.json4s._
import org.json4s.native.JsonMethods._

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

  // load the heroes data
  val data: List[Hero] = parse(scala.io.Source.fromFile("src/main/resources/heroes.json").mkString).extract[List[Hero]]

  // save the hero name as a variable
  val heroName: String = opts.hero.get.getOrElse("").toLowerCase()

  // get the hero by name
  val hero = data.find(_.name.toLowerCase == heroName)

  if(opts.info.get.getOrElse(false)) {
    printInfo(hero)
  }

  if(opts.abilities.get.getOrElse(false)) {
    printAbilities(hero.get.abilities)
  }

  if(opts.talents.get.getOrElse(false)) {
    printTalents(hero.get.talents)
  }

  if (opts.builds.get.getOrElse(false)) {
    printBuilds()
  }

  def printInfo(hero: Option[Hero]) = {
    println("\n########################################")
    println(s"Printing info for ${hero.get.name}")
    println("########################################")
    println(hero.getOrElse(""))
    println("\n########################################")
  }

  def printAbilities(abilities: Map[String, List[Ability]]) = {
    abilities.keys.foreach { abilityKey =>

      println("\n########################################")
      println(s"Printing abilities for $abilityKey")
      println("########################################")

      abilities.get(abilityKey).get.foreach { ability =>
        println(ability)
      }
    }
    println("########################################")
  }

  def printTalents(talents: Map[String, List[Talent]]) = {

    talents.toSeq.sortBy(_._1.toInt).foreach { talentTier =>

      println("\n########################################")
      println(s"Printing talent tier ${talentTier._1}")
      println("########################################")

      talentTier._2.foreach(println)
    }

    println("########################################")
  }

  def printBuilds() = {
    println("\n\nBUILDS ARE NOT YET IMPLEMENTED\n\n")
  }
}

