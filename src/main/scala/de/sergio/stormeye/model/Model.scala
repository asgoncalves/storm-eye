package de.sergio.stormeye.model

object Model {

  object HeroName extends Enumeration {
    type HeroName = Value
    val Abathur, Anubarak, Artanis, Arthas, Azmodan, Brightwing, Chen, Cho, Diablo, ETC, Falstad, Gall, Gazlowe,
    Greymane, Illidan, Jaina, Johanna, Kaelthas, Kerrigan, Kharazim, Leoric, LiLi, LiMing, LtMorales, Lunara,
    Malfurion, Muradin, Murky, Nazeebo, Nova, Raynor, Rehgar, Rexxar, SgtHammer, Sonya, Stiches, Sylvanas, Tassadar,
    TheButcher, TheLostVikings, Thrall, Tychus, Tyrael, Tyrande, Uther, Valla, Xul, Zagara, Zeratul = Value
  }

  object Universe extends Enumeration {
    type Universe = Value
    val Classic, Starcraft, Diablo, Warcraft = Value
  }

  object Key extends Enumeration {
    type Key = Value
    val Q, W, E, D, R = Value
  }

  case class Hero(name: HeroName.Value, universe: Universe.Value, combatTrait: Ability, abilities: List[Ability],
                  secondaryAbilities: Option[List[Ability]] = None, heroicAbilities: List[Ability],
                  specialMount: Option[Ability] = None, talentTree: List[Talent], builds: Option[List[Build]] = None)
  case class Ability(name: String, description: String, key: Option[Key.Value] = None, mana: Int, cooldown: Int)
  case class Talent(tier: Int, name: String, description: String)
  case class Build(order: Int, talents: List[Talent], comments: Option[String] = None)

}
