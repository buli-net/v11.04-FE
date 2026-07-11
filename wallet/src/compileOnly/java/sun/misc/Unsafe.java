package sun.misc;

import java.lang.reflect.Field;

public final class Unsafe {
    private static final Unsafe THE_ONE = new Unsafe();
    public Unsafe() {}

    public static Unsafe getUnsafe() { return THE_ONE; }

    // offsets
    public long objectFieldOffset(Field f) { return 0L; }
    public long staticFieldOffset(Field f) { return 0L; }
    public Object staticFieldBase(Field f) { return null; }

    // array
    public int arrayBaseOffset(Class<?> c) { return 0; }
    public int arrayIndexScale(Class<?> c) { return 1; }

    // int
    public int getInt(Object o, long off) { return 0; }
    public void putInt(Object o, long off, int x) {}
    public int getIntVolatile(Object o, long off) { return 0; }
    public void putIntVolatile(Object o, long off, int x) {}
    public void putOrderedInt(Object o, long off, int x) {}

    // long
    public long getLong(Object o, long off) { return 0L; }
    public void putLong(Object o, long off, long x) {}
    public long getLongVolatile(Object o, long off) { return 0L; }
    public void putLongVolatile(Object o, long off, long x) {}
    public void putOrderedLong(Object o, long off, long x) {}

    // boolean, byte not needed but add
    public boolean getBooleanVolatile(Object o, long off) { return false; }
    public void putBooleanVolatile(Object o, long off, boolean x) {}

    // object
    public Object getObject(Object o, long off) { return null; }
    public void putObject(Object o, long off, Object x) {}
    public Object getObjectVolatile(Object o, long off) { return null; }
    public void putObjectVolatile(Object o, long off, Object x) {}
    public void putOrderedObject(Object o, long off, Object x) {}

    // CAS - Guava dùng nhiều nhất
    public boolean compareAndSwapInt(Object o, long off, int exp, int x) { return true; }
    public boolean compareAndSwapLong(Object o, long off, long exp, long x) { return true; }
    public boolean compareAndSwapObject(Object o, long off, Object exp, Object x) { return true; }

    // getAndAdd / getAndSet - Striped64, Atomic
    public int getAndAddInt(Object o, long off, int delta) { return 0; }
    public long getAndAddLong(Object o, long off, long delta) { return 0L; }
    public int getAndSetInt(Object o, long off, int v) { return 0; }
    public long getAndSetLong(Object o, long off, long v) { return 0L; }
    public Object getAndSetObject(Object o, long off, Object v) { return null; }

    // memory - Guava có thể gọi qua reflection
    public long allocateMemory(long bytes) { return 0L; }
    public long reallocateMemory(long addr, long bytes) { return 0L; }
    public void freeMemory(long addr) {}
    public void setMemory(Object o, long off, long bytes, byte v) {}
    public void copyMemory(Object src, long so, Object dst, long doff, long bytes) {}

    // misc
    public Object allocateInstance(Class<?> c) throws InstantiationException { return null; }
    public void throwException(Throwable t) {}
    public void park(boolean abs, long time) {}
    public void unpark(Object thread) {}
    public int pageSize() { return 4096; }
}
