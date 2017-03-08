'use strict';

const AppLinkData = require('react-native').NativeModules.FBAppLinkData;

module.exports = {

  getDeferredDeepLink(){
    return AppLinkData.getDeferredDeepLink();
  }

};
