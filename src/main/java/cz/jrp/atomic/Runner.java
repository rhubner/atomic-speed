package cz.jrp.atomic;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, warmups = 1)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS, iterations = 2)
@Threads(32)
public class Runner {
    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    RoundRobinGenerator r;

    @Setup(Level.Iteration)
    public void setup() {
        r = new RoundRobinGenerator(new String[]{"one", "two", "three"});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String getAtomic() {
        return r.getAtomic();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String getSynchronized() {
        return r.getSynchronized();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String getVolatile() {
        return r.getVolatile();
    }



}