import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {

	
	private static final int STANDARD_DECAY = 1;
	private static final int EXPIRED_DECAY = 2*STANDARD_DECAY;
	
	private static final int ANY_QUALITY = 40;
	private static final int ANY_SELLIN = 14;
	
	private static final int EXPIRED_SELLIN = 0;

	Item product;

	@Before
	public void setUp() {

		GildedRose.items = new ArrayList<Item>();
		product = new Item("ANY_NAME", ANY_SELLIN, ANY_QUALITY);
		GildedRose.items.add(product);

	}

	@Test
	public void qualityShouldDecay() {

		GildedRose.updateQuality();

		assertEquals("Quality should have decay", ANY_QUALITY - STANDARD_DECAY,
				product.getQuality());
	}

	@Test
	public void qualityDecayFasterWhenExpired() {
		product.setSellIn(EXPIRED_SELLIN);

		GildedRose.updateQuality();

		assertEquals("Quality should  decay faster",
				ANY_QUALITY - EXPIRED_DECAY  , product.getQuality());

	}

}
