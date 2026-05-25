package georoot.hop;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Georoot implements ModInitializer {
	public static final String MOD_ID = "georoot";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("GeoRoot initialized.");
	}
}
