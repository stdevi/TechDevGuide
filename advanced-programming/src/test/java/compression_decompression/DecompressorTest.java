package compression_decompression;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecompressorTest {
    private Decompressor decompressor;

    @Before
    public void setUp() {
        decompressor = new Decompressor();
    }

    @Test
    public void decomp_1stLevelCompression_Decompressed() {
        String decomp = decompressor.decomp("3[abc]4[ab]c");
        assertEquals("abcabcabcababababc", decomp);
    }

    @Test
    public void decomp_2stLevelCompression_Decompressed() {
        String decomp = decompressor.decomp("2[3[a]b]4[2[a]]");
        assertEquals("aaabaaabaaaaaaaa", decomp);
    }

    @Test
    public void decomp_twoDigitNumber_Decompressed() {
        String decomp = decompressor.decomp("10[a]c");
        assertEquals("aaaaaaaaaac", decomp);
    }

    @Test
    public void decomp_0Appearance_Decompressed() {
        String decomp = decompressor.decomp("0[a]c");
        assertEquals("c", decomp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void decomp_WrongFormatWithoutNumber_ExceptionThrown() {
        decompressor.decomp("a[]c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decomp_WrongFormatWithoutClose_ExceptionThrown() {
        decompressor.decomp("2[a][");
    }

    @Test(expected = IllegalArgumentException.class)
    public void decomp_WrongFormatWithoutOpen_ExceptionThrown() {
        decompressor.decomp("2a]");
    }
}
