package com.redlimerl.mcsr.allbuckets;

import com.redlimerl.speedrunigt.timer.running.RunCategory;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AllBuckets implements ClientModInitializer {

    public static final RunCategory ALL_BUCKETS_CATEGORY = new RunCategory("all_buckets", "mc_juice#All_Buckets", "All Buckets");

    @Override
    public void onInitializeClient() {

    }
}
