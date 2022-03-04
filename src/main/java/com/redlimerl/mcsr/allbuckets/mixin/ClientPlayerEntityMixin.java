package com.redlimerl.mcsr.allbuckets.mixin;

import com.mojang.authlib.GameProfile;
import com.redlimerl.mcsr.allbuckets.AllBuckets;
import com.redlimerl.speedrunigt.timer.InGameTimer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends PlayerEntity {

    private static final ArrayList<Item> GOAL_ITEMS = new ArrayList<>();
    static {
        GOAL_ITEMS.add(Items.BUCKET);
        GOAL_ITEMS.add(Items.LAVA_BUCKET);
        GOAL_ITEMS.add(Items.MILK_BUCKET);
        GOAL_ITEMS.add(Items.WATER_BUCKET);
    }

    public ClientPlayerEntityMixin(World world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method = "tick", at = @At("TAIL"))
    public void onTicking(CallbackInfo ci) {
        if (InGameTimer.getInstance().getCategory() == AllBuckets.ALL_BUCKETS_CATEGORY && InGameTimer.getInstance().isPlaying()) {
            ArrayList<Item> itemList = new ArrayList<>();
            for (ItemStack itemStack : this.inventory.field_15082) {
                if (itemStack != null && itemStack.getItem() != null && !itemList.contains(itemStack.getItem())) itemList.add(itemStack.getItem());
            }
            for (ItemStack itemStack : this.inventory.field_15084) {
                if (itemStack != null && itemStack.getItem() != null && !itemList.contains(itemStack.getItem())) itemList.add(itemStack.getItem());
            }

            if (itemList.containsAll(GOAL_ITEMS)) {
                InGameTimer.complete();
            }
        }
    }
}
