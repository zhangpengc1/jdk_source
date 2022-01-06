package com.marton.base.num;

/**
 * @author ：zhangp
 * @Date ：2021-12-30 15:17
 */
public class MaByte extends MaNumber {

    public static void main(String[] args) {

        Byte bye = new Byte("100");

        // 缓存

        // 拆箱装箱 valueOf

        // parseByte

    }

    /************** 源码分析 1.缓存*****************/
    /**
     * 缓存了 -127 - 128的值在一个Byte数组里
     * cache[0] -127
     */
    private static class ByteCache {
        private ByteCache() {
        }

        static final Byte cache[] = new Byte[-(-128) + 127 + 1];

        static {
            for (int i = 0; i < cache.length; i++)
                cache[i] = new Byte((byte) (i - 128));
        }
    }
//    取的时候，直接用 b + 128的偏移量
//    public static Byte valueOf(byte b) {
//        final int offset = 128;
//        return Byte.ByteCache.cache[(int)b + offset];
//    }











}
