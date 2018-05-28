package com.hongyun.cordova.plugin.liveclient;

import android.content.Intent;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;

/**
 * Created by Administrator on 2017/1/6.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

public class LiveClient extends CordovaPlugin {

    public static final int REQUEST_CODE = 0x0ba7c0de;

    private static final String START_ACTIVITY = "startActivity";
    private static final String START_INTENT   = "com.alivc.testmediaplayer.MainActivity";

    private CallbackContext callbackContext;

    public LiveClient(){}

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

        this.callbackContext = callbackContext;

        if (action.equals(START_ACTIVITY)) {

            Intent intentStart = new Intent(START_INTENT);

            intentStart.addCategory(Intent.CATEGORY_DEFAULT);

            intentStart.setPackage(this.cordova.getActivity().getApplicationContext().getPackageName());

            this.cordova.startActivityForResult((CordovaPlugin) this, intentStart, REQUEST_CODE);

        }

        return true;
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        this.callbackContext.success("");
    }
}
