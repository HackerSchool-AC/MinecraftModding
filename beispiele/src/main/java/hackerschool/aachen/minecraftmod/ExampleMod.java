package hackerschool.aachen.minecraftmod;

import net.minecraft.init.Items;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new MethodenBeispiel());
        new VerzweigungsBeispiel();
        MinecraftForge.EVENT_BUS.register(new SchleifenBeispiel());
        fieldChangeExample(ItemSword.class, "attackDamage", (ItemSword) Items.diamond_sword, 2048F);
    }

    private <T> void fieldChangeExample(Class<T> clazz, String fieldName, T obj, Object newValue) {
        try {
            Field someField = clazz.getDeclaredField(fieldName);

            someField.setAccessible(true);
            if ((someField.getModifiers() & Modifier.FINAL) != 0) {
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(someField, someField.getModifiers() & ~Modifier.FINAL);
            }

            someField.set(obj, newValue);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
