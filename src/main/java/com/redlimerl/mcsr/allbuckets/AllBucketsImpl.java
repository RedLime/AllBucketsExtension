package com.redlimerl.mcsr.allbuckets;

import com.redlimerl.speedrunigt.api.SpeedRunIGTApi;
import com.redlimerl.speedrunigt.timer.running.RunCategory;

public class AllBucketsImpl implements SpeedRunIGTApi {

    @Override
    public RunCategory registerCategory() {
        return AllBuckets.ALL_BUCKETS_CATEGORY;
    }
}
