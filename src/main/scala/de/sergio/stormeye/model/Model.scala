package de.sergio.stormeye.model

object Model {
  case class Hero(id: String, name: String, title: String, description: String, role: String, `type`: String, gender: String, franchise: String, difficulty: String, abilities: Map[String, List[Ability]], talents: Map[String, List[Talent]]) {
    override def toString(): String = {
      "\nID: \t\t" + id +
      "\nName: \t\t" + name +
      "\nTitle: \t\t" + title +
      "\nDescription: \t" + description +
      "\nRole: \t\t" + role +
      "\nType: \t\t" + `type` +
      "\nGender: \t" + gender +
      "\nFranchise: \t" + franchise +
      "\nDifficulty: \t" + difficulty
    }
  }

  case class Ability(id: String, manaCost: Option[Int], name: String, description: String, cooldown: Option[Int], shortcut: Option[String]) {
    override def toString(): String = {
      "\nID: \t\t" + id +
        "\nName: \t\t" + name +
        "\nDescription: \t" + description +
        "\nMana cost: \t" + manaCost.getOrElse(0) +
        "\nCooldown: \t" + cooldown.getOrElse(0) +
        "\nShortcut: \t" + shortcut.getOrElse("None")
    }
  }

  case class Talent(id: String, name: String, description: String, cooldown: Option[Int]) {
    override def toString(): String = {
      "\nID: \t\t" + id +
        "\nName: \t\t" + name +
        "\nDescription: \t" + description +
        "\nCooldown: \t" + cooldown.getOrElse("NA")
    }
  }
}
