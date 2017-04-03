'use strict';

const AppLinkData = require('react-native').NativeModules.FBAppLinkData;

import {
  Platform
} from 'react-native';

module.exports = {

  getDeferredDeepLink(){
    return AppLinkData.getDeferredDeepLink().then((deepLink) => {
      if(deepLink){
        return deepLink;
      }
      return null;
    });
  }

};
