package testing.vls.com.goal_bonanza;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    Web3j web3;

    String tokenAddress = "0x99cb673eCBcfCBf68eDf066F74D025f4092609D9";
    String myAddress = "0x8b811dad25ad26856da0422e7b51c3ff0b685722";
    String myPrivateKey = "78a54dbc9c4ab002a2a07441200fa5fc64160ea9f199a14da8384317c6173e07";

    String addressTransfer = "0xE2f0e24b2deB1885d8cDbd2FD10Ee1b806007296";

    Credentials credentials = Credentials.create(myPrivateKey);

    TextView textView;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txtBalance);
        textView1 = (TextView) findViewById(R.id.txtReceipt);

        web3 = Web3jFactory.build(new HttpService("https://ropsten.infura.io/PAIMKYJh3XJa5HI1zekm"));

        MyToken token = MyToken.load(tokenAddress, web3, credentials, new BigInteger(String.valueOf(300000)), new  BigInteger(String.valueOf(24)));
        Future<Uint256> myBalance = token.balanceOf(new Address(myAddress));
        try {
            Uint256 uint256  = myBalance.get();
            textView.setText(uint256.getValue().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new WriteTask().execute();
    }

    private class WriteTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = null;

            try {
                Uint256 amountToTransfer = new Uint256(10);
                MyToken token = MyToken.load(tokenAddress, web3, credentials, BigInteger.valueOf(30 + 500000000000L), new  BigInteger(String.valueOf(500000)));
                TransactionReceipt receipt = token.transfer(new Address(addressTransfer), amountToTransfer).get(3, TimeUnit.MINUTES);
                result = receipt.getGasUsed().toString();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            textView1.setText(result);
        }
    }
}
