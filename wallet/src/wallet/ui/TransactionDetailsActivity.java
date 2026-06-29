package de.schildbach.wallet.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import de.schildbach.wallet.Constants;
import de.schildbach.wallet.WalletApplication;
import de.schildbach.wallet.R;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.ScriptException;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionInput;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptPattern;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransactionDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_TX_HASH = "transaction_hash";
    private Transaction tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Transaction Details");
        }

        String txHash = getIntent().getStringExtra(EXTRA_TX_HASH);
        if (txHash == null) { finish(); return; }

        WalletApplication app = (WalletApplication) getApplication();
        tx = app.getWallet().getTransaction(org.bitcoinj.core.Sha256Hash.wrap(txHash));
        if (tx == null) { finish(); return; }

        bindTransaction(tx);

        TextView txIdView = findViewById(R.id.tx_id);
        txIdView.setText(tx.getTxId().toString());
        txIdView.setOnClickListener(v -> {
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setPrimaryClip(ClipData.newPlainText("txid", tx.getTxId().toString()));
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        });
    }

    private void bindTransaction(Transaction tx) {
        // Amount
        Coin value = tx.getValue(((WalletApplication)getApplication()).getWallet());
        TextView amountView = findViewById(R.id.tx_amount);
        TextView dirView = findViewById(R.id.tx_direction_label);
        boolean isSent = value.signum() < 0;
        dirView.setText(isSent ? "Sent" : "Received");
        amountView.setText(value.toPlainString() + " BTC");
        amountView.setTextColor(ContextCompat.getColor(this,
                isSent ? R.color.tx_amount_sent : R.color.tx_amount_recv));

        // Status
        TextView statusView = findViewById(R.id.tx_status);
        int depth = 0;
        try { depth = tx.getConfidence().getDepthInBlocks(); } catch (Exception ignored) {}
        if (depth >= 6) {
            statusView.setText("Confirmed");
            statusView.setTextColor(ContextCompat.getColor(this, R.color.tx_status_ok));
        } else if (depth > 0) {
            statusView.setText("Building");
            statusView.setTextColor(ContextCompat.getColor(this, R.color.tx_status_building));
        } else {
            statusView.setText("Pending");
            statusView.setTextColor(ContextCompat.getColor(this, R.color.tx_status_pending));
        }

        // Fee
        Coin fee = tx.getFee();
        ((TextView)findViewById(R.id.tx_fee)).setText(fee != null ? fee.toPlainString() + " BTC" : "—");

        // Size / Weight
        int size = tx.getMessageSize();
        int weight = tx.getWeight();
        long feePerVb = fee != null ? fee.value / ((weight + 3) / 4) : 0;
        ((TextView)findViewById(R.id.tx_size)).setText(size + " bytes · " + weight + " wu · " + feePerVb + " sat/vB");

        // Confirmations
        ((TextView)findViewById(R.id.tx_confirmations)).setText(depth + " confirmations");

        // Time
        Date time = tx.getUpdateTime();
        if (time != null) {
            String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(time);
            ((TextView)findViewById(R.id.tx_time)).setText(s);
        }

        renderInputsOutputs(tx);
    }

    private void renderInputsOutputs(Transaction tx) {
        LinearLayout fromContainer = findViewById(R.id.from_container);
        TextView fromSummary = findViewById(R.id.from_summary);
        LinearLayout toContainer = findViewById(R.id.to_container);
        TextView toSummary = findViewById(R.id.to_summary);

        fromContainer.removeAllViews();
        toContainer.removeAllViews();

        // Inputs
        Coin totalIn = Coin.ZERO;
        int inCount = tx.getInputs().size();
        for (TransactionInput input : tx.getInputs()) {
            Coin value = input.getValue();
            if (value == null && input.getConnectedOutput() != null)
                value = input.getConnectedOutput().getValue();
            if (value != null) totalIn = totalIn.add(value);

            String address = "unknown";
            String type = "";
            try {
                if (input.getConnectedOutput() != null) {
                    Script script = input.getConnectedOutput().getScriptPubKey();
                    address = script.getToAddress(Constants.NETWORK_PARAMETERS).toString();
                    type = getScriptType(script);
                }
            } catch (ScriptException ignored) {}

            addIoRow(fromContainer, address, type, value);
        }
        fromSummary.setText("Total: " + totalIn.toPlainString() + " BTC from " + inCount);

        // Outputs
        Coin totalOut = Coin.ZERO;
        int outCount = tx.getOutputs().size();
        for (TransactionOutput out : tx.getOutputs()) {
            Coin value = out.getValue();
            totalOut = totalOut.add(value);

            String address = "unknown";
            String type = "";
            try {
                Script script = out.getScriptPubKey();
                address = script.getToAddress(Constants.NETWORK_PARAMETERS).toString();
                type = getScriptType(script);
            } catch (ScriptException ignored) {}

            addIoRow(toContainer, address, type, value);
        }
        toSummary.setText("Total: " + totalOut.toPlainString() + " BTC to " + outCount);
    }

    private void addIoRow(LinearLayout container, String address, String type, Coin value) {
        TextView tv = new TextView(this);
        String valStr = value != null ? value.toPlainString() + " BTC" : "? BTC";
        tv.setText(address + (type.isEmpty() ? "" : " (" + type + ")") + " - " + valStr);
        tv.setTextColor(ContextCompat.getColor(this, R.color.tx_text_primary));
        tv.setTextSize(13);
        tv.setPadding(0, 6, 0, 6);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        container.addView(tv, lp);
    }

    private String getScriptType(Script script) {
        if (ScriptPattern.isP2WPKH(script)) return "P2WPKH";
        if (ScriptPattern.isP2PKH(script)) return "P2PKH";
        if (ScriptPattern.isP2WSH(script)) return "P2WSH";
        if (ScriptPattern.isP2SH(script)) return "P2SH";
        return "";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
