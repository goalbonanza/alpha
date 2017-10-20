package searchfuse.com.ethereumj;

import org.ethereum.crypto.ECKey;

/**
 * Created by sf-macmini on 20/10/2017.
 */

public class UtilEthereumj {
    public static ECKey ecKey;
    public static ECKey getEcKey() {
        return new ECKey();
    }
}
