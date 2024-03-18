import cz.jrp.atomic.RoundRobinGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoundRobinGeneratorTest {


    @Test
    void getAtomic() {
        RoundRobinGenerator r = new RoundRobinGenerator(new String[]{
                "one",
                "two",
                "three"
        });

        assertThat(r.getAtomic()).isEqualTo("one");
        assertThat(r.getAtomic()).isEqualTo("two");
        assertThat(r.getAtomic()).isEqualTo("three");
        assertThat(r.getAtomic()).isEqualTo("one");

    }

    @Test
    void getSynchronized() {
        RoundRobinGenerator r = new RoundRobinGenerator(new String[]{
                "one",
                "two",
                "three"
        });

        assertThat(r.getSynchronized()).isEqualTo("one");
        assertThat(r.getSynchronized()).isEqualTo("two");
        assertThat(r.getSynchronized()).isEqualTo("three");
        assertThat(r.getSynchronized()).isEqualTo("one");

    }
    @Test
    void getVolatile() {
        RoundRobinGenerator r = new RoundRobinGenerator(new String[]{
                "one",
                "two",
                "three"
        });

        assertThat(r.getVolatile()).isEqualTo("one");
        assertThat(r.getVolatile()).isEqualTo("two");
        assertThat(r.getVolatile()).isEqualTo("three");
        assertThat(r.getVolatile()).isEqualTo("one");

    }



}
