package r7sy;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;

import android.content.Context;
import android.net.Uri;
import android.app.Activity;


public class FinishWithResult extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
           try {
                
				Uri uri = Uri.parse(args.getString(0));
              Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND, uri);
            this.cordova.getActivity().setResult(Activity.RESULT_OK, shareIntent); 
           this.cordova.getActivity().finish(); 
               

                return true;
            } catch (Exception e) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, e.toString()));
            }
       

        return false;
    }
}


