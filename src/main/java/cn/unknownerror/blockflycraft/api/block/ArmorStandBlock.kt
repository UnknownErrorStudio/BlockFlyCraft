package cn.unknownerror.blockflycraft.api.block

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.ArmorStand
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector

class ArmorStandBlock (val material: Material, val x : Double, val y : Double, val z : Double, private val location : Location){
    private lateinit var armorStand : ArmorStand
    val vector = Vector(x,y,z)

    fun getLocation() : Location{
        return location.clone()
    }

    fun getArmorStand(): ArmorStand{
        if(!::armorStand.isInitialized){
            armorStand = location.world?.spawnEntity(location.clone().add(x,y,z),EntityType.ARMOR_STAND) as ArmorStand
            armorStand.setHelmet(ItemStack(material))
            armorStand.isInvulnerable = true
            armorStand.isVisible = false
        }
        return armorStand
    }

    companion object{
        fun instance() : ArmorStandBlock?{
            return null
        }
    }
}
