# Sci-Fi Skirmish
### A Minecraft plugin.

This is a minecraft plugin, currently for the minecraft version 1.20.1
___
	First of all: This is my first project in Java ever, so it can't 
	be perfect in any regard, and I know there are a lot of issues, 
	especially regarding OOP. But I am always open for feedback 
	since I am currently still learning, also learning java
---

## Table of Contents:
#### Introductory Part <br>
[0. Plugin Inspiration](#the-inspiration-and-what-the-plugin-is-for-overall) - Short overview over my Inspiration and Ideas for this plugin <br>
#### Main Part Contents <br>
[1. The PvP-System](#u1-the-pvp-systemu) - Short explanation of the PvP-System  and why it is interesting <br> 
[2. The Ecosystem](#u2-the-ecosystemu) - The Eco- and Cratesystem with short examples <br>
[3. The Commands](#u3-the-commandsu) - The command names and their usages <br>
[4. The Specialitems](#u4-the-specialitemsu) - Short explanation for the plugins specialitems <br>
#### Summary & note of thanks <br>
[So all in all...](#uso-all-in-allu) - a short summary of everything <br>
[Note of thanks](#summary--note-of-thanks-br) - <3 <br>
## The inspiration and what the plugin is for overall...

This plugins Idea is heavily inspired by an former gamemode on the German ``Mixelpixel.net`` network, called *"WesternWars"*
> **What was Westernwars?**
> 
> WesternWars was a gamemode which, throughout its whole existence, has been in its Beta phase. The interesting part of
> WesternWars actually came through a bug, which "broke" the PvP-System in an interesting way. 
> Because when you had full ``Protection IV`` armor, you didn't actually take damage from hits, which made PvP Interesting.
> Also it had an own ecosystem where resources where providet throughout crates. 
> 
> The most valuable recourse has been XP and Mending books, because of the bug it was more important to keep your armor
> alive and don't get it to break.
> 
> This was a really shot breakdown on what WesternWars was, hopefully it is kind of understandable now.

### So what is 'Sci-Fi Skirmish' about then?
My main goal with this project is not, to copy the gamemode as it was before, but to show what potential was lying in it.
I want to see what could've been made of 'WesternWars'. And also, because this is my first "big" project in coding ever, and also with java,
I thought that it was a good and simple mode and way to train coding and learn about it.

***And Huge Thangs to Monty, the owner of Mixelpixel, who allowed to use the basic ideas of Westernwars to create something off of it!***

---
## So what does this plugin do then (Overview)?
### <u>1. The PvP-System</u>
As already mentioned earlier in this post, the PvP-System heavily relies on the bug, that made WesternWars so interesting for its
players.
So the clue of this system is, that you have to have a full Protection 4 Armor in order to recieve no-Damage. In that way longer fights can develop
and players can make more mistakes without Dying of right after.

This tolerance to mistakes made the Gamemode interesting for "PvP OG's" but also for "Newbies".
So the PvP System relies on this core mechanic, and then on Bonuses like Potion Effects, Perks and so on.

> ### What Perks are there and how to they Influence PvP?
> <u> **a. Perks with direct influence in a fight** </u>
> 
> Perks that have a direct on the influence on the fight are perks, that affect the damage players do to armor and players. Also they affect Things like mobility or 
> vision, agility and the usage of certain items.
> 
> *In this plugin for example, there are perks affecting combat like an archer perk, or also a perk, which uses high risk/high reward to give
> a benefit to players*
> 
> <u> **b. Perks that influence a fight indirectly** </u>
>
> Perks influencing fights indirectly are mostly perks, that provide the player who has them some kind of advantage throughout information about 
> its opponent. So for example about stuff lying in their inventory.
> 
> *Right know there is only one such perk, but this actually provides a whole own, new, feature.*
> 
> >To get to know more about perks read more about them below, there you can find a detailed explanation to them.

### <u>2. The Ecosystem</u>
The Ecosystems basic ideas also heavily relies on the idea that 'WesternWars' had in mind, so it  is providet through crates.
These Crates are spawned at fixed Locations on the Map and contain of different rarities and contents based on those rarities.

The different rarities have different loot pools to...
- ...make it feel more satisfying while looting and farming
- ...make specific items more rare and modify the amount of items on the server more.

Enchanted Books are handled in their own way, they get their own builder and are handled differently. Effectively every crate
(except for mythic ones) can contain of the same enchants but just in different levels. This way it still is satisfying to 
get the same enchants off of better crates but there is no real difference amongst the rarity of most enchantments on the 
server.

> ## Crate rarities and their loot containers
> ### Common Crates (42% of Crates)
> Common crates are, as the name makes kinda obvious, the most common crates and therefore consist of the most basic loot.
> For Example the loot pool contains of....
> - ...Arrows, Paper, Leather, Books and other Basic Resources
> - ...Enchantments of the "Standard Pool" at Enchantment Level I 
> - ...The most basic resources for crafting special resources to obtain certain specialitems
> ### Uncommon Crates (28% of Crates)
> Uncommon crates have the main purpose of making farming more attractive with them beeing kind of common still,
> but just with a little better loot. The loot pool still contains of...
> - ...Arrows, Paper, Leather, Books and other Basic Resources (just more of them)
> - ...Enchantments of the "Standard Pool" at Enchantment Level II
> - ...more of the basic resources, making the obtaining of special items easier
> ### Epic Crates (19% of Crates)
> Epic crates are pretty uncommon and consist of pretty strong loot. For example...
> - ...The basic special Resources for special items
> - ...Enchantments of the "Standard Pool" at Enchantment Level III and some special extra ones
> - ...Some specific Special Items extra designed for these crates
>
> So epic crates are the perfect balance of "interesting loot" and "amount of spawning"
> ### Legendary Crates (9% of Crates)
> Legendary crates are designed to be a pretty rare but powerful change in the common behaviour of
> farming crates.
> They contain of all of the above and also...
> - ...The first maxed out enchanted Books
> - ...The first Potions (Potion of Speed II)
> - ...Golden Apples, to make fighting without  a full armor equipped possible
>    / easier
> ### Mythic Crates (2% of Crates)
> Mythic crates are the rarest of all crates. Therefore they consist of the
> best possible Loot, that could be there
> For example they contain of...
> - only maxed out enchanted Books, also they are the only Crates to contain Mending Books
> - enchanted golden apples, making it really easy to fight without for example your helmet
> - some special Items specific to the player who opened them

### <u>3. The Commands</u>

### <u>4. The Specialitems</u>
First of all, you can look up every single Special Item using the ``/specialitems``-command.

## Summary & Note of thanks <br>
### <u>So all in all...</u>
### <u>Note of thanks </u>
A Big thanks goes to a lot of people, who helped me in the process, finding ideas, keeping me motivated, 
helping me making my code better and so much more...
So with that said a <b>huge</b> thanks goes to... <br>
``Affen_Herzog`` <br>
``Thunderdeus_XD``<br>
``_LMEmi``<br>
``DieSeelenlose``<br>
``Klysma``<br>
``TheReidenS``<br>
``MarciWay``<br>
``nichtkinq``<br>
``Hansi159``<br>
``jookobo``<br>
``Shildii``<br>
<br>
You all are just really really nice guys, thanks for all you did and especially for your help in this plugin of course! <3 