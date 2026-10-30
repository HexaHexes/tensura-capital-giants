package org.bitwisemadness.tensuracapitalgiants.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import org.bitwisemadness.tensuracapitalgiants.TensuraCapitalGiants;

/** Smoke test: the mod loads and the gametest harness runs. */
@GameTestHolder(TensuraCapitalGiants.MOD_ID)
@PrefixGameTestTemplate(false)
public final class TensuraCapitalGiantsGameTests {

    private TensuraCapitalGiantsGameTests() {
    }

    @GameTest(template = "empty")
    public static void mod_loads(GameTestHelper helper) {
        helper.succeed();
    }
}