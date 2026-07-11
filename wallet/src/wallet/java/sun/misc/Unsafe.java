//stub file fix build
package sun.misc;

import java.lang.reflect.Field;

public final class Unsafe {
    private static final Unsafe THE_ONE = new Unsafe();
    private Unsafe() {}
    public static Unsafe getUnsafe() { return THE_ONE; }

    // Guava needs these - stub returning dummy values, Guava will fallback to AtomicFieldUpdater when it fails
    public long objectFieldOffset(Field f) { return 0L; }
    public int arrayBaseOffset(Class<?> c) { return 0; }
    public int arrayIndexScale(Class<?> c) { return 1; }
    public boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) { return false; }
    public boolean compareAndSwapLong(Object o, long offset, long expected, long x) { return false; }
    public boolean compareAndSwapInt(Object o, long offset, int expected, int x) { return false; }
    public Object getObjectVolatile(Object o, long offset) { return null; }
    public void putObjectVolatile(Object o, long offset, Object x) {}
    public void putOrderedObject(Object o, long offset, Object x) {}
    public long getLongVolatile(Object o, long offset) { return 0L; }
    public void putLongVolatile(Object o, long offset, long x) {}
    public long getAndAddLong(Object o, long offset, long delta) { return 0L; }
    public int getIntVolatile(Object o, long offset) { return 0; }
    public void putIntVolatile(Object o, long offset, int x) {}
    public Object getObject(Object o, long offset) { return null; }
    public void putObject(Object o, long offset, Object x) {}
    public long getLong(Object o, long offset) { return 0L; }
    public void putLong(Object o, long offset, long x) {}
    public byte getByte(long address) { return 0; }
    public void putByte(long address, byte b) {}
    public int getInt(long address) { return 0; }
}
