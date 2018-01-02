package com.mengchaob.util;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class initVertical extends AbstractVerticle{
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        ContextDFZW.init();
        MybatisInit.init(startFuture);
    }
}
