/**
 *
 *
 */

#import "RCTFBSDKAppLinkData.h"

#import "RCTConvert+FBSDKAccessToken.h"


@implementation RCTFBSDKAppLinkData

RCT_EXPORT_MODULE(FBAppLinkData);

#pragma mark - React Native Methods

RCT_EXPORT_METHOD(getDeferredDeepLink:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        [FBSDKAppLinkUtility fetchDeferredAppLink:^(NSURL *url, NSError *error) {
            if(error){
                reject(@"FacebookSDK", @"Fetch Deferred App Link Failed", error);
            }
            resolve(url.absoluteString);
        }];
    });
}


@end
