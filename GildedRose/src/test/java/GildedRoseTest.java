import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GildedRoseTest {

	private static final int QUALITY_DECAY = 1;
	private static final int ANY_QUALITY = 40;
	private static final int ANY_SELLIN = 14;

	@Test
	public void qualityShouldDecay() {

		Item product = new Item("ANY_NAME", ANY_SELLIN, ANY_QUALITY);
		GildedRose.items = new ArrayList<Item>();
		GildedRose.items.add(product);

		GildedRose.updateQuality();

		assertEquals("Quality should have decay", ANY_QUALITY - QUALITY_DECAY, product.quality);
	}
}
