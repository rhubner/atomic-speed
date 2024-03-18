package cz.jrp.atomic;

import java.util.concurrent.atomic.AtomicLong;

public class RoundRobinGenerator {

    private final String[] data;

    private final AtomicLong atomicIndex = new AtomicLong();

    private long index = 0;

    private volatile long volatileIndex = 0;


    public RoundRobinGenerator(String[] data) {
        this.data = data;
    }

    public String getAtomic() {
        return data[(int)(atomicIndex.getAndIncrement() % data.length)];
    }

    public synchronized String getSynchronized() {
        return data[(int)(index++ % data.length)];
    }

    public String getVolatile() {
        return data[(int)(volatileIndex++ % data.length)];
    }



}
