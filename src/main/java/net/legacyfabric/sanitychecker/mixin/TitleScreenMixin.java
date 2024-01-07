package net.legacyfabric.sanitychecker.mixin;

import net.legacyfabric.sanitychecker.SanityChecker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin
{
	@Unique
	private static long initialTime;

	@Inject(at = @At("TAIL"), method = "render")
	private void init(CallbackInfo info)
	{
		if (initialTime == 0)
		{
			initialTime = System.currentTimeMillis();
		}

		long currentTime = System.currentTimeMillis();
		long timeElapsed = currentTime - initialTime;

		if (timeElapsed > 5000)
		{
			System.out.println("sane");
			SanityChecker.markSane();
			MinecraftClient.getInstance().scheduleStop();
		}
	}
}
