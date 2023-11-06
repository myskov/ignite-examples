import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgnitionManager;
import org.apache.ignite.InitParameters;
import org.junit.jupiter.api.Test;

public class IgniteTest {

    private final String WORKDIR_PATH = "build/wokdir";

    private final String CONFIG_PATH = IgniteTest.class.getClassLoader().getResource("ignite-config.conf").getPath();

    @Test
    public void igniteTest() throws Exception {
        CompletableFuture<Ignite> igniteFuture = IgnitionManager.start(
            "node1",
            Paths.get(CONFIG_PATH),
            Paths.get(WORKDIR_PATH)
        );

        InitParameters initParameters = InitParameters.builder()
            .destinationNodeName("node1")
            .metaStorageNodeNames(List.of("node1"))
            .clusterName("cluster")
            .build();

        IgnitionManager.init(initParameters);

        Ignite ignite = igniteFuture.get();



    }
}
