package com.app.mobile.api.login.response;

import com.app.mobile.model.AppFeaturesPermission;
import com.app.mobile.model.AppPermission;
import com.app.mobile.model.Session;
import com.app.mobile.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseLogin {

      String message;
      int statusCode;
      User user;
      String token;
      Session session;
      AppPermission appPermission;
      AppFeaturesPermission  appFeaturesPermission;



}
