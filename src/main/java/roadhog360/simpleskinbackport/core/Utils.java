package roadhog360.simpleskinbackport.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Utils {
    private static final ResourceLocation[] DEFAULT_SKINS = new ResourceLocation[] {
        new ResourceLocation("textures/entity/player/slim/alex.png"),
        new ResourceLocation("textures/entity/player/slim/ari.png"),
        new ResourceLocation("textures/entity/player/slim/efe.png"),
        new ResourceLocation("textures/entity/player/slim/kai.png"),
        new ResourceLocation("textures/entity/player/slim/makena.png"),
        new ResourceLocation("textures/entity/player/slim/noor.png"),
        new ResourceLocation("textures/entity/player/slim/steve.png"),
        new ResourceLocation("textures/entity/player/slim/sunny.png"),
        new ResourceLocation("textures/entity/player/slim/zuri.png"),

        new ResourceLocation("textures/entity/player/wide/alex.png"),
        new ResourceLocation("textures/entity/player/wide/ari.png"),
        new ResourceLocation("textures/entity/player/wide/efe.png"),
        new ResourceLocation("textures/entity/player/wide/kai.png"),
        new ResourceLocation("textures/entity/player/wide/makena.png"),
        new ResourceLocation("textures/entity/player/wide/noor.png"),
        new ResourceLocation("textures/entity/player/wide/steve.png"),
        new ResourceLocation("textures/entity/player/wide/sunny.png"),
        new ResourceLocation("textures/entity/player/wide/zuri.png")};

    public static int getIndexFromUUID(UUID uuid) {
        if(uuid == null) { //TODO Config to not use new skins perhaps?
            return 15;
        }
        return Math.floorMod(uuid.hashCode(), DEFAULT_SKINS.length);
    }

    public static ResourceLocation getDefaultSkin(UUID uuid) {
        return DEFAULT_SKINS[getIndexFromUUID(uuid)];
    }

    public static boolean isDefaultSkinSlim(UUID uuid) {
        return getIndexFromUUID(uuid) < DEFAULT_SKINS.length / 2;
    }

    public static boolean getSlimFromBase64Data(String base64) {
        JsonObject props = new Gson().fromJson(new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_8),
            JsonObject.class);
        return props.getAsJsonObject("textures").getAsJsonObject("SKIN").getAsJsonObject("metadata").get("model").getAsString().equals("slim");
    }
}
