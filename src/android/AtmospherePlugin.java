package cordova.Atmosphere.plugin;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class AtmospherePlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showExternalWebView")) {
            String message = args.getString(0);
            this.showExternalWebView(message, callbackContext);
            return true;
        }
        return false;
    }

    private void showExternalWebView(String message, CallbackContext callbackContext) {


        if(true){
              Context context=this.cordova.getActivity().getApplicationContext();
              Intent intent=new Intent(context, ActivityExternalWebView.class);
              intent.putExtra("showButtons", false);
              intent.putExtra("filename", "http://unec.edu.az/application/uploads/2014/12/pdf-sample.pdf");
              intent.putExtra("cancel", "");
              intent.putExtra("ok", "");

              this.cordova.startActivityForResult((CordovaPlugin) this, intent, 0);
              return;
        }



        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
