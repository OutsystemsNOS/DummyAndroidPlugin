package cordova.Atmosphere.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import android.content.Context;
import android.content.Intent;


public class ActivityExternalWebView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String package_name = getApplication().getPackageName();
        setContentView(getApplication().getResources().getIdentifier("layout_activity_external_webview", "layout", package_name));
        Intent intent = getIntent();
        String name = intent.getStringExtra("filename");
        String cancel = intent.getStringExtra("cancel");
        String ok = intent.getStringExtra("ok");
        Integer showButtons = 2;//intent.getIntExtra("showButtons", 0);

        WebView webView = (WebView)findViewById(getResources().getIdentifier("webViewMain", "id", getPackageName()));
        webView.loadUrl("http://www.google.com");

        webView.setWebViewClient(new WebViewClient());


        /*
        Button btnOK = (Button)findViewById(getResources().getIdentifier("btnok", "id", getPackageName()));

        if(showButtons == 1 || showButtons == 2) {
            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("action", "1");
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            });
            btnOK.setText(ok);
            btnOK.setVisibility(View.VISIBLE);

            Button btnCancel = (Button) findViewById(getResources().getIdentifier("btncancel", "id", getPackageName()));
            if (showButtons == 2) {
                btnCancel.setText(cancel);
                btnCancel.setVisibility(View.VISIBLE);
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
            }
        }
        */
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("action", "0");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
