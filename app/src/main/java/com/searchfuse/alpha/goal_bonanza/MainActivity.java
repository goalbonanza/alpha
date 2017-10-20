package com.searchfuse.alpha.goal_bonanza;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ethereum.crypto.ECKey;
import org.spongycastle.util.encoders.Hex;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Web3j web3;

    String gbTokenAddress = "0x0";
    String myAddress = "0x0";
    String myPrivateKey = "private_key";

    String gbEthaddress = "0x0";

    //Credentials credentials = Credentials.create(myPrivateKey);

    TextView txtView_balance;
    TextView txtView_trans_receipt;
    EditText etxt_amount;
    Button btn_place_bet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView_balance = (TextView) findViewById(R.id.txtBalance);
        txtView_trans_receipt = (TextView) findViewById(R.id.txtReceipt);
        etxt_amount = (EditText) findViewById(R.id.etxt_amount_token);
        btn_place_bet = (Button) findViewById(R.id.btnSendBet);
        btn_place_bet.setOnClickListener(this);

        web3 = Web3jFactory.build(new HttpService());
        //checkGoalBalance();
        //checkGoalBalance();

        ECKey ecKey = new ECKey();
        byte[] addr = ecKey.getAddress();
        byte[] priv = ecKey.getPrivKeyBytes();

        String addrBase16 = Hex.toHexString(addr);
        String privBase16 = Hex.toHexString(priv);



        Log.e("KEY_FILE", addrBase16);
        Log.e("KEY_FILE", privBase16);
    }

//    private void checkGoalBalance() {
//        MyToken token = MyToken.load(gbTokenAddress, web3, credentials, new BigInteger(String.valueOf(300000)), new  BigInteger(String.valueOf(24)));
//        Future<Uint256> myBalance = token.balanceOf(new Address(myAddress));
//        try {
//            Uint256 uint256  = myBalance.get();
//            txtView_balance.setText(uint256.getValue().toString() + " Tokens (remaining)");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSendBet :
           //     new SendBet().execute();
                break;
        }
    }

//    private class SendBet extends AsyncTask<String, String, String> {
//        @Override
//        protected String doInBackground(String... params) {
//            String result = null;
//
//            try {
//                long amount = Long.parseLong(etxt_amount.getText().toString());
//                Uint256 amountToTransfer = new Uint256(amount);
//                MyToken token = MyToken.load(gbTokenAddress, web3, credentials, BigInteger.valueOf(30 + 500000000000L), new  BigInteger(String.valueOf(500000)));
//                TransactionReceipt receipt = token.transfer(new Address(gbEthaddress), amountToTransfer).get(3, TimeUnit.MINUTES);
//                result = receipt.getTransactionHash();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } catch (TimeoutException e) {
//                e.printStackTrace();
//            }
//
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            txtView_trans_receipt.setText(result);
//            checkGoalBalance();
//            etxt_amount.setText("");
//        }
//    }
}
