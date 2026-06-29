package wallet.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import org.bitcoinj.core.*;
import org.bitcoinj.script.ScriptException;
import org.bitcoinj.wallet.Wallet;
import java.text.SimpleDateFormat;
import java.util.*;
import wallet.WalletApplication;

public class TransactionDetailsActivity extends Activity {
    private TextView tvAmount, tvStatus, tvFee, tvTime, tvFrom, tvTo, tvTxid, tvHeight, tvDirection;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);
        tvDirection=findViewById(R.id.tv_direction);
        tvAmount=findViewById(R.id.tv_amount);
        tvStatus=findViewById(R.id.tv_status);
        tvFee=findViewById(R.id.tv_fee);
        tvTime=findViewById(R.id.tv_time);
        tvFrom=findViewById(R.id.tv_from);
        tvTo=findViewById(R.id.tv_to);
        tvTxid=findViewById(R.id.tv_txid);
        tvHeight=findViewById(R.id.tv_height);

        String txidStr = getIntent().getStringExtra("txid");
        Wallet wallet = ((WalletApplication)getApplication()).getWallet();
        Transaction tx = wallet.getTransaction(Sha256Hash.wrap(txidStr));
        if(tx==null){finish();return;}

        Coin value = tx.getValue(wallet);
        boolean isReceive = value.isPositive();
        tvDirection.setText(isReceive ? "Receive" : "Sent");
        tvAmount.setText((isReceive?"+":"-") + value.toPlainString().replace("-","") + " BTC");

        TransactionConfidence c = tx.getConfidence();
        if(c.getConfidenceType()==TransactionConfidence.ConfidenceType.BUILDING){
            tvStatus.setText("Success"); tvStatus.setTextColor(0xFF00C853);
        } else { tvStatus.setText("Pending"); tvStatus.setTextColor(0xFFFFC107); }

        Coin fee = tx.getFee();
        tvFee.setText(fee!=null ? fee.toPlainString()+" BTC" : "—");
        if(tx.getUpdateTime()!=null)
            tvTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(tx.getUpdateTime()));

        Set<String> from = new LinkedHashSet<>();
        for(TransactionInput in : tx.getInputs()){ try{ Address a=in.getFromAddress(); if(a!=null) from.add(a.toString()); }catch(ScriptException ignored){} }
        String fromText = from.isEmpty() ? "Coinbase" : TextUtils.join("\n", from);
        tvFrom.setText(fromText); tvFrom.setOnClickListener(v->copy(fromText));

        Set<String> to = new LinkedHashSet<>();
        for(TransactionOutput out : tx.getOutputs()){
            boolean mine = out.isMineOrWatched(wallet);
            if(isReceive && mine || !isReceive && !mine){
                try{ to.add(out.getScriptPubKey().getToAddress(wallet.getNetworkParameters(),true).toString()); }catch(Exception ignored){}
            }
        }
        String toText = TextUtils.join("\n", to);
        tvTo.setText(toText); tvTo.setOnClickListener(v->copy(toText));

        String hash = tx.getTxId().toString();
        tvTxid.setText(hash.substring(0,6)+"…"+hash.substring(hash.length()-6));
        tvTxid.setOnClickListener(v->copy(hash));

        int h = c.getAppearedAtChainHeight();
        tvHeight.setText(h>0?String.valueOf(h):"—");
    }
    private void copy(String s){
        ((ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE))
            .setPrimaryClip(ClipData.newPlainText("tx", s));
        Toast.makeText(this,"Copied",Toast.LENGTH_SHORT).show();
    }
}
