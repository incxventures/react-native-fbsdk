/**
* Support deep linking.
*/

package com.facebook.reactnative.androidsdk;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Promise;

import com.facebook.applinks.AppLinkData;

import java.math.BigDecimal;
import java.util.Currency;


public class FBAppLinkData extends ReactContextBaseJavaModule {

    public FBAppLinkData(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "FBAppLinkData";
    }

    @ReactMethod
    public void getDeferredDeepLink(final Promise promise){
      AppLinkData.fetchDeferredAppLinkData(getCurrentActivity(),
        new AppLinkData.CompletionHandler() {
           @Override
           public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
               // Process app link data
               if(appLinkData == null){
                 promise.resolve(null);
                 return;
               }

               promise.resolve(appLinkData.getTargetUri().toString());
           }
       }
      );
    }

}
