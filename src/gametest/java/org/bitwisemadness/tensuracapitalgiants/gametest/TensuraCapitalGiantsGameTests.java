package org.bitwisemadness.tensuracapitalgiants.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
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

    /** The Giants capital is a registered structure and its central tag resolves. */
    @GameTest(template = "empty")
    public static void capital_registered_and_tagged(GameTestHelper helper) {
        var registry = helper.getLevel().registryAccess().registryOrThrow(Registries.STRUCTURE);
        var key = net.minecraft.resources.ResourceKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath(TensuraCapitalGiants.MOD_ID, "giants"));
        helper.assertTrue(registry.getHolder(key).isPresent(), "the Giants capital structure is not registered");
        var tag = net.minecraft.tags.TagKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath("tensura_faction_spawn", "capital/giants"));
        var holders = registry.getTag(tag);
        helper.assertTrue(holders.isPresent() && holders.get().size() > 0, "the Giants capital tag does not resolve");
        helper.succeed();
    }
}