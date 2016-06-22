package de.sergio.stormeye.utils

import de.sergio.stormeye.model.Model.{Ability, Build, Hero, Talent}

/**
  * Created by sgoncalves on 21/06/16.
  */
object Presentation {

  def printLogo() = {
    "\n  _________ __                       ___________             \n" +
      " /   _____//  |_  ___________  _____ \\_   _____/__.__. ____  \n" +
      " \\_____  \\\\   __\\/  _ \\_  __ \\/     \\ |    __)<   |  |/ __ \\ \n" +
      " /        \\|  | (  <_> )  | \\/  Y Y  \\|        \\___  \\  ___/ \n" +
      "/_______  /|__|  \\____/|__|  |__|_|  /_______  / ____|\\___  > v0.1\n" +
      "        \\/                         \\/        \\/\\/         \\/"
  }

  def printInfo(hero: Hero) = {

    println(printLogo)
    println("\n################################################################################")
    println(s"Printing info for ${hero.name}")
    println("################################################################################")
    println(hero)
    println("\n################################################################################\n")
  }

  def printAbilities(abilities: Map[String, List[Ability]]) = {

    println(printLogo)
    abilities.keys.foreach { abilityKey =>

      println("\n################################################################################")
      println(s"Printing abilities for $abilityKey")
      println("################################################################################")

      abilities.get(abilityKey).get.foreach { ability =>
        println(ability)
      }
    }
    println("\n################################################################################\n")
  }

  def printTalents(talents: Map[String, List[Talent]]) = {

    println(printLogo)
    talents.toSeq.sortBy(_._1.toInt).foreach { talentTier =>

      println("\n################################################################################")
      println(s"Printing talent tier ${talentTier._1}")
      println("################################################################################")
      talentTier._2.foreach(println)
      println("\n################################################################################\n")
    }
  }

  // TODO
  def printBuilds(builds: List[Build]) = {
    println(printLogo)
    builds.foreach(println)
  }
}
