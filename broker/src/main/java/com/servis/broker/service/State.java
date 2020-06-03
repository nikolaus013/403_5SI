package com.servis.broker.service;

import com.servis.broker.model.Context;
import com.servis.broker.model.Service1;
import com.servis.broker.model.ServiceRequest;

public interface State {

    Context callService(Context context);


}
