package hackerschool.aachen.minecraftmod;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK;

public class SchleifenBeispiel {
    @SubscribeEvent
    public void midasTouch(PlayerInteractEvent event) {
        if (event.action == RIGHT_CLICK_BLOCK) {
            BlockPos pos = event.pos;
            World world = event.world;
            IBlockState goldBlockState = Blocks.gold_block.getDefaultState();

            world.setBlockState(pos, goldBlockState);
            for (EnumFacing ef : EnumFacing.VALUES) { // for each
                BlockPos richtung = pos.offset(ef);
                IBlockState blockRichtung = world.getBlockState(richtung);
                if (!blockRichtung.getBlock().equals(Blocks.air)) {
                    world.setBlockState(richtung, goldBlockState);
                }
            }
        }
    }
}
