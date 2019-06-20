package com.bit.web.common.util;

import java.util.function.Consumer;

import com.bit.web.common.lambda.IConsumer;

import org.springframework.stereotype.Service;

/**
 * Printer
 */
@Service
public class Printer implements IConsumer{

    @Override
    public void accept(Object o) {
        Consumer <String> c = System.out :: println;
        c.accept((String)o);
    }

    
}