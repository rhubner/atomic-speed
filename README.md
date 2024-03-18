
This small program test speed of different synchronisation primitives to implement round-robin algorithm.

It's possible that JMH test is not perfect, especially I'm getting some strange results.
For example, `getSynchronized` is faster than  `getAtomic` for 8 and more cores. Or why `getAtomic` have more
throughput for 32 thread when CPU have max 12 physical cores(Yes 24 virtual).


**Disclaimer**
I don't think `getVolatile` works as we think. Volatile doesn't guarantee atomic increment. I just put it here
for curiosity.

```
Single thread:
Benchmark                Mode  Cnt          Score   Error  Units
Runner.getAtomic        thrpt    2  672 433 037.551          ops/s
Runner.getSynchronized  thrpt    2  274 596 638.595          ops/s
Runner.getVolatile      thrpt    2  686 033 086.909          ops/s

2 Threads
Benchmark                Mode  Cnt          Score   Error  Units
Runner.getAtomic        thrpt    2  122 224 990.223          ops/s
Runner.getSynchronized  thrpt    2   44 814 503.311          ops/s
Runner.getVolatile      thrpt    2   91 200 207.405          ops/s

4 Threads
Runner.getAtomic        thrpt    2   98 115 840.644          ops/s
Runner.getSynchronized  thrpt    2   59 045 139.606          ops/s
Runner.getVolatile      thrpt    2  121 487 144.157          ops/s

8 Threads
Runner.getAtomic        thrpt    2   50 428 735.584          ops/s
Runner.getSynchronized  thrpt    2   55 427 805.187          ops/s
Runner.getVolatile      thrpt    2   44 977 322.588          ops/s

12 Threads(native cores)
Runner.getAtomic        thrpt    2   34 619 851.468          ops/s
Runner.getSynchronized  thrpt    2   56 735 306.054          ops/s
Runner.getVolatile      thrpt    2   44 207 946.418          ops/s

32 Threads
Benchmark                Mode  Cnt         Score   Error  Units
Runner.getAtomic        thrpt    2   43 364 511.980          ops/s
Runner.getSynchronized  thrpt    2   54 073 718.881          ops/s
Runner.getVolatile      thrpt    2   38 150 398.451          ops/s

```