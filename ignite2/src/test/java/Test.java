import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

public class Test {
    @org.junit.jupiter.api.Test
    public void test() {
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Create an Ignite instance
        try (Ignite ignite = Ignition.start(cfg)) {
            CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<>("myCache");
            cacheCfg.setCacheMode(CacheMode.PARTITIONED);

            // Create an Ignite cache
            ignite.getOrCreateCache(cacheCfg);

            // Put data into the cache
            ignite.cache("myCache").put(1, "Hello, Ignite!");

            // Retrieve data from the cache
            String value = ignite.cache("myCache").get(1).toString();
            System.out.println("Cache Value: " + value);
        }
    }
}
