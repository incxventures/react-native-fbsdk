'use strict';

const AppLinkData = require('react-native').NativeModules.FBAppLinkData;

import {
  Platform
} from 'react-native';

module.exports = {

  getDeferredDeepLink(){
    // iOS not completed yet.
    if(Platform.OS === 'ios'){
      return Promise.resolve(null);
    }
    return AppLinkData.getDeferredDeepLink();
  }

};
