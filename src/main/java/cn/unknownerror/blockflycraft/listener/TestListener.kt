package cn.unknownerror.blockflycraft.listener

import cn.unknownerror.blockflycraft.BlockFlyCraft
import cn.unknownerror.blockflycraft.api.block.ArmorStandBlock
import com.sun.xml.internal.ws.assembler.jaxws.MustUnderstandTubeFactory
import io.izzel.taboolib.module.inject.TListener
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent
import org.bukkit.util.EulerAngle
import java.util.function.Consumer
import kotlin.math.cos
import kotlin.math.sin

@TListener
class TestListener : Listener{
    @EventHandler
    fun onPlayerChat(e: PlayerChatEvent){
        val block1 = ArmorStandBlock(Material.DIAMOND_BLOCK,1.0,0.0,0.0,e.player.location)
        val block2 = ArmorStandBlock(Material.DIAMOND_BLOCK,0.0,0.0,0.0,e.player.location)
        val block3 = ArmorStandBlock(Material.DIAMOND_BLOCK,-1.0,0.0,0.0,e.player.location)
        block1.getArmorStand()
        block2.getArmorStand()
        block3.getArmorStand()
        Bukkit.getScheduler().runTaskTimer(BlockFlyCraft.plugin,
            Runnable {
                val loc = e.player.eyeLocation
                val vector = loc.direction
                val degree = loc.yaw.toDouble()
                val radian = Math.toRadians(degree)
                block1.getArmorStand().teleport(loc.add(1.0* cos(radian) - 0.0* sin(radian) ,0.0,1.0* sin(radian) + 0.0* cos(radian)))
                block3.getArmorStand().teleport(loc.add(-1.0* cos(radian) - 0.0* sin(radian) ,0.0,-1.0* sin(radian) + -0.0* cos(radian)))
                e.player.sendMessage(degree.toString())
                e.player.sendMessage(radian.toString())
        },0,1)
    }
}